package view;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;

import org.lightadmin.api.config.LightAdmin;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.context.web.SpringBootServletInitializer;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;

@Configuration
@ComponentScan
@EnableAutoConfiguration
@Order(Ordered.HIGHEST_PRECEDENCE)
public class ServletInitializer extends SpringBootServletInitializer {

	@Override
    public void onStartup(ServletContext servletContext) throws ServletException {
        LightAdmin.configure(servletContext)
                .basePackage("hello")
                .baseUrl("/admin")
                .security(false)
                .backToSiteUrl("http://localhost:8080");
 
        super.onStartup(servletContext);
    }
	
	@Override
	protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
		return application.sources(Application.class);
	}

}
