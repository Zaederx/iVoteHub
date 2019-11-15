package app.iVoteHub.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
//import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.DefaultServletHandlerConfigurer;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.view.InternalResourceViewResolver;
import org.springframework.web.servlet.view.JstlView;

@Configuration
public class WebConfig implements WebMvcConfigurer{
	
	@Override
	public void addResourceHandlers(ResourceHandlerRegistry registry) {
		registry.addResourceHandler("/resources/**").addResourceLocations("/resources/");
//		WebMvcConfigurer.super.addResourceHandlers(registry);
	}
	
	/*Allows bootstrap to be used with Spring security*/
	@Override
	public void configureDefaultServletHandling(DefaultServletHandlerConfigurer configurer) {
		configurer.enable();
//		WebMvcConfigurer.super.configureDefaultServletHandling(configurer);
	}
	 
	@Bean
	public InternalResourceViewResolver jstlViewResolver() {
		InternalResourceViewResolver resolver = new InternalResourceViewResolver();
		resolver.setViewClass(JstlView.class);
		resolver.setPrefix("/WEB-INF/views/");
		/* without the / before WEB-INF - spring will append context 
		 * folder context infront of WEB-INF - takes you to incoreect address*/
		resolver.setSuffix(".jsp");
		
		return resolver;
	}

}
