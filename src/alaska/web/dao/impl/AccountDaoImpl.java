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
import alaska.web.utils.AccountUtils;
import alaska.web.utils.DbUtils;

public class AccountDaoImpl implements AccountDao{

  final private DataSource dataSource = DbUtils.dataSource;

  @Override
  public void changeStatus(String number,  boolean status, boolean request) throws SQLException, NamingException {
    Connection dbConnection =  dataSource.getConnection();
    PreparedStatement updateAccount = dbConnection.prepareStatement("UPDATE account SET status = ?, request = ? WHERE number = ?");
    updateAccount.setBoolean(1, status);
    updateAccount.setBoolean(2, request);
    updateAccount.setString(3, number);
    updateAccount.execute();
  }

  @Override
  public void changeBalance(String number, double amount) throws SQLException, NamingException {
    Connection dbConnection =  dataSource.getConnection();
    PreparedStatement updateAccount = dbConnection.prepareStatement("UPDATE account SET balance = ? WHERE number = ?");
    PreparedStatement findBalance = dbConnection.prepareStatement("SELECT balance FROM account WHERE  number = ?");
    ResultSet balanceOfTheAccount =  findBalance.executeQuery();
    double balance = balanceOfTheAccount.getDouble("balance");
    balance += amount;
    updateAccount.setDouble(1, balance);
    updateAccount.setString(2, number);
    updateAccount.execute();
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
    return accountSet;
  }
}
