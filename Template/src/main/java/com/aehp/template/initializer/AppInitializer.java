package com.aehp.template.initializer;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRegistration.Dynamic;

import org.springframework.web.WebApplicationInitializer;
import org.springframework.web.context.ContextLoaderListener;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;
import org.springframework.web.servlet.DispatcherServlet;

public class AppInitializer implements WebApplicationInitializer {

	private static final String CONFIG_LOCATION = "com.aehp.template.config";
	private static final String MAPPING_URL = "/";

	@Override
	public void onStartup(ServletContext servletContext) throws ServletException {
		WebApplicationContext context = getContext(servletContext);
		servletContext.addListener(new ContextLoaderListener(context));
//		ServletRegistration.Dynamic dispatcher = servletContext.addServlet("DispatcherServlet", new DispatcherServlet(context));
//		dispatcher.setLoadOnStartup(1);
//		dispatcher.addMapping(MAPPING_URL);

//		AnnotationConfigWebApplicationContext ctx = new AnnotationConfigWebApplicationContext();
//        ctx.register(WebMvcConfig.class);
//        ctx.setServletContext(servletContext);

        Dynamic servlet = servletContext.addServlet("MyDispatcher", new DispatcherServlet(context));
        servlet.addMapping(MAPPING_URL);
        servlet.setLoadOnStartup(1);
	}

	private AnnotationConfigWebApplicationContext getContext(ServletContext servletContext) {
		AnnotationConfigWebApplicationContext context = new AnnotationConfigWebApplicationContext();
		context.setConfigLocation(CONFIG_LOCATION);
		context.setServletContext(servletContext);
		return context;
	}
}
