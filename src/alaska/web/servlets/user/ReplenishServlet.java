package alaska.web.servlets.user;

import java.io.IOException;
import java.sql.Date;
import java.sql.SQLException;
import java.util.Locale;

import javax.naming.NamingException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import alaska.web.dao.AccountDao;
import alaska.web.dao.ReplenishDao;
import alaska.web.dao.impl.AccountDaoImpl;
import alaska.web.dao.impl.ReplenishDaoImpl;
import alaska.web.model.Account;
import alaska.web.model.Replenish;

public class ReplenishServlet extends HttpServlet {

  private static final long serialVersionUID = 1L;
  private AccountDao accountDao = new AccountDaoImpl();
  private ReplenishDao replenishDao = new ReplenishDaoImpl();
  private static final Logger log = LogManager.getLogger();

  @Override
  protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    request.getRequestDispatcher("WEB-INF/view/client/forms/replenish.jsp").forward(request, response);
  }

  @Override
  protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    String number = (String) request.getParameter("cardnumber");
    double amount = Double.parseDouble(request.getParameter("sum"));
    try {
      Account account = accountDao.findByNumber(number);
      if(account!=null && account.getNumber().equals(number)) {
      accountDao.changeBalance(number, amount);
      final String payer = (String) request.getSession().getAttribute("login");
      final Replenish replenish = new Replenish(number, amount, new Date(new java.util.Date().getTime()),payer );
      replenishDao.save(replenish);
      request.getRequestDispatcher("WEB-INF/view/done.jsp").forward(request, response);
      }else {
        final Locale language = (Locale) request.getSession().getAttribute("language");
        System.out.println(request.getSession().getAttribute("language") + " 1");
        if (language.getLanguage().equals("ru")) {
          request.setAttribute("errorText", "Введите правильный номер счета");
        } else {
          request.setAttribute("errorText", "Wrong number");
        }
        request.getRequestDispatcher("WEB-INF/view/client/forms/replenish.jsp").forward(request, response);
      }
    } catch (SQLException | NamingException e) {
      e.printStackTrace();
      log.error(e);
    }
  }
}
