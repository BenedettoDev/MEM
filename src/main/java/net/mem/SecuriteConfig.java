package net.mem;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@Configuration
@EnableWebSecurity
public class SecuriteConfig extends WebSecurityConfigurerAdapter {
	@Autowired
	DataSource dataSource;
	
	@Autowired
	public void globalConfig(AuthenticationManagerBuilder auth) throws Exception {
		
	auth.jdbcAuthentication().dataSource(dataSource)
	.usersByUsernameQuery("SELECT username, password,actived FROM utilisateur  WHERE username=?")
	.authoritiesByUsernameQuery("SELECT utilisateur_username,roles_role FROM users_roles  WHERE utilisateur_username = ?")
		.rolePrefix("ROLE_");
	}	
	
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http
			.csrf().disable()
			
			.authorizeRequests()
				.antMatchers("/css/**,/img/**,/js/**").permitAll()
				.antMatchers("/Admin/**").hasRole("ADMIN")
				.antMatchers("/Utilisateur/**").hasRole("USER")
				.and()
			.formLogin()
				.loginPage("/Login").permitAll().defaultSuccessUrl("/Index")
				.and()
			.logout()
				.invalidateHttpSession(true).logoutUrl("/Logout").permitAll();
	}
	
}
