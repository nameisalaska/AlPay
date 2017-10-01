package alaska.web.dao;

import java.sql.SQLException;
import java.util.Set;
import javax.naming.NamingException;

import alaska.web.model.Payment;

public interface PaymentDao {
  void save(Payment payment) throws SQLException, NamingException;
  Set<Payment> findByNumber(String number) throws SQLException, NamingException;
  void changeStatus(String number, boolean status) throws SQLException, NamingException;
  Set<Payment> findByStatus(String payer, boolean status) throws SQLException, NamingException;
  Set<Payment> sortByDate1(String user) throws SQLException, NamingException;
  Set<Payment> sortByDate2(String user) throws SQLException, NamingException;
}
