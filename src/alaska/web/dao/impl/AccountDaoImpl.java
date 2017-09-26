package alaska.web.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.naming.NamingException;
import javax.sql.DataSource;

import alaska.web.dao.AccountDao;
import alaska.web.utils.DbUtils;

public class AccountDaoImpl implements AccountDao{

  final private DataSource dataSource = DbUtils.dataSource;

  @Override
  public void changeStatus(int number,  boolean status, boolean request) throws SQLException, NamingException {
    Connection dbConnection =  dataSource.getConnection("root", "");
    PreparedStatement updateAccount = dbConnection.prepareStatement("UPDATE account SET status = ?, request = ? WHERE number = ?");
    updateAccount.setBoolean(1, status);
    updateAccount.setBoolean(2, request);
    updateAccount.setInt(3, number);
    updateAccount.execute();
  }

  @Override
  public void changeBalance(int number, double amount) throws SQLException, NamingException {
    Connection dbConnection =  dataSource.getConnection("root", "pass");
    PreparedStatement updateAccount = dbConnection.prepareStatement("UPDATE account SET balance = ? WHERE number = ?");
    PreparedStatement findBalance = dbConnection.prepareStatement("SELECT balance FROM account WHERE  number = ?");
    ResultSet balanceOfTheAccount =  findBalance.executeQuery();
    double balance = balanceOfTheAccount.getDouble("balance");
    balance += amount;
    updateAccount.setDouble(1, balance);
    updateAccount.setInt(2, number);
    updateAccount.execute();
  }
}
