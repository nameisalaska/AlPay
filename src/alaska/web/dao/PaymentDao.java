package alaska.web.dao;

import java.sql.SQLException;
import java.util.Set;

import javax.naming.NamingException;
import alaska.web.model.Payment;

public interface PaymentDao {
  void save(Payment payment) throws SQLException, NamingException;
  Set<Payment> findByNumber(int number) throws SQLException, NamingException;
  void changeStatus(int number, boolean status) throws SQLException, NamingException;
  Set<Payment> findByStatus(int number) throws SQLException, NamingException;
}
