package alaska.web.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashSet;
import java.util.Set;

import javax.naming.NamingException;
import javax.sql.DataSource;

import alaska.web.dao.ReplenishDao;
import alaska.web.model.Payment;
import alaska.web.model.Replenish;
import alaska.web.utils.DbUtils;
import alaska.web.utils.PaymentUtils;
import alaska.web.utils.ReplenishUtils;

public class ReplenishDaoImpl implements ReplenishDao{

  final private DataSource dataSource = DbUtils.dataSource;;

  @Override
  public void save(Replenish replenish) throws SQLException, NamingException {
    Connection dbConnection =  dataSource.getConnection("root", "pass");
    PreparedStatement insertReplenishStatement =  dbConnection.prepareStatement("INSERT INTO replenish" +
        " (account, amount,  date, time) VALUES (?, ?, ?, ?)");
    insertReplenishStatement.setInt(1, replenish.getAccount());
    insertReplenishStatement.setDouble(2, replenish.getAmount());
    insertReplenishStatement.setDate(3, replenish.getDate());
    insertReplenishStatement.setTime(4, replenish.getTime());
    insertReplenishStatement.execute();
  }

  @Override
  public Set<Replenish> findByNumber(int number) throws SQLException, NamingException {
    Connection dbConnection =  dataSource.getConnection("root", "");
    PreparedStatement findAllReplenish = dbConnection .prepareStatement("SELECT * FROM replenish WHERE account = ?");
    findAllReplenish.setInt(1, number);
    ResultSet replenishes = findAllReplenish.executeQuery();
    Set<Replenish> replenishSet = new HashSet<>();
    while(replenishes.next()) {
       Replenish replenish = ReplenishUtils.initializeReplenish(replenishes);
        replenishSet.add(replenish);
    }
    return replenishSet;
  }
}
