package alaska.web.model;

import java.sql.Date;
import java.sql.Time;

public class Replenish {
  /**
   * Pattern for replenish creating.
   *
   * @author Alaska
   */
  private int account;
  private double amount;
  private Date date;
  private Time time;

  public Replenish() {

  }
  public Replenish(int account, double amount, Date date, Time time) {
    this.setAccount(account);
    this.setAmount(amount);
    this.setDate(date);
    this.setTime(time);
  }

  public int getAccount() {
    return account;
  }

  public void setAccount(int account) {
    this.account = account;
  }

  public double getAmount() {
    return amount;
  }

  public void setAmount(double amount) {
    this.amount = amount;
  }
  public Time getTime() {
    return time;
  }
  public void setTime(Time time) {
    this.time = time;
  }
  public Date getDate() {
    return date;
  }
  public void setDate(Date date) {
    this.date = date;
  }
}
