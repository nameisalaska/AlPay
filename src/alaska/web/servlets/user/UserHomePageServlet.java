package alaska.web.servlets.user;

import java.io.IOException;
import java.sql.SQLException;
import java.util.Set;

import javax.naming.NamingException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import alaska.web.dao.AccountDao;
import alaska.web.dao.CreditCardDao;
import alaska.web.dao.PaymentDao;
import alaska.web.dao.impl.AccountDaoImpl;
import alaska.web.dao.impl.CreditCardDaoImpl;
import alaska.web.dao.impl.PaymentDaoImpl;
import alaska.web.model.Account;
import alaska.web.model.CreditCard;
import alaska.web.model.Payment;


public class UserHomePageServlet extends HttpServlet {
  private CreditCardDao cardDao = new CreditCardDaoImpl();
  private PaymentDao payDao = new PaymentDaoImpl();
  private AccountDao accountDao = new AccountDaoImpl();
  private static final long serialVersionUID = 1L;

  @Override
  protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    try {
      final String login = (String)req.getSession().getAttribute("login");
      Set<CreditCard> cardSet = cardDao.findByClient(login);
      req.getSession().setAttribute("cardSet", cardSet);
      Set<Payment> paymentSet = payDao.findByStatus(login, true);
      req.getSession().setAttribute("paymentSet", paymentSet);
      Set<Account> accounts = null;
      accounts = accountDao.findByUser(login);
      req.getSession().setAttribute("accountSet", accounts);
      req.getRequestDispatcher("/WEB-INF/view/client/user_homepage.jsp").forward(req, resp);
    } catch (SQLException | NamingException e) {
      e.printStackTrace();
    }

  }

  @Override
  protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    doGet(request, response);
  }
}
