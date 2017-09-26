package alaska.web.listener;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;
import javax.servlet.http.HttpSessionAttributeListener;
import javax.servlet.http.HttpSessionBindingEvent;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

import alaska.web.utils.DbUtils;

/**
 * Listener creates dataSource.
 * @author Alaska
 */
@WebListener
public class Listener implements ServletContextListener, HttpSessionAttributeListener, HttpSessionListener {

  public Listener() {
  }

  /**
   * @see HttpSessionListener#sessionCreated(HttpSessionEvent)
   */
  public void sessionCreated(HttpSessionEvent arg0) {
    // TODO Auto-generated method stub
  }

  /**
   * @see HttpSessionListener#sessionDestroyed(HttpSessionEvent)
   */
  public void sessionDestroyed(HttpSessionEvent arg0) {
    // TODO Auto-generated method stub
  }

  /**
   * @see ServletContextListener#contextDestroyed(ServletContextEvent)
   */
  public void contextDestroyed(ServletContextEvent arg0) {
    // TODO Auto-generated method stub
  }

  /**
   * @see HttpSessionAttributeListener#attributeAdded(HttpSessionBindingEvent)
   */
  public void attributeAdded(HttpSessionBindingEvent arg0) {
    // TODO Auto-generated method stub
  }

  /**
   * @see HttpSessionAttributeListener#attributeRemoved(HttpSessionBindingEvent)
   */
  public void attributeRemoved(HttpSessionBindingEvent arg0) {
    // TODO Auto-generated method stub
  }

  /**
   * @see HttpSessionAttributeListener#attributeReplaced(HttpSessionBindingEvent)
   */
  public void attributeReplaced(HttpSessionBindingEvent arg0) {
    // TODO Auto-generated method stub
  }

  /**
   * @see ServletContextListener#contextInitialized(ServletContextEvent)
   */
  public void contextInitialized(ServletContextEvent arg0) {
    System.out.println("Listener");
    DbUtils.createDataSource();
  }
}
