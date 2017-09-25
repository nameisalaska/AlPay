package alaska.web.dao;

import java.sql.SQLException;
import java.util.Set;
import javax.naming.NamingException;

import alaska.web.model.CreditCard;

public interface CreditCardDao {
  void save(CreditCard card) throws SQLException, NamingException;
  Set<CreditCard> findByClient(String username) throws SQLException, NamingException;
}

