package alaska.web.servlets.user;

import java.io.IOException;
import java.sql.Date;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import alaska.web.model.Payment;

public class PaymentServlet extends HttpServlet {

  private static final long serialVersionUID = 1L;

  @Override
  protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    request.getRequestDispatcher("WEB-INF/view/client/forms/payment.jsp").forward(request, response);
  }
  @Override
  protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
      String login = (String) req.getSession().getAttribute("login");
      String cardfrom = (String) req.getParameter("cardnumberfrom");
      String cardto = (String) req.getParameter("cardto");
      Double sum = Double.parseDouble(req.getParameter("sum"));
      String string = (String) req.getParameter("status");
      boolean status = getStatus(string);
      new java.sql.Date((new java.util.Date()).getTime());
      Payment payment = new Payment( new Date(new java.util.Date().getTime()), cardfrom, cardto, sum, status, login);

  }
  private boolean getStatus(String string) {
    if(string.equals("true")) {
      return true;
    }else {
      return false;
    }

  }
}
