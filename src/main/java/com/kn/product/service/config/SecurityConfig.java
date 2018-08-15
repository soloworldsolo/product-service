package com.kn.product.service.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationTrustResolver;
import org.springframework.security.authentication.AuthenticationTrustResolverImpl;
import org.springframework.security.authentication.DefaultAuthenticationEventPublisher;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
//import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
//import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;

//import com.kn.employee.service.security.RestAuthenticationEntryPoint;

import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {

	// @Autowired

	// private UserDetailsService userDetailsService;

	// @Autowired
	// private RestAuthenticationEntryPoint restAuthenticationEntryPoint;

	// @Autowired
	/// private AuthenticationSuccessHandler authenticationSuccessHandler;

	// @Autowired

	// private CustomAuthenticationFailureHandler authenticationFailureHandler;

	public SecurityConfig() {

		super();

	}

	@Autowired
	public void configureGlobalSecurity(AuthenticationManagerBuilder auth) throws Exception {
		auth.inMemoryAuthentication().withUser("user").password("tiedfox").roles("USER");
		// auth.authenticationProvider(authenticationProvider());
		// auth.authenticationEventPublisher(defaultAuthenticationEventPublisher());
	}

	/**
	 * 
	 * Configure the HttpSecurity
	 * 
	 * 
	 * 
	 * @param http
	 * 
	 *            the HttpSecurity to modify
	 * 
	 * @throws Exception
	 * 
	 *             if an error occurs
	 * 
	 */

	@Override

	protected void configure(HttpSecurity http) throws Exception {

	//	http.authorizeRequests().anyRequest().authenticated().and()

		//		.httpBasic()
			    http.csrf().disable();

				// .antMatchers("/api/sfdc**").permitAll()

				// .antMatchers("/api/").authenticated()

			//	.and()

				// .formLogin()

				// .successHandler(authenticationSuccessHandler).failureHandler(authenticationFailureHandler)

				// .and()

				//.csrf().disable()

				//.exceptionHandling();

		// .authenticationEntryPoint(restAuthenticationEntryPoint);

	}

	/**
	 * 
	 * Configure the PasswordEncoder that uses the BCrypt strong hashing
	 * 
	 * function.
	 *
	 * 
	 * 
	 * @return PasswordEncoder the implementation of BCryptPasswordEncoder
	 * 
	 */

	@Bean

	public PasswordEncoder passwordEncoder() {

		return new BCryptPasswordEncoder();

	}

	/**
	 * 
	 * Configure the authentication provider with user details service ans
	 * 
	 * password encoder.
	 * 
	 * 
	 * 
	 * @return DaoAuthenticationProvider
	 * 
	 */

	/*
	 * @Bean
	 * 
	 * public DaoAuthenticationProvider authenticationProvider() {
	 * 
	 * DaoAuthenticationProvider authenticationProvider = new
	 * DaoAuthenticationProvider();
	 * 
	 * // authenticationProvider.setUserDetailsService(userDetailsService);
	 * 
	 * authenticationProvider.setPasswordEncoder(passwordEncoder());
	 * 
	 * authenticationProvider.setHideUserNotFoundExceptions(false);
	 * 
	 * return authenticationProvider;
	 * 
	 * }
	 */
	/**
	 * 
	 * Basic implementation of AuthenticationTrustResolver.
	 * 
	 * 
	 * 
	 * @return AuthenticationTrustResolver
	 * 
	 */

	/*
	 * @Bean
	 * 
	 * public AuthenticationTrustResolver getAuthenticationTrustResolver() {
	 * 
	 * return new AuthenticationTrustResolverImpl();
	 * 
	 * }
	 * 
	 * @Bean
	 * 
	 * DefaultAuthenticationEventPublisher defaultAuthenticationEventPublisher()
	 * {
	 * 
	 * return new DefaultAuthenticationEventPublisher();
	 * 
	 * }
	 */
}
