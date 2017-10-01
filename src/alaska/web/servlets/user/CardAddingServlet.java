package alaska.web.servlets.user;

import java.io.IOException;
import java.sql.SQLException;
import java.util.Random;

import javax.naming.NamingException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


import alaska.web.dao.CreditCardDao;
import alaska.web.dao.impl.CreditCardDaoImpl;
import alaska.web.model.CreditCard;

public class CardAddingServlet extends HttpServlet {

  private CreditCardDao cardDao = new CreditCardDaoImpl();
  private static final long serialVersionUID = 1L;
  private static final int LENGTHOFСARD = 16;

  @Override
  protected  void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    request.getRequestDispatcher("WEB-INF/view/client/forms/cardAdding.jsp").forward(request, response);
  }

  @Override
  protected  void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    String number = (String) req.getParameter("account_number");
    CreditCard card = new CreditCard(generateCardNumber(), number, (String)req.getSession().getAttribute("login"));
    try {
      cardDao.save(card);
      req.getRequestDispatcher("WEB-INF/view/done.jsp").forward(req, resp);
    } catch (SQLException | NamingException e) {
      e.printStackTrace();
    }
  }
  private static String generateCardNumber() {
    Random generator = new Random();
    StringBuilder str = new StringBuilder();
    for (int i = 0; i < LENGTHOFСARD; i++) {
      str.append(generator.nextInt(9));
    }
    return str.toString();
  }

}