package alaska.web.dao;

import java.sql.SQLException;
import java.util.Set;
import javax.naming.NamingException;

import alaska.web.model.Account;

public interface AccountDao {
  void changeStatus(String number, boolean status, boolean request) throws SQLException, NamingException;
  void changeBalance(String number, double amount) throws SQLException, NamingException;
  Set<Account> findByRequest(boolean flag) throws SQLException, NamingException;
}
