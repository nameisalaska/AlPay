package alaska.web.servlets.admin;

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

public class AdminBlockUserServlet extends HttpServlet {
  private static final long serialVersionUID = 1L;
  private UserDao userDao = new UserDaoImpl();

  @Override
  protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    req.getRequestDispatcher("/WEB-INF/view/admin/forms/adminblockuser.jsp").forward(req, resp);
  }

  @Override
  protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    final String login = (String) req.getParameter("username");
    try {
      User user = userDao.findByLogin(login);
      if(user != null) {
      userDao.changeStatus(login, false);
      req.getRequestDispatcher("/WEB-INF/view/done.jsp").forward(req, resp);
      }else {
        final Locale language = (Locale) req.getSession().getAttribute("language");
        if (language.getLanguage().equals("ru")) {
          req.setAttribute("errorText", "Неправильное имя пользователя");
        } else {
          req.setAttribute("errorText", "Wrong login");
        }
        req.getRequestDispatcher("/WEB-INF/view/admin/forms/adminunblockuser.jsp").forward(req, resp);
      }
    } catch (NamingException | SQLException e) {
      e.printStackTrace();
    }
  }
}
