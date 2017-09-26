package alaska.web.model;

/**
 * Class for credit card creating/changes.
 *
 * @author Alaska
 */
public class CreditCard {
  private String number;
  private String  account_number;
  private String username;

  public CreditCard() {
  }
  public CreditCard(String number, String account_number, String username) {
    this.setNumber(number);
    this.setAccount_number(account_number);
    this.setUsername(username);
  }

  public String getNumber() {
    return number;
  }

  public void setNumber(String number) {
    this.number = number;
  }

  public String  getAccount_number() {
    return account_number;
  }

  public void setAccount_number(String  account_number) {
    this.account_number = account_number;
  }

  public String getUsername() {
    return username;
  }

  public void setUsername(String username) {
    this.username = username;
  }
}
