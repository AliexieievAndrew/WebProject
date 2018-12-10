package config;

import exception.GlobalDefaultExceptionHandler;
import handler.RegisterHandler;
import org.springframework.web.WebApplicationInitializer;
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;
import org.springframework.web.servlet.DispatcherServlet;

import javax.security.auth.login.Configuration;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRegistration;

public class WebAppInitializer implements WebApplicationInitializer {

    public void onStartup(ServletContext servletContext) throws ServletException {
        AnnotationConfigWebApplicationContext context = new AnnotationConfigWebApplicationContext();

        // adding config classes
        context.register(WebConfig.class, HibernateConfig.class,WebFlowConfig.class, RegisterHandler.class);
        context.setServletContext(servletContext);


        DispatcherServlet dispatcherServlet = new DispatcherServlet(context);

        // for Custom Error Page need to throw exception
        dispatcherServlet.setThrowExceptionIfNoHandlerFound(true);

        //testing
//        dispatcherServlet.getMultipartResolver();


        ServletRegistration.Dynamic dispatcher = servletContext.addServlet("dispatcher", dispatcherServlet);
        dispatcher.setLoadOnStartup(1);
        dispatcher.addMapping("/"); // <servlet-mapping>

    }
}
