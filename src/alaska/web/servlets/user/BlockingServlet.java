package alaska.web.servlets.user;

import java.io.IOException;
import java.sql.SQLException;
import javax.naming.NamingException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import alaska.web.dao.AccountDao;
import alaska.web.dao.impl.AccountDaoImpl;
import alaska.web.model.Account;

public class BlockingServlet extends HttpServlet {

  private static final Logger log = LogManager.getLogger(BlockingServlet.class);
  private AccountDao accountDao = new AccountDaoImpl();
  private static final long serialVersionUID = 1L;

  @Override
  protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    request.getRequestDispatcher("WEB-INF/view/client/forms/blockcard.jsp").forward(request, response);
  }

  @Override
  protected  void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    String number = (String) request.getParameter("cardnumber");
    try {
      accountDao.changeStatus(number, false, false);
      request.getRequestDispatcher("WEB-INF/view/done.jsp").forward(request, response);
    } catch (SQLException | NamingException e) {
      log.error(e);
    }
  }
}
