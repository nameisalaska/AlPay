package alaska.web.model;

import java.sql.Date;
import java.sql.Time;

/**
 * Class for payment creating/changes.
 *
 * @author Alaska
 */
public class Payment {
  private Date date;
  private Time time;
  private String cardFrom;
  private String cardTo;
  private double amount;
  private boolean status;
  private String payer;

  public Payment() {

  }
  public Payment(Date date,Time time,String cardFrom, String cardTo, double amount, boolean status, String payer) {
    this.setDate(date);
    this.setTime(time);
    this.setCardFrom(cardFrom);
    this.setCardTo(cardTo);
    this.setAmount(amount);
    this.setStatus(status);
    this.setPayer(payer);
  }

  public Date getDate() {
    return date;
  }

  public void setDate(Date date) {
    this.date = date;
  }

  public String getCardFrom() {
    return cardFrom;
  }

  public void setCardFrom(String cardFrom) {
    this.cardFrom = cardFrom;
  }

  public String getCardTo() {
    return cardTo;
  }

  public void setCardTo(String cardTo) {
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
  public String getPayer() {
    return payer;
  }
  public void setPayer(String payer) {
    this.payer = payer;
  }
}
