package alaska.web.servlets.user;

import java.io.IOException;
import java.sql.SQLException;

import javax.naming.NamingException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import alaska.web.dao.AccountDao;
import alaska.web.dao.impl.AccountDaoImpl;

public class ReplenishServlet extends HttpServlet {

  private static final long serialVersionUID = 1L;
  private AccountDao accountDao = new AccountDaoImpl();

  @Override
  public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    request.getRequestDispatcher("WEB-INF/view/client/forms/replenish.jsp").forward(request, response);
  }

  @Override
  public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    int number = Integer.parseInt(request.getParameter("cardnumber"));
    double amount = Double.parseDouble(request.getParameter("sum"));
    try {
      accountDao.changeBalance(number, amount);
    } catch (SQLException | NamingException e) {
      e.printStackTrace();
    }
    request.getRequestDispatcher("WEB-INF/view/client/forms/replenish.jsp").forward(request, response);
  }
}
