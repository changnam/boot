package com.honsoft.web.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.ViewResolverRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

@Configuration
@EnableWebMvc
public class WebConfig implements WebMvcConfigurer{
	@Override
	public void configureViewResolvers(ViewResolverRegistry registry) {
		registry.jsp("/WEB-INF/jsp/",".jsp"); //ViewResovlerComposite
	}
	
	@Override
	public void addViewControllers(ViewControllerRegistry registry) {
		registry.addViewController("/").setViewName("welcome");
		registry.addViewController("/hello").setViewName("thymeleaf/hello"); //thymeleaf
		registry.addViewController("/hellojsp").setViewName("hello"); //jsp
	}

	@Bean
	public ViewResolver customViewResolver() {
		InternalResourceViewResolver customViewResolver = new InternalResourceViewResolver();
		customViewResolver.setPrefix("/WEB-INF/jsp/");
		customViewResolver.setSuffix(".jsp");
		//customViewResolver.setOrder(Ordered.LOWEST_PRECEDENCE - 10);
		//customViewResolver.setViewNames("jsp/*");
		return customViewResolver;
	}
}
