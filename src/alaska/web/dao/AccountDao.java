package alaska.web.dao;

import java.sql.SQLException;

import javax.naming.NamingException;

public interface AccountDao {
  void changeStatus(int number, boolean status) throws SQLException, NamingException;
  void changeBalance(int number, double amount) throws SQLException, NamingException;
}
