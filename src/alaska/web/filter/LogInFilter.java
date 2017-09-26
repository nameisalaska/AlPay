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
 *
 * @author Alaska
 */
@WebFilter("/*")
public class LogInFilter implements Filter {

  /**
   * @see Filter#doFilter(ServletRequest, ServletResponse, FilterChain)
   */
  @Override
  public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain)
      throws IOException, ServletException {
    HttpServletRequest httpServletRequest = (HttpServletRequest) servletRequest;

    String username = (String) httpServletRequest.getSession().getAttribute("username");
    if (username != null) {
      UserDao userDao = new UserDaoImpl();

      UserType type = null;
      try {
        type = userDao.findByLogin(username).getType();
      } catch (SQLException | NamingException e) {
        e.printStackTrace();
      }

      HttpServletResponse httpResponse = (HttpServletResponse) servletResponse;
      switch (type) {
      case User:
        httpResponse.sendRedirect("/User_home");
      case Admin:
        httpResponse.sendRedirect("/Admin_home");
      }
    } else {
      HttpServletResponse httpServletResponse = (HttpServletResponse) servletResponse;
      httpServletResponse.sendRedirect("/");
    }
  }

  /**
   * @see Filter#init(FilterConfig)
   */
  @Override
  public void init(FilterConfig fConfig) throws ServletException {
  }

  @Override
  public void destroy() {

  }

}
