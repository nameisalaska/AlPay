package alaska.web.utils;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

public class DbUtils {
  public static DataSource dataSource;

  private DbUtils() {
  }

  /**
   * Initializes DataSourse.
   * @author Alaska
   */
  public static DataSource createDataSource() {
    if (dataSource == null) {
      try {
        Context ct = new InitialContext();
        dataSource = (DataSource)ct.lookup("java:/comp/env/jdbc/alpay_system");
        return dataSource;
      } catch (NamingException e) {
        e.printStackTrace();
      }
    } else {
      return dataSource;
    }
    return null;
  }
}

