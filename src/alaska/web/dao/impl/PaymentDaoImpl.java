package alaska.web.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashSet;
import java.util.Set;
import javax.naming.NamingException;
import javax.sql.DataSource;
import alaska.web.dao.PaymentDao;
import alaska.web.model.Payment;
import alaska.web.utils.DbUtils;
import alaska.web.utils.PaymentUtils;

public class PaymentDaoImpl implements PaymentDao{

  final private DataSource dataSource = DbUtils.dataSource;

  @Override
  public void save(Payment payment) throws SQLException, NamingException {
    Connection dbConnection =  dataSource.getConnection("root", "pass");
    PreparedStatement insertPaymentStatement =  dbConnection.prepareStatement("INSERT INTO payment" +
        " (date,time, cardfrom, cardto, amount, status) VALUES (?, ?, ?, ?, ?, ?)");
    insertPaymentStatement.setDate(1, payment.getDate());
    insertPaymentStatement.setTime(2, payment.getTime());
    insertPaymentStatement.setInt(3, payment.getCardFrom());
    insertPaymentStatement.setInt(4, payment.getCardTo());
    insertPaymentStatement.setDouble(5, payment.getAmount());
    insertPaymentStatement.setBoolean(6, payment.isStatus());
    insertPaymentStatement.execute();
  }

  @Override
  public Set<Payment> findByNumber(int number) throws SQLException, NamingException {
    Connection dbConnection =  dataSource.getConnection("root", "");
    PreparedStatement findAllPayment = dbConnection .prepareStatement("SELECT * FROM payment WHERE cardfrom = ? OR cardto = ? AND status = ?");
    findAllPayment.setInt(1, number);
    findAllPayment.setInt(2, number);
    findAllPayment.setBoolean(3, true);
    ResultSet payments = findAllPayment.executeQuery();

    Set<Payment> paymentSet = new HashSet<>();
    while(payments.next()) {
        Payment payment = PaymentUtils.initializePayment(payments);
        paymentSet.add(payment);
    }
    return paymentSet;

  }

  @Override
  public Set<Payment> findByStatus(int number) throws SQLException, NamingException {
    Connection dbConnection =  dataSource.getConnection("root", "");
    PreparedStatement findAllPayment = dbConnection .prepareStatement("SELECT * FROM payment WHERE cardfrom = ? AND status = ?");
    findAllPayment.setInt(1, number);
    findAllPayment.setBoolean(2, false);
    ResultSet payments = findAllPayment.executeQuery();
    Set<Payment> paymentSet = new HashSet<>();
    while(payments.next()) {
        Payment payment = PaymentUtils.initializePayment(payments);
        paymentSet.add(payment);
    }
    return paymentSet;
  }

  @Override
  public void changeStatus(int number, boolean status) throws SQLException, NamingException {
    Connection dbConnection =  dataSource.getConnection("root", "");
    PreparedStatement updatePayment = dbConnection.prepareStatement("UPDATE payment SET status = ? WHERE cardfrom = ?");
    updatePayment.setBoolean(1, status);
    updatePayment.setInt(2, number);
    updatePayment.execute();
  }
}
