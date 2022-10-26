/**
 * 
 */
package com.user.auth.jwt.configuration;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.AuthenticationEntryPoint;
import org.springframework.stereotype.Component;

/**
 * @author anirudh.nanwal
 *
 * This class is the entry point of all the JWT authentication process.
 */
@Component
public class JwtAuthenticationEntryPoint implements AuthenticationEntryPoint {

	/**
	 * Overridden commence method.
	 *
	**/
	@Override
	public void commence(HttpServletRequest request, HttpServletResponse response,
			AuthenticationException authException) throws IOException, ServletException {

		response.sendError(HttpServletResponse.SC_UNAUTHORIZED, "Unauthorized");
	}

}
