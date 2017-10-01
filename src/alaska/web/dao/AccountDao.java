package alaska.web.dao;

import java.sql.SQLException;
import java.util.Set;
import javax.naming.NamingException;

import alaska.web.model.Account;

public interface AccountDao {
  void changeStatus(String number, boolean status, boolean request) throws SQLException, NamingException;
  void changeBalance(String number, double amount) throws SQLException, NamingException;
  Set<Account> findByRequest(boolean flag) throws SQLException, NamingException;
  Set<Account> findByUser(String user) throws SQLException, NamingException;
  Account findByNumber(String number) throws SQLException, NamingException;
  void setClient(String number, String login, String name) throws SQLException, NamingException;
  Set<Account> sortByBalance(String user) throws SQLException, NamingException;
  Set<Account> sortByName(String user) throws SQLException, NamingException;
  Set<Account> sortByNumber(String user) throws SQLException, NamingException;
}
