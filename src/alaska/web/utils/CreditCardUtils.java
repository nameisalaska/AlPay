package alaska.web.utils;

import java.sql.ResultSet;
import java.sql.SQLException;

import alaska.web.model.CreditCard;

public class CreditCardUtils {
  private CreditCardUtils() {
  }
  /**
   * @return constructed {@link CreditCard}.
   */
  public static CreditCard initializeCard(ResultSet cards) throws SQLException {
      final CreditCard card = new CreditCard();
      card.setNumber(cards.getString("number"));
      card.setAccount_number(cards.getString("account_number"));
      card.setUsername(cards.getString("client"));

      return card;
  }
}
