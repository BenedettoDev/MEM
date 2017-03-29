package net.mem;

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
	public void globalConfig(AuthenticationManagerBuilder auth) throws Exception {
		auth.inMemoryAuthentication().withUser("Benedetto").password("test1").roles("ADMIN");
	}	
	
	@Override
	protected void configure(HttpSecurity http) throws Exception {
//		http.authorizeRequests().antMatchers("/**").permitAll();
		http
			.csrf().disable()
			
			.authorizeRequests()
				.antMatchers("/css/**,/img/**").permitAll()
				.antMatchers("/Admin/**").hasRole("ADMIN")
				.and()
			.formLogin()
				.loginPage("/Login").permitAll().defaultSuccessUrl("/Admin/Index")
				.and()
			.logout()
				.invalidateHttpSession(true).logoutUrl("/Logout").permitAll();
	}
	
}
