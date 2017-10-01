package alaska.web.servlets.user;

import java.io.IOException;
import java.sql.SQLException;

import javax.naming.NamingException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import alaska.web.dao.AccountDao;
import alaska.web.dao.impl.AccountDaoImpl;
import alaska.web.model.Account;

public class AccountAddingServlet extends HttpServlet {

  private AccountDao accountDao = new AccountDaoImpl();
  private static final long serialVersionUID = 1L;

  @Override
  protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    req.getRequestDispatcher("/WEB-INF/view/client/forms/accountAdding.jsp").forward(req, resp);
  }

  @Override
  protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    final String accountNumber = (String) req.getParameter("cardnumber");
    final String name = (String) req.getParameter("name");
    final String pin = (String) req.getParameter("name");
    try {
      Account account = accountDao.findByNumber(accountNumber);
      if(account!=null && pin.equals(account.getPin())) {
        accountDao.setClient(account.getNumber(), (String) req.getSession().getAttribute("login"), name);
        req.getRequestDispatcher("WEB-INF/view/done.jsp").forward(req, resp);
      }
    } catch (SQLException | NamingException e) {
      e.printStackTrace();
    }
  }
}
