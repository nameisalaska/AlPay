package alaska.web.servlets;

import java.io.IOException;
import java.sql.SQLException;
import javax.naming.NamingException;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import alaska.web.dao.UserDao;
import alaska.web.dao.impl.UserDaoImpl;
import alaska.web.model.User;
import alaska.web.model.enums.UserType;

public class RegistrationServlet extends HttpServlet {

  private static final Logger log = LogManager.getLogger(RegistrationServlet.class);
  private static final long serialVersionUID = 1L;
  private UserDao userDao = new UserDaoImpl();

  public void init(ServletConfig config) throws ServletException {
    super.init(config);
  }

  @Override
  protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    req.getRequestDispatcher("login.jsp").forward(req, resp);
  }

  @Override
  protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    final String login =  req.getParameter("username");
    final String email = req.getParameter("email");
    final String password = req.getParameter("password");
    User user = new User(login, email, password, UserType.User, true);
    try {
      userDao.save(user);
  } catch (SQLException | NamingException e) {
     log.error(e);
  }
    req.getRequestDispatcher("signupconfirm.jsp").forward(req, resp);
  }
}
