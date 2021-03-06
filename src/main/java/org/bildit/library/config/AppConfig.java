package org.bildit.library.config;

import org.springframework.context.MessageSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.support.ResourceBundleMessageSource;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import org.springframework.web.servlet.view.InternalResourceViewResolver;
import org.springframework.web.servlet.view.JstlView;

/**
 * @author Ognjen Mi�i�
 *
 */
@Configuration
@EnableWebMvc
@ComponentScan("org.bildit.library*")
@EnableTransactionManagement
// ova anotacija ka�e konfiguraciji gdje se nalazi database.properties file (u
// root folderu u ovom slu�aju)
public class AppConfig extends WebMvcConfigurerAdapter {

	// defini�emo tip view fajlova sa kojim radimo i gdje se oni nalaze
	@Bean
	public InternalResourceViewResolver setupViewResolver() {
		InternalResourceViewResolver resolver = new InternalResourceViewResolver();
		resolver.setPrefix("/WEB-INF/views/");
		resolver.setSuffix(".jsp");
		resolver.setViewClass(JstlView.class);
		return resolver;
	}

	// defini�emo na�e custom validation poruke u properties fajlu, ne�emo ih
	// hardkodovati
//	@Bean
//	public MessageSource messageSource() {
//		ResourceBundleMessageSource messageSource = new ResourceBundleMessageSource();
//		messageSource.setBasename("messages");
//		return messageSource;
//	}

	// u�itavanje stati�nih resursa kao �to su css, js i ostali fajlovi bla bla
	// bla
	@Override
	public void addResourceHandlers(ResourceHandlerRegistry reg) {
		reg.addResourceHandler("/resources/**").addResourceLocations("/resources/");
	}
	
	
}
