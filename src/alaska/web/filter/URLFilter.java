package alaska.web.filter;

import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import alaska.web.model.enums.UserType;

/**
 * Checks urls and user rights.
 *
 * @author Alaska
 *
 */
@WebFilter("/*")
public class URLFilter implements Filter {

  @Override
  public void destroy() {
  }

  @Override
  public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain chain)
      throws IOException, ServletException {
    HttpServletRequest httpServletRequest = (HttpServletRequest) servletRequest;
    UserType type = (UserType) httpServletRequest.getSession().getAttribute("type");
    String requestUrl = httpServletRequest.getRequestURL().toString();
    if(type == null && (requestUrl.contains("admin") || requestUrl.contains("user"))) {
      HttpServletResponse response = (HttpServletResponse) servletResponse;
      httpServletRequest.getRequestDispatcher("/WEB-INF/view/error/error.jsp").forward(httpServletRequest, response);
    }else if (requestUrl.contains("admin")) {
      if (type != null && type.name().equals("Admin")) {
        chain.doFilter(servletRequest, servletResponse);
      } else {
        HttpServletResponse response = (HttpServletResponse) servletResponse;
        response.sendError(HttpServletResponse.SC_FORBIDDEN);
        return;
      }
    } else if (requestUrl.contains("user")) {
      if (type.name().equals("User")) {
        chain.doFilter(servletRequest, servletResponse);
      } else {
        HttpServletResponse response = (HttpServletResponse) servletResponse;
        httpServletRequest.getRequestDispatcher("/WEB-INF/view/error/error.jsp").forward(httpServletRequest, response);
      }
    } else {
      chain.doFilter(servletRequest, servletResponse);
    }
 }

  @Override
  public void init(FilterConfig fConfig) throws ServletException {
  }
}
