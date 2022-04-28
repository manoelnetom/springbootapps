package br.ifba.edu.myblog.config.security;

import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@EnableWebSecurity
@Configuration
public class SecurityConfigurations extends WebSecurityConfigurerAdapter{
    //Autenticação
	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		
	}
	//Autorização
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http.authorizeHttpRequests()
		.antMatchers(HttpMethod.GET,"/posts").permitAll()
		.antMatchers(HttpMethod.GET,"/posts/*").permitAll()
		.anyRequest().authenticated()
		.and().formLogin();
		
	}
	//Recursos estaticos
	@Override
	public void configure(WebSecurity web) throws Exception {
		
	}
}
