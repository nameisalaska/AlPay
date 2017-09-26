package alaska.web.filter;

import java.io.IOException;
import java.util.Locale;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;

/**
 * Servlet Filter implementation class LocaleFilter
 */
@WebFilter("/*")
public class LocaleFilter implements Filter {
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
    HttpServletRequest req = (HttpServletRequest) request;
    Locale locale = (Locale) req.getSession().getAttribute("language");
    System.out.println("Locale--");
    if (locale == null) {
      System.out.println("Locale");
      setLocale(req, "en");
    }
    chain.doFilter(request, response);
  }

  /**
   * @see Filter#init(FilterConfig)
   */
  @Override
  public void init(FilterConfig fConfig) throws ServletException {
  }

  private void setLocale(HttpServletRequest req, String lang) {
    Locale enLocale = new Locale.Builder().setLanguage(lang).build();
    req.getSession().setAttribute("language", enLocale);
  }

}
