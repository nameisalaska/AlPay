package alaska.web.dao.impl;

import java.sql.*;

import java.util.HashSet;
import java.util.Set;
import javax.naming.NamingException;
import javax.sql.DataSource;

import alaska.web.dao.UserDao;
import alaska.web.model.User;
import alaska.web.utils.DbUtils;
import alaska.web.utils.UserUtils;

public class UserDaoImpl implements UserDao {

  final private DataSource dataSource = DbUtils.dataSource;

  @Override
  public User findByLogin(String username) throws SQLException, NamingException {

     Connection dbConnection =  dataSource.getConnection();
     PreparedStatement findUser = dbConnection.prepareStatement("SELECT * FROM user WHERE  login = ?");
     findUser.setString(1, username);
     ResultSet usersWithTheUsername = findUser.executeQuery();
     User user = new User();
     if (!usersWithTheUsername.isBeforeFirst() ) {
         user = null;
     } else {
       usersWithTheUsername.next();
       user.setLogin(usersWithTheUsername.getString("login"));
       user.setEmail(usersWithTheUsername.getString("email"));
       user.setPassword(usersWithTheUsername.getString("password"));
       user.setType( UserUtils.booleanToType(usersWithTheUsername.getBoolean("type")));
       user.setStatus(usersWithTheUsername.getBoolean("status"));
     }
     return user;
  }

 @Override
  public Set<User> findByStatus(boolean status) throws SQLException, NamingException{
    Connection dbConnection =  dataSource.getConnection("root", "");
    PreparedStatement findAllUser = dbConnection .prepareStatement("SELECT * FROM user WHERE status = ?");
    findAllUser.setBoolean(1, status);

    ResultSet users = findAllUser.executeQuery();

    Set<User> userSet = new HashSet<>();
    while(users.next()) {
        User user = UserUtils.initializeUser(users);
        userSet.add(user);
    }

    return userSet;
}

 @Override
  public void save(User user) throws SQLException, NamingException{
   Connection dbConnection =  dataSource.getConnection("root", "");
    PreparedStatement insertUserStatement =  dbConnection.prepareStatement("INSERT INTO user" +
        " (login, email, password, type, status) VALUES (?, ?, ?, ?, ?)");
    insertUserStatement.setString(1, user.getLogin());
    insertUserStatement.setString(2, user.getEmail());
    insertUserStatement.setString(3, user.getPassword());
    insertUserStatement.setBoolean(4, UserUtils.typeToBoolean(user.getType()));
    insertUserStatement.setBoolean(5, user.isStatus());
    insertUserStatement.execute();
  }

 @Override
  public void changeStatus(String username, boolean status) throws NamingException, SQLException{
   Connection dbConnection =  dataSource.getConnection("root", "pass");
    PreparedStatement updateUser = dbConnection.prepareStatement("UPDATE user SET status = ? WHERE login = ?");
    updateUser.setBoolean(1, status);
    updateUser.setString(2, username);
    updateUser.execute();
  }

 public static void main(String[]args) throws SQLException, NamingException {
   System.out.println( new UserDaoImpl().findByLogin("Alaska"));
 }
}
