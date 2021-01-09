package io.blakehowe.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

	@Autowired
	UserDetailsServiceImpl userDetailsService;

	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		auth.userDetailsService(userDetailsService);
	}

	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http.authorizeRequests().mvcMatchers(HttpMethod.GET, "/productapi/product/{id:^[0-9]*$}", "/index", "/showGetProduct",
				"/getProduct", "/productDetails").hasAnyRole("USER", "ADMIN")
				.mvcMatchers(HttpMethod.GET, "/showCreateProduct", "/createProduct", "/createResponse").hasRole("ADMIN")
				.mvcMatchers(HttpMethod.POST, "/getProduct").hasAnyRole("USER", "ADMIN")
				.mvcMatchers(HttpMethod.POST, "/productapi/product", "/saveProduct").hasRole("ADMIN")
				.mvcMatchers("/", "/login").permitAll()
				.anyRequest().denyAll().and().csrf().disable().logout().logoutSuccessUrl("/"); // Disable CSRF to use Postman
	}

	@Bean
	public PasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}
	
	@Override
	@Bean
	protected AuthenticationManager authenticationManager() throws Exception {
		return super.authenticationManager();
	}
}
