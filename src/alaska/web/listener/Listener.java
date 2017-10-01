package alaska.web.listener;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;
import javax.servlet.http.HttpSessionAttributeListener;
import javax.servlet.http.HttpSessionBindingEvent;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import alaska.web.utils.DbUtils;

/**
 * Listener creates dataSource.
 *
 * @author Alaska
 */
@WebListener
public class Listener implements ServletContextListener, HttpSessionAttributeListener, HttpSessionListener {
  private static final Logger log = LogManager.getLogger(Listener.class);

  public Listener() {
  }

  public void sessionCreated(HttpSessionEvent arg0) {
    log.info("Session created.");
  }

  public void sessionDestroyed(HttpSessionEvent arg0) {
    log.info("Session destroyed.");
  }

  public void contextDestroyed(ServletContextEvent arg0) {
    log.info("Servlet context destroyed.");
  }

  public void attributeAdded(HttpSessionBindingEvent arg0) {
    log.info("Attribute \"" + arg0.getName() + "\" with value " + arg0.getValue() + " added");
  }

  public void attributeRemoved(HttpSessionBindingEvent arg0) {
    log.info("Attribute \"" + arg0.getName() + "\" with value " + arg0.getValue() + " was deleted");
  }

  public void attributeReplaced(HttpSessionBindingEvent arg0) {
    log.info("Attribute \"" + arg0.getName() + "\" with value " + arg0.getValue() + " was replaced");
  }

  public void contextInitialized(ServletContextEvent arg0) {
    log.info("Servlet context initialized.");
    DbUtils.createDataSource();
  }
}
