package alaska.web.filter;

import java.io.IOException;
import java.sql.SQLException;
import javax.naming.NamingException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import alaska.web.dao.UserDao;
import alaska.web.dao.impl.UserDaoImpl;
import alaska.web.model.enums.UserType;

/**
 * Already Login check.
 *
 * @author Alaska
 */
@WebFilter("/login")
public class LogInFilter implements Filter {

  @Override
  public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain)
      throws IOException, ServletException {
    HttpServletRequest httpServletRequest = (HttpServletRequest) servletRequest;
    String username = (String) httpServletRequest.getSession().getAttribute("username");
    if (username != null) {
      UserDao userDao = new UserDaoImpl();
      UserType type = null;
      try {
        type = (UserType) userDao.findByLogin(username).getType();
        System.out.println(userDao.findByLogin(username).getType());
      } catch (SQLException | NamingException e) {
        e.printStackTrace();
      }
      HttpServletResponse httpResponse = (HttpServletResponse) servletResponse;
      switch (type) {
      case User:
        System.out.println();
        httpResponse.sendRedirect("user_home");
        break;
      case Admin:
        httpResponse.sendRedirect("admin_home");
        break;
      }
    } else {
      HttpServletResponse httpServletResponse = (HttpServletResponse) servletResponse;
      httpServletRequest.getRequestDispatcher("/WEB-INF/view/login.jsp").forward(httpServletRequest,
          httpServletResponse);
    }
  }

  @Override
  public void init(FilterConfig fConfig) throws ServletException {
  }

  @Override
  public void destroy() {
  }

}
