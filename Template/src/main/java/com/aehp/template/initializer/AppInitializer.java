package com.aehp.template.initializer;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRegistration.Dynamic;

import org.springframework.web.WebApplicationInitializer;
import org.springframework.web.context.ContextLoaderListener;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.request.RequestContextListener;
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;
import org.springframework.web.servlet.DispatcherServlet;

import com.aehp.template.config.WebMvcConfig;

public class AppInitializer implements WebApplicationInitializer {

	private static final String MAPPING_URL = "/";
	private static final String[] DISPATCHER_SERVLET_MAPPINGS = new String[] {MAPPING_URL};
	private static final String DISPATCHER_SERVLET_NAME = "dispatcher";

	@Override
	public void onStartup(ServletContext servletContext) throws ServletException {
		WebApplicationContext context = getContext(servletContext);

//		servletContext.addListener(new ContextLoaderListener(context));
//		servletContext.addListener(new RequestContextListener());

        // Create a servlet mapping for Dispatcher Servlet.
        Dynamic dispatcherServlet =
            servletContext.addServlet(DISPATCHER_SERVLET_NAME, new DispatcherServlet(context));
        dispatcherServlet.addMapping(DISPATCHER_SERVLET_MAPPINGS);
        dispatcherServlet.setLoadOnStartup(1);
	}

	private AnnotationConfigWebApplicationContext getContext(ServletContext servletContext) {
		AnnotationConfigWebApplicationContext context = new AnnotationConfigWebApplicationContext();
		context.register(WebMvcConfig.class);
		context.setServletContext(servletContext);
		return context;
	}
}
