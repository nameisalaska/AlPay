package alaska.web.servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import alaska.web.model.enums.UserType;

public class DoneServlet extends HttpServlet {
  private static final long serialVersionUID = 1L;

  protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    final UserType type = (UserType) req.getSession().getAttribute("type");
    if(type==null) {
      req.getRequestDispatcher("/WEB-INF/view/login.jsp").forward(req,resp);
    }
    switch (type) {
    case User:
      resp.sendRedirect("user_home");
      break;
    case Admin:
      resp.sendRedirect("admin_home");
      break;
    }
  }
}
