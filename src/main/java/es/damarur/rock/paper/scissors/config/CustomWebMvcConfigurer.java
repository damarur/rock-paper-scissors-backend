package es.damarur.rock.paper.scissors.config;

import lombok.NonNull;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class CustomWebMvcConfigurer {

	@Bean
	public WebMvcConfigurer webMvcConfigurer() {
		return new WebMvcConfigurer() {
			@Override
			public void addCorsMappings(@NonNull CorsRegistry registry) {
				registry
					.addMapping("/**")
					.allowedMethods("GET", "POST", "PUT", "DELETE", "OPTIONS")
					.allowedOrigins("http://localhost:4200")
					.allowCredentials(false)
					.exposedHeaders("Location");
			}
		};
	}

}
