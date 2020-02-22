package exer;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

/**
 * Application Lifecycle Listener implementation class ServletContextListenerImpl
 *
 */
public class ServletContextListenerImpl implements ServletContextListener {

    /**
     * Default constructor. 
     */
    public ServletContextListenerImpl() {
        // TODO Auto-generated constructor stub
    }

	/**
     * @see ServletContextListener#contextDestroyed(ServletContextEvent)
     */
    public void contextDestroyed(ServletContextEvent sce)  { 
        System.out.println("ServletContextListenerImpl对象销毁了");
    }

	/**
     * @see ServletContextListener#contextInitialized(ServletContextEvent)
     */
    public void contextInitialized(ServletContextEvent sce)  { 
         System.out.println("ServletContextListenerImpl对象创建了");
    }
	
}
