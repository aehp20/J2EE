package com.aehp.template.config;

import org.hdiv.web.validator.EditableParameterValidator;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.validation.Validator;
import org.springframework.web.servlet.config.annotation.DefaultServletHandlerConfigurer;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

@EnableWebMvc
@ComponentScan(basePackages = { "com.aehp.template.model",
		"com.aehp.template.webapp", "com.aehp.template.service" })
@Import(DBConfig.class)
@Configuration
public class WebMvcConfig extends WebMvcConfigurerAdapter {

	// @Override
	// public void addResourceHandlers(ResourceHandlerRegistry registry) {
	// registry.addResourceHandler("/assets/**").addResourceLocations("classpath:/META-INF/resources/webjars/").setCachePeriod(31556926);
	// registry.addResourceHandler("/css/**").addResourceLocations("/css/").setCachePeriod(31556926);
	// registry.addResourceHandler("/img/**").addResourceLocations("/img/").setCachePeriod(31556926);
	// registry.addResourceHandler("/js/**").addResourceLocations("/js/").setCachePeriod(31556926);
	// }

	// // This overrides the javax field validator with HDIV
	// // Remove this block to disable HDIV field validation
	// @Override
	// public Validator getValidator() {
	// return getParameterValidator();
	// }

	// @Bean
	// public EditableParameterValidator getParameterValidator() {
	// return new EditableParameterValidator();
	// }

	@Override
	public void configureDefaultServletHandling(
			DefaultServletHandlerConfigurer configurer) {
		configurer.enable();
	}

	@Bean
	public InternalResourceViewResolver getInternalResourceViewResolver() {
		InternalResourceViewResolver resolver = new InternalResourceViewResolver();
		resolver.setPrefix("/WEB-INF/pages/");
		resolver.setSuffix(".jsp");

		return resolver;
	}
}
