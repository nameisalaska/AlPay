package alaska.web.servlets.admin;

import java.io.IOException;
import java.sql.SQLException;
import java.util.Set;
import javax.naming.NamingException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import alaska.web.dao.UserDao;
import alaska.web.dao.impl.UserDaoImpl;
import alaska.web.model.User;

public class AdminHomePageServlet extends HttpServlet {

  private UserDao userDao = new UserDaoImpl();
  private static final long serialVersionUID = 1L;
  private static final Logger log = LogManager.getLogger(AdminHomePageServlet.class);

  @Override
  protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    try {
      Set<User> usersForAdmin = userDao.findByStatus(true);
      req.getSession().setAttribute("usersForAdmin", usersForAdmin);
      req.getRequestDispatcher("/WEB-INF/view/admin/admin_homepage.jsp").forward(req, resp);
    } catch (SQLException | NamingException e) {
      log.error(e);
    }
  }

  @Override
  protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    doGet(request, response);
  }
}
