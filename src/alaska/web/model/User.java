package alaska.web.model;

import alaska.web.model.enums.UserType;

/**
 * Pattern for user creating.
 *
 * @author Alaska
 */
public class User {
  private String login;
  private String email;
  private String password;
  private UserType type;
  private boolean status;

  public User() {
  }
  public User(String login, String email, String password, UserType type, boolean status) {
    this.setLogin(login);
    this.setEmail(email);
    this.setPassword(password);
    this.setType(type);
    this.setStatus(status);
  }
  public boolean isStatus() {
    return status;
  }
  public void setStatus(boolean status) {
    this.status = status;
  }
  public UserType getType() {
    return type;
  }
  public void setType(UserType type) {
    this.type = type;
  }
  public String getPassword() {
    return password;
  }
  public void setPassword(String password) {
    this.password = password;
  }
  public String getEmail() {
    return email;
  }
  public void setEmail(String email) {
    this.email = email;
  }
  public String getLogin() {
    return login;
  }
  public void setLogin(String login) {
    this.login = login;
  }
}
