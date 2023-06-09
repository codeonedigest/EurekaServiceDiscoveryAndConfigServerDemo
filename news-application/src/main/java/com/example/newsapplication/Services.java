package com.example.newsapplication;

import com.vaadin.flow.spring.SpringServlet;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Service;
import org.springframework.web.context.support.WebApplicationContextUtils;

import javax.servlet.ServletContext;

/**
 * @author CodeOneDigest
 */
@Service
public class Services {

    public static CompanyService getCompanyService() {
        return getApplicationContext().getBean(CompanyService.class);
    }

    public static ApplicationContext getApplicationContext() {
        ServletContext servletContext = SpringServlet.getCurrent().getServletContext();
        return WebApplicationContextUtils.getWebApplicationContext(servletContext);
    }

}
