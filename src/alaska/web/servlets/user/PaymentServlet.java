package alaska.web.servlets.user;

import java.io.IOException;
import java.sql.Date;
import java.sql.SQLException;
import java.util.Locale;
import java.util.Random;
import javax.naming.NamingException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import alaska.web.dao.CreditCardDao;
import alaska.web.dao.impl.CreditCardDaoImpl;
import alaska.web.model.CreditCard;
import alaska.web.model.Payment;
import alaska.web.transaction.PaymentTransaction;

public class PaymentServlet extends HttpServlet {

  private static final Logger log = LogManager.getLogger(PaymentServlet.class);
  private CreditCardDao cardDao = new CreditCardDaoImpl();
  private PaymentTransaction transaction = new PaymentTransaction();
  private static final long serialVersionUID = 1L;
  private static final int LENGTHOFID = 10;

  @Override
  protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    request.getRequestDispatcher("WEB-INF/view/client/forms/payment.jsp").forward(request, response);
  }

  @Override
  protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    String login = (String) req.getSession().getAttribute("login");
    String cardfrom = (String) req.getParameter("cardnumberfrom");
    String cardto = (String) req.getParameter("cardnumberto");
    double sum = Double.parseDouble(req.getParameter("sum"));
    String id = generateIdNumber();
    boolean status = true;
    try {
      CreditCard card = cardDao.findByNumber(cardto);
      CreditCard cardFrom = cardDao.findByNumber(cardfrom);
      if (card != null && cardFrom != null) {
        if (cardFrom.getUsername().equals(login)) {
          Payment payment = new Payment(new Date(new java.util.Date().getTime()), cardfrom, cardto, sum, status, login,
              id);
          transaction.doTransaction(payment, req, resp);
        }
      } else {
        final Locale language = (Locale) req.getSession().getAttribute("language");
        if (language.getLanguage().equals("ru")) {
          req.setAttribute("errorText", "Неправильный номер карты");
        } else {
          req.setAttribute("errorText", "Wrong card number");
        }
        req.getRequestDispatcher("/WEB-INF/view/user/forms/payment.jsp").forward(req, resp);
      }
    } catch (SQLException | NamingException e) {
      log.error(e);
    }
  }

  private static String generateIdNumber() {
    Random generator = new Random();
    StringBuilder str = new StringBuilder();
    for (int i = 0; i < LENGTHOFID; i++) {
      str.append(generator.nextInt(9));
    }
    return str.toString();
  }
}
