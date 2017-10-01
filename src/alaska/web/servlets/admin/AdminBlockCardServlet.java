package alaska.web.servlets.admin;

import java.io.IOException;
import java.sql.SQLException;
import java.util.Locale;

import javax.naming.NamingException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import alaska.web.dao.AccountDao;
import alaska.web.dao.impl.AccountDaoImpl;
import alaska.web.model.Account;

public class AdminBlockCardServlet extends HttpServlet {
  private static final long serialVersionUID = 1L;
  private AccountDao accountDao = new AccountDaoImpl();

  @Override
  protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    req.getRequestDispatcher("/WEB-INF/view/admin/forms/adminblockcard.jsp").forward(req, resp);
  }

  @Override
  protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    final String number = (String) req.getParameter("cardnumber");
    try {
      Account account = accountDao.findByNumber(number);
      if(account!= null) {
      accountDao.changeStatus(number, false, false);
      req.getRequestDispatcher("/WEB-INF/view/done.jsp").forward(req, resp);
      }else {
        final Locale language = (Locale) req.getSession().getAttribute("language");
        if (language.getLanguage().equals("ru")) {
          req.setAttribute("errorText", "Неправильный номер счета");
        } else {
          req.setAttribute("errorText", "Wrong account number");
        }
        req.getRequestDispatcher("/WEB-INF/view/admin/forms/adminunblockcard.jsp").forward(req, resp);
      }
    } catch (SQLException | NamingException e) {
      e.printStackTrace();
    }
  }
}
