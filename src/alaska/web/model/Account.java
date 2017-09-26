package alaska.web.model;


/**
 * Class for account creating/changes.
 *
 * @author Alaska
 */
public class Account {
  private String number;
  private boolean status;
  private double balance;
  private boolean request;
  private String pin;

  public Account() {

  }
  public Account(String number, boolean status, double balance, boolean request, String pin) {
    this.setNumber(number);
    this.setStatus(status);
    this.setBalance(balance);
    this.setRequest(request);
    this.setPin(pin);
  }
  public String getNumber() {
    return number;
  }
  public void setNumber(String number) {
    this.number = number;
  }
  public boolean isStatus() {
    return status;
  }
  public void setStatus(boolean status) {
    this.status = status;
  }
  public double getBalance() {
    return balance;
  }
  public void setBalance(double balance) {
    this.balance = balance;
  }
  public boolean isRequest() {
    return request;
  }
  public void setRequest(boolean request) {
    this.request = request;
  }
  public String getPin() {
    return pin;
  }
  public void setPin(String pin) {
    this.pin = pin;
  }
}
