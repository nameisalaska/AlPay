package alaska.web.transaction;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.naming.NamingException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.sql.DataSource;

import alaska.web.dao.AccountDao;
import alaska.web.dao.CreditCardDao;
import alaska.web.dao.PaymentDao;
import alaska.web.dao.impl.AccountDaoImpl;
import alaska.web.dao.impl.CreditCardDaoImpl;
import alaska.web.dao.impl.PaymentDaoImpl;
import alaska.web.model.Account;
import alaska.web.model.CreditCard;
import alaska.web.model.Payment;
import alaska.web.utils.DbUtils;

public class PaymentTransaction {
  private CreditCardDao cardDao = new CreditCardDaoImpl();
  private PaymentDao payDao = new PaymentDaoImpl();
  private AccountDao accountDao = new AccountDaoImpl();
  final private DataSource dataSource = DbUtils.dataSource;

  public void doTransaction(Payment payment, HttpServletRequest req, HttpServletResponse resp ) throws SQLException, ServletException, IOException  {
    Connection dbConnection =  dataSource.getConnection();
   try {
      dbConnection.setAutoCommit(false);
      final CreditCard cardTo = cardDao.findByNumber(payment.getCardTo());
      final CreditCard cardFrom = cardDao.findByNumber(payment.getCardFrom());
      final Account accountTo = accountDao.findByNumber(cardTo.getAccount_number());
      final Account accountFrom = accountDao.findByNumber(cardFrom.getAccount_number());
      PreparedStatement updateAccount = dbConnection.prepareStatement("UPDATE account SET balance = ? WHERE number = ?");
      double balance = accountTo.getBalance() + payment.getAmount();
      updateAccount.setDouble(1, balance);
      updateAccount.setString(2, accountTo.getNumber());
      updateAccount.execute();
      PreparedStatement updateAccountFrom = dbConnection.prepareStatement("UPDATE account SET balance = ? WHERE number = ?");
      balance = accountFrom.getBalance() - payment.getAmount();
      updateAccountFrom.setDouble(1, balance);
      updateAccountFrom.setString(2, accountFrom.getNumber());
      updateAccountFrom.execute();
      payDao.save(payment);
      dbConnection.commit();
      req.getRequestDispatcher("WEB-INF/view/done.jsp").forward(req, resp);
    } catch (SQLException | NamingException e) {
      dbConnection.rollback();
    }
   finally {
     dbConnection.close();
   }
  }
}
