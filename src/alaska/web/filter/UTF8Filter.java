package alaska.web.filter;

import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;

/**
 * Servlet Filter implementation class UTF8Filter Set character encoding to
 * UTF-8
 *
 * @author Alaska
 */

@WebFilter("*")
public class UTF8Filter implements Filter {

  /**
   * @see Filter#destroy()
   */
  @Override
  public void destroy() {
  }

  /**
   * @see Filter#doFilter(ServletRequest, ServletResponse, FilterChain)
   */
  @Override
  public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
      throws IOException, ServletException {
    if (request.getCharacterEncoding() == null) {
      request.setCharacterEncoding("UTF-8");
    }
    chain.doFilter(request, response);
  }

  /**
   * @see Filter#init(FilterConfig)
   */
  @Override
  public void init(FilterConfig fConfig) throws ServletException {
  }
}
