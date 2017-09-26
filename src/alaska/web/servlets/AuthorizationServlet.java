package alaska.web.servlets;

import java.io.IOException;
import java.sql.SQLException;
import java.util.Locale;
import javax.naming.NamingException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import alaska.web.dao.UserDao;
import alaska.web.dao.impl.UserDaoImpl;
import alaska.web.model.User;
import alaska.web.model.enums.UserType;

public class AuthorizationServlet extends HttpServlet {

  private UserDao userDao = new UserDaoImpl();
  private static final long serialVersionUID = 1L;

  @Override
  public void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    req.getRequestDispatcher("login.jsp").forward(req, resp);
  }

  @Override
  public void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    final String username = req.getParameter("username");
    try {
      final User user = userDao.findByLogin(username);
      if (user != null && req.getParameter("password").equals(user.getPassword())) {
        req.getSession().setAttribute("login", user.getLogin());
        req.getSession().setAttribute("email", user.getEmail());
        req.getSession().setAttribute("password", user.getPassword());
        req.getSession().setAttribute("type", user.getType());
        req.getSession().setAttribute("status", user.isStatus());
        final UserType type = user.getType();
        switch (type) {
        case User:
          req.getRequestDispatcher("/WEB-INF/view/client/user_homepage.jsp").forward(req, resp);
          break;
        case Admin:
          req.getRequestDispatcher("/WEB-INF/view/admin/admin_homepage.jsp").forward(req, resp);
          break;
        }
      } else {
        final Locale language = (Locale) req.getSession().getAttribute("language");
        System.out.println(req.getSession().getAttribute("language") + " 1");
        if (language.getLanguage().equals("ru")) {
          req.setAttribute("errorText", "Неправильное имя пользователя/пароль");
        } else {
          req.setAttribute("errorText", "Wrong login/password");
        }
        req.getRequestDispatcher("login.jsp").forward(req, resp);
      }
    } catch (SQLException | NamingException e) {
      e.printStackTrace();
    }
  }
}