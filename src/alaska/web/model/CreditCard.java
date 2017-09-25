package alaska.web.model;

/**
 * Pattern for creadit card creating.
 *
 * @author Alaska
 */
public class CreditCard {
  private int number;
  private int account_number;
  private String username;

  public CreditCard() {

  }
  public CreditCard(int number, int account_number, String username) {
    this.setNumber(number);
    this.setAccount_number(account_number);
    this.setUsername(username);
  }

  public int getNumber() {
    return number;
  }

  public void setNumber(int number) {
    this.number = number;
  }

  public int getAccount_number() {
    return account_number;
  }

  public void setAccount_number(int account_number) {
    this.account_number = account_number;
  }

  public String getUsername() {
    return username;
  }

  public void setUsername(String username) {
    this.username = username;
  }
}
