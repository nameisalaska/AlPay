package alaska.web.utils;

import java.sql.ResultSet;
import java.sql.SQLException;

import alaska.web.model.User;
import alaska.web.model.enums.UserType;

public class UserUtils {

  private UserUtils() {
  }
  /**
   * @return constructed {@link User}.
   */
  public static User initializeUser(ResultSet users) throws SQLException {
      final User user = new User();
      user.setLogin(users.getString("login"));
      user.setEmail(users.getString("email"));
      user.setPassword(users.getString("password"));
      user.setType(booleanToType(users.getBoolean("type")));
      user.setStatus(users.getBoolean("status"));
      return user;
  }

  public static UserType booleanToType(boolean bool) {
    if(bool) {
      return UserType.Admin;
    }else {
      return UserType.User;
    }
  }

  public static boolean typeToBoolean(UserType type) {
    if(type == UserType.Admin) {
      return true;
    }else {
      return false;
    }
  }
}
