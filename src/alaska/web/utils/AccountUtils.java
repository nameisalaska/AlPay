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
  public static Account initializeAccount(ResultSet accounts) throws SQLException {
      final Account account = new Account();
      account.setNumber(accounts.getString("number"));
      account.setPin(accounts.getString("pin"));
      account.setStatus(accounts.getBoolean("status"));
      account.setRequest(accounts.getBoolean("request"));
      account.setBalance(accounts.getDouble("balance"));
      account.setName(accounts.getString("name"));
      account.setUser(accounts.getString("user"));
      return account;
  }
}
