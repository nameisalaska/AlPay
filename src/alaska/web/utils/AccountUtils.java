package alaska.web.utils;

import java.sql.ResultSet;
import java.sql.SQLException;

import alaska.web.model.Account;

public class AccountUtils {

  private AccountUtils() {
  }

  /**
   * @return constructed {@link Account}.
   */
  public static Account initializeAccount(ResultSet payments) throws SQLException {
      final Account account = new Account();
      account.setNumber(payments.getString("number"));
      account.setPin(payments.getString("pin"));
      account.setStatus(payments.getBoolean("status"));
      account.setRequest(payments.getBoolean("request"));
      account.setBalance(payments.getDouble("balance"));
      return account;
  }
}
