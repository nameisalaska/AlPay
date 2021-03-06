package alaska.web.model;

import java.sql.Date;
import java.sql.Time;

/**
 * Pattern for payment creating.
 *
 * @author Alaska
 */
public class Payment {
  private Date date;
  private Time time;
  private int cardFrom;
  private int cardTo;
  private double amount;
  private boolean status;

  public Payment() {

  }
  public Payment(Date date,Time time,int cardFrom, int cardTo, double amount, boolean status) {
    this.setDate(date);
    this.setTime(time);
    this.setCardFrom(cardFrom);
    this.setCardTo(cardTo);
    this.setAmount(amount);
    this.setStatus(status);
  }

  public Date getDate() {
    return date;
  }

  public void setDate(Date date) {
    this.date = date;
  }

  public int getCardFrom() {
    return cardFrom;
  }

  public void setCardFrom(int cardFrom) {
    this.cardFrom = cardFrom;
  }

  public int getCardTo() {
    return cardTo;
  }

  public void setCardTo(int cardTo) {
    this.cardTo = cardTo;
  }

  public double getAmount() {
    return amount;
  }

  public void setAmount(double amount) {
    this.amount = amount;
  }

  public boolean isStatus() {
    return status;
  }

  public void setStatus(boolean status) {
    this.status = status;
  }
  public Time getTime() {
    return time;
  }
  public void setTime(Time time) {
    this.time = time;
  }
}
