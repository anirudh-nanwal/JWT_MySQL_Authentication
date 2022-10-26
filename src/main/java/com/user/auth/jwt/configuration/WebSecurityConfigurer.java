package com.user.auth.jwt.configuration;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
//import org.springframework.security.config.annotation.web.configuration.WebSecurityCustomizer;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

/**
 * @author anirudh.nanwal
 * 
 * Configuration class to handle Web Security.
 */
@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(prePostEnabled = true)
public class WebSecurityConfigurer {

	@Autowired
	private JwtAuthenticationEntryPoint jwtEntryPoint;

	@Autowired
	private JwtRequestFilter jwtFilter;

	@Autowired
	private UserDetailsService jwtService;

	@Bean
	public AuthenticationManager authenticationManagerBean(HttpSecurity http, BCryptPasswordEncoder bCryptPasswordEncoder) throws Exception {
		return http.getSharedObject(AuthenticationManagerBuilder.class).userDetailsService(jwtService)
				.passwordEncoder(bCryptPasswordEncoder).and().build();
	}

	@Bean
	public SecurityFilterChain filterChain(HttpSecurity httpSecurity) throws Exception {
//		http.csrf().disable().authorizeRequests().antMatchers(HttpMethod.DELETE).hasRole("ADMIN")
//				.antMatchers("/admin/**").hasAnyRole("ADMIN").antMatchers("/user/**").hasAnyRole("USER", "ADMIN")
//				.antMatchers("/login/**").anonymous().anyRequest().authenticated().and().httpBasic().and()
//				.sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS);
		httpSecurity.cors();

		httpSecurity.authorizeRequests().antMatchers("/forAdmin").hasRole("Admin")
			.and()
			.authorizeRequests().antMatchers("/forUser").hasRole("User")
			.and()
			.csrf().disable().authorizeRequests().antMatchers("/authenticate").permitAll()
//		.csrf(csrf -> csrf.csrfTokenRepository(CookieCsrfTokenRepository.withHttpOnlyFalse())).authorizeRequests().antMatchers("/authenticate").permitAll()
			.and()
			.exceptionHandling().authenticationEntryPoint(jwtEntryPoint)
			.and()
			.sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS);

		return httpSecurity.addFilterBefore(jwtFilter, UsernamePasswordAuthenticationFilter.class).build();
	}

//	This method is used to ignore certain paths like images and scripts for the UI.
//	@Bean
//	public WebSecurityCustomizer webSecurityCustomizer() {
//	    return (web) -> web.debug(securityDebug)
//	      .ignoring()
//	      .antMatchers("/css/**", "/js/**", "/img/**", "/lib/**", "/favicon.ico");
//	}
	
	@Bean
	public PasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}

	@Autowired
	public void configureGlobal(AuthenticationManagerBuilder builder) throws Exception {
		builder.userDetailsService(jwtService).passwordEncoder(passwordEncoder());
	}

//	@Override
//	protected void configure(HttpSecurity httpSecurity) throws Exception {
//		httpSecurity.cors();
//
//		httpSecurity.authorizeRequests().antMatchers("/forAdmin").hasRole("Admin").and().authorizeRequests()
//				.antMatchers("/forUser").hasRole("User").and().csrf().disable().authorizeRequests()
//				.antMatchers("/authenticate").permitAll()
////		.csrf(csrf -> csrf.csrfTokenRepository(CookieCsrfTokenRepository.withHttpOnlyFalse())).authorizeRequests().antMatchers("/authenticate").permitAll()
//				.and().exceptionHandling().authenticationEntryPoint(jwtEntryPoint).and().sessionManagement()
//				.sessionCreationPolicy(SessionCreationPolicy.STATELESS);
//
////		httpSecurity.csrf().disable().authorizeRequests().antMatchers("/authenticate").permitAll()
////		.anyRequest().authenticated()
////		.and()
////		.exceptionHandling().authenticationEntryPoint(jwtEntryPoint)
////		.and()
////		.sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS);
//
//		httpSecurity.addFilterBefore(jwtFilter, UsernamePasswordAuthenticationFilter.class);
//	}
}
