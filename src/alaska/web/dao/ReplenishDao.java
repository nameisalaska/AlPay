package alaska.web.dao;

import java.sql.SQLException;
import java.util.Set;
import javax.naming.NamingException;

import alaska.web.model.Replenish;

public interface ReplenishDao {
  void save(Replenish replenish) throws SQLException, NamingException;
  Set<Replenish> findByNumber(String number) throws SQLException, NamingException;
  Set<Replenish> findByUser(String login) throws SQLException, NamingException;
}
