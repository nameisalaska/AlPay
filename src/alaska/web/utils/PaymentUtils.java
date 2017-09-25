package alaska.web.utils;

import java.sql.ResultSet;
import java.sql.SQLException;

import alaska.web.model.Payment;

public class PaymentUtils {
  private PaymentUtils() {

  }
  /**
   * @return constructed {@link Payment}.
   */
  public static Payment initializePayment(ResultSet payments) throws SQLException {
      final Payment payment = new Payment();
      payment.setCardFrom(payments.getInt("cardfrom"));
      payment.setCardTo(payments.getInt("cardto"));
      payment.setDate(payments.getDate("date"));
      payment.setTime(payments.getTime("time"));
      payment.setAmount(payments.getDouble("amount"));
      payment.setStatus(payments.getBoolean("status"));
      return payment;
  }
}
