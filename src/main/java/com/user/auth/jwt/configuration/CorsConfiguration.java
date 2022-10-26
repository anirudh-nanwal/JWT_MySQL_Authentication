/**
 * 
 */
package com.user.auth.jwt.configuration;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * @author anirudh.nanwal
 * 
 * Configuration class to handle global CORS related configuration.
 *
 */
@Configuration
public class CorsConfiguration {
	
	private static final String GET = "GET";
	private static final String POST = "POST";
	private static final String PUT = "PUT";
	private static final String DELETE = "DELETE";

	// This configuration will handle all CORS related issues that we may face.
	// We can also use the @CrossOrigin annotations on the Controller methods or the Controller itself.
	// But, then we have to define it for every Controller that exists.
	// We can still combine the annotations and this global handler in order to define something more specific for some APIs.
	public WebMvcConfigurer corsConfigurer() {
		return new WebMvcConfigurer() {
			@Override
			public void addCorsMappings(CorsRegistry registry) {
				registry.addMapping("/**")
				.allowedMethods(GET, PUT, POST, DELETE)
				.allowedHeaders("*")
				.allowedOriginPatterns("*")
				.allowCredentials(true);
			}
		};
	}
}
