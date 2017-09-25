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
import alaska.web.model.CreditCard;
import alaska.web.utils.CreditCardUtils;
import alaska.web.utils.DbUtils;

public class CreditCardDaoImpl implements CreditCardDao{
  final private DataSource dataSource = DbUtils.dataSource;

  @Override
  public void save(CreditCard card) throws SQLException, NamingException {
    Connection dbConnection =  dataSource.getConnection("root", "");
    PreparedStatement insertCardStatement =  dbConnection.prepareStatement("INSERT INTO card" +
        " (number, account_number, client) VALUES (?, ?, ?)");
    insertCardStatement.setInt(1, card.getNumber());
    insertCardStatement.setInt(2, card.getAccount_number());
    insertCardStatement.setString(3, card.getUsername());
    insertCardStatement.execute();
  }

  @Override
  public Set<CreditCard> findByClient(String username) throws SQLException, NamingException {
    Connection dbConnection =  dataSource.getConnection("root", "");
    PreparedStatement findAllCard = dbConnection .prepareStatement("SELECT * FROM card WHERE client = ?");
    findAllCard.setString(1, username);

    ResultSet cards = findAllCard.executeQuery();

    Set<CreditCard> cardSet = new HashSet<>();
    while(cards.next()) {
        CreditCard card = CreditCardUtils.initializeCard(cards);
        cardSet.add(card);
    }
    return cardSet;
  }

}
