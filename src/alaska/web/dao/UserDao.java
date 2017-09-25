package alaska.web.dao;
import java.sql.SQLException;
import java.util.Set;

import javax.naming.NamingException;

import alaska.web.model.User;

public interface UserDao {
  User findByLogin(String username) throws SQLException, NamingException;
  Set<User> findByStatus(boolean status) throws SQLException, NamingException;
  void save(User user) throws SQLException, NamingException;
  public void changeStatus(String username, boolean status) throws NamingException, SQLException;
}
