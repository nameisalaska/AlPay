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
 * If locale = null, set EnLocale.
 *
 * @author Alaska
 *
 */
@WebFilter("/*")
public class LocaleFilter implements Filter {

  @Override
  public void destroy() {
  }

  @Override
  public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
      throws IOException, ServletException {
    HttpServletRequest req = (HttpServletRequest) request;
    Locale locale = (Locale) req.getSession().getAttribute("language");
    if (locale == null) {
      setLocale(req, "en");
    }
    chain.doFilter(request, response);
  }

  @Override
  public void init(FilterConfig fConfig) throws ServletException {
  }

  private void setLocale(HttpServletRequest req, String lang) {
    Locale enLocale = new Locale.Builder().setLanguage(lang).build();
    req.getSession().setAttribute("language", enLocale);
  }

}
