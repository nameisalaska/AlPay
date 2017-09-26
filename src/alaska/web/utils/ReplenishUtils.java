package alaska.web.utils;

import java.sql.ResultSet;
import java.sql.SQLException;
import alaska.web.model.Replenish;

public class ReplenishUtils {
  private ReplenishUtils() {
  }

  /**
   * @return constructed {@link Replenish}.
   */
  public static Replenish initializeReplenish(ResultSet payments) throws SQLException {
      final Replenish replenish = new Replenish();
      replenish.setAccount(payments.getString("account"));
      replenish.setAmount(payments.getDouble("amount"));
      replenish.setDate(payments.getDate("date"));
      replenish.setTime(payments.getTime("time"));
      return replenish;
  }
}

