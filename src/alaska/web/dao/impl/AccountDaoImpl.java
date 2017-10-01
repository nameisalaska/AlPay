package alaska.web.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashSet;
import java.util.Set;
import javax.naming.NamingException;
import javax.sql.DataSource;

import alaska.web.dao.AccountDao;
import alaska.web.model.Account;
import alaska.web.model.User;
import alaska.web.utils.AccountUtils;
import alaska.web.utils.DbUtils;
import alaska.web.utils.UserUtils;

public class AccountDaoImpl implements AccountDao{

  final private DataSource dataSource = DbUtils.dataSource;

  @Override
  public void changeStatus(String number,  boolean status, boolean request) throws SQLException, NamingException {
    Connection dbConnection =  dataSource.getConnection();
    PreparedStatement updateStatus = dbConnection.prepareStatement("UPDATE account SET status = ?, request = ? WHERE number = ?");
    updateStatus.setBoolean(1, status);
    updateStatus.setBoolean(2, request);
    updateStatus.setString(3, number);
    updateStatus.execute();
    dbConnection.close();
    updateStatus.close();
  }

  @Override
  public void setClient(String number, String login, String name) throws SQLException, NamingException {
    Connection dbConnection =  dataSource.getConnection();
    PreparedStatement updateClient = dbConnection.prepareStatement("UPDATE account SET user = ?, name = ? WHERE number = ?");
    updateClient.setString(1, login);
    updateClient.setString(2, name);
    updateClient.setString(3, number);
    updateClient.execute();
    dbConnection.close();
    updateClient.close();
  }


  @Override
  public void changeBalance(String number, double amount) throws SQLException, NamingException {
    Connection dbConnection =  dataSource.getConnection();
    PreparedStatement updateBalance = dbConnection.prepareStatement("UPDATE account SET balance = ? WHERE number = ?");
    Account account  = findByNumber(number);
    double balance = account.getBalance() + amount;
    updateBalance.setDouble(1, balance);
    updateBalance.setString(2, number);
    updateBalance.execute();
    dbConnection.close();
    updateBalance.close();
  }

  @Override
  public Set<Account> findByRequest(boolean flag) throws SQLException, NamingException {
    Connection dbConnection =  dataSource.getConnection();
    PreparedStatement findAllCard = dbConnection .prepareStatement("SELECT * FROM account WHERE request = ?");
    findAllCard.setBoolean(1, flag);
    ResultSet acccounts = findAllCard.executeQuery();
    Set<Account> accountSet = new HashSet<>();
    while(acccounts.next()) {
        Account account = AccountUtils.initializeAccount(acccounts);
        accountSet.add(account);
    }
    dbConnection.close();
    findAllCard.close();
    return accountSet;
  }

  @Override
  public Account findByNumber(String number) throws SQLException, NamingException {
    Connection dbConnection =  dataSource.getConnection();
    PreparedStatement findAccount = dbConnection.prepareStatement("SELECT * FROM account WHERE number = ?");
    findAccount.setString(1, number);
    ResultSet accountWithTheNumber = findAccount.executeQuery();
    Account account = new Account();
    if (!accountWithTheNumber.isBeforeFirst() ) {
        account = null;
    } else {
      accountWithTheNumber.next();
      account.setNumber(accountWithTheNumber.getString("number"));
      account.setBalance(accountWithTheNumber.getDouble("balance"));
      account.setPin(accountWithTheNumber.getString("pin"));
      account.setRequest(accountWithTheNumber.getBoolean("request"));
      account.setStatus(accountWithTheNumber.getBoolean("status"));
      account.setName(accountWithTheNumber.getString("name"));
    }
    dbConnection.close();
    findAllCard.close();
    return account;
  }

  @Override
  public Set<Account> sortByBalance(String user) throws SQLException, NamingException {
    Connection dbConnection =  dataSource.getConnection();
    PreparedStatement findAllCard = dbConnection .prepareStatement("SELECT * FROM account WHERE user = ? ORDER BY balance DESC");
    findAllCard.setString(1, user);
    ResultSet acccounts = findAllCard.executeQuery();
    Set<Account> accountSet = new HashSet<>();
    while(acccounts.next()) {
        Account account = AccountUtils.initializeAccount(acccounts);
        accountSet.add(account);
    }
    dbConnection.close();
    findAllCard.close();
    return accountSet;
  }

  @Override
  public Set<Account> sortByName(String user) throws SQLException, NamingException {
    Connection dbConnection =  dataSource.getConnection();
    PreparedStatement findAllCard = dbConnection .prepareStatement("SELECT * FROM account WHERE user = ? ORDER BY name");
    findAllCard.setString(1, user);
    ResultSet acccounts = findAllCard.executeQuery();
    Set<Account> accountSet = new HashSet<>();
    while(acccounts.next()) {
        Account account = AccountUtils.initializeAccount(acccounts);
        accountSet.add(account);
    }
    findAllCard.close();
    dbConnection.close();
    return accountSet;
  }

  @Override
  public Set<Account> sortByNumber(String user) throws SQLException, NamingException {
    Connection dbConnection =  dataSource.getConnection();
    PreparedStatement findAllCard = dbConnection .prepareStatement("SELECT * FROM account WHERE user = ? ORDER BY number");
    findAllCard.setString(1, user);
    ResultSet acccounts = findAllCard.executeQuery();
    Set<Account> accountSet = new HashSet<>();
    while(acccounts.next()) {
        Account account = AccountUtils.initializeAccount(acccounts);
        accountSet.add(account);
    }
    dbConnection.close();
    findAllCard.close();
    return accountSet;
  }

  @Override
  public Set<Account> findByUser(String user) throws SQLException, NamingException {
    Connection dbConnection =  dataSource.getConnection();
    PreparedStatement findAllCard = dbConnection .prepareStatement("SELECT * FROM account WHERE user = ?");
    findAllCard.setString(1, user);
    ResultSet acccounts = findAllCard.executeQuery();
    Set<Account> accountSet = new HashSet<>();
    while(acccounts.next()) {
        Account account = AccountUtils.initializeAccount(acccounts);
        accountSet.add(account);
    }
    dbConnection.close();
    findAllCard.close();
    return accountSet;
  }
}
