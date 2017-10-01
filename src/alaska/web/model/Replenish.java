package alaska.web.model;

import java.sql.Date;
import java.sql.Time;

/**
 * Class for replenish creating/changes.
 *
 * @author Alaska
 */
public class Replenish {

  private String account;
  private double amount;
  private Date date;
  private String payer;

  public Replenish() {

  }
  public Replenish(String account, double amount, Date date, String payer) {
    this.setAccount(account);
    this.setAmount(amount);
    this.setDate(date);
    this.setPayer(payer);
  }

  public String getAccount() {
    return account;
  }

  public void setAccount(String account) {
    this.account = account;
  }

  public double getAmount() {
    return amount;
  }

  public void setAmount(double amount) {
    this.amount = amount;
  }
  public Date getDate() {
    return date;
  }
  public void setDate(Date date) {
    this.date = date;
  }
  public String getPayer() {
    return payer;
  }
  public void setPayer(String payer) {
    this.payer = payer;
  }
}
