package alaska.web.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashSet;
import java.util.Set;
import javax.naming.NamingException;
import javax.sql.DataSource;

import alaska.web.dao.CreditCardDao;
import alaska.web.model.Account;
import alaska.web.model.CreditCard;
import alaska.web.utils.CreditCardUtils;
import alaska.web.utils.DbUtils;

public class CreditCardDaoImpl implements CreditCardDao{
  final private DataSource dataSource = DbUtils.dataSource;

  @Override
  public void save(CreditCard card) throws SQLException, NamingException {
    Connection dbConnection =  dataSource.getConnection();
    PreparedStatement insertCardStatement =  dbConnection.prepareStatement("INSERT INTO card" +
        " (number, account_number, client) VALUES (?, ?, ?)");
    insertCardStatement.setString(1, card.getNumber());
    insertCardStatement.setString(2, card.getAccount_number());
    insertCardStatement.setString(3, card.getUsername());
    insertCardStatement.execute();
    dbConnection.close();
    insertCardStatement.close();
  }

  @Override
  public Set<CreditCard> findByClient(String username) throws SQLException, NamingException {
    Connection dbConnection =  dataSource.getConnection();
    PreparedStatement findAllCard = dbConnection .prepareStatement("SELECT * FROM card WHERE client = ?");
    findAllCard.setString(1, username);
    ResultSet cards = findAllCard.executeQuery();
    Set<CreditCard> cardSet = new HashSet<>();
    while(cards.next()) {
        CreditCard card = CreditCardUtils.initializeCard(cards);
        cardSet.add(card);
    }
    dbConnection.close();
    findAllCard.close();
    return cardSet;
  }

  @Override
  public CreditCard findByNumber(String number) throws SQLException, NamingException {
    Connection dbConnection =  dataSource.getConnection();
    PreparedStatement findCard = dbConnection.prepareStatement("SELECT * FROM card WHERE number = ?");
    findCard.setString(1, number);
    ResultSet accountWithTheNumber = findCard.executeQuery();
    CreditCard card = new CreditCard();
    if (!accountWithTheNumber.isBeforeFirst() ) {
        card = null;
    } else {
      accountWithTheNumber.next();
      card.setNumber(accountWithTheNumber.getString("number"));
      card.setAccount_number(accountWithTheNumber.getString("account_number"));
      card.setUsername(accountWithTheNumber.getString("client"));
    }
    dbConnection.close();
    findCard.close();
    return card;
  }
}
