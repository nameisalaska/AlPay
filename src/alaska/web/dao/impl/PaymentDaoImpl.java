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
    Connection dbConnection =  dataSource.getConnection();
    PreparedStatement insertPaymentStatement =  dbConnection.prepareStatement("INSERT INTO payment" +
        " (date, cardfrom, cardto, amount, status, payer) VALUES (?, ?, ?, ?, ?, ?)");
    insertPaymentStatement.setDate(1, payment.getDate());
    insertPaymentStatement.setString(2, payment.getCardFrom());
    insertPaymentStatement.setString(3, payment.getCardTo());
    insertPaymentStatement.setDouble(4, payment.getAmount());
    insertPaymentStatement.setBoolean(5, payment.isStatus());
    insertPaymentStatement.setString(6, payment.getPayer());
    insertPaymentStatement.execute();
  }

  @Override
  public Set<Payment> findByNumber(String number) throws SQLException, NamingException {
    Connection dbConnection =  dataSource.getConnection();
    PreparedStatement findAllPayment = dbConnection .prepareStatement("SELECT * FROM payment WHERE cardfrom = ? OR cardto = ? AND status = ?");
    findAllPayment.setString(1, number);
    findAllPayment.setString(2, number);
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
  public Set<Payment> findByStatus(String payer, boolean status) throws SQLException, NamingException {
    Connection dbConnection =  dataSource.getConnection();
    PreparedStatement findAllPayment = dbConnection .prepareStatement("SELECT * FROM payment WHERE payer = ? AND status = ?");
    findAllPayment.setString(1, payer);
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
  public void changeStatus(String number, boolean status) throws SQLException, NamingException {
    Connection dbConnection =  dataSource.getConnection();
    PreparedStatement updatePayment = dbConnection.prepareStatement("UPDATE payment SET status = ? WHERE cardfrom = ?");
    updatePayment.setBoolean(1, status);
    updatePayment.setString(2, number);
    updatePayment.execute();
  }
}
