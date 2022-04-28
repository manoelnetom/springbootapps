package br.edu.ifba.agenda.config.security;

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

	//COonfiguração de Autenticação
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
	}
	
	//Configuração de Autorização
	protected void configure(HttpSecurity http) throws Exception {
		http.authorizeHttpRequests()
		.antMatchers(HttpMethod.GET,"/pessoas").permitAll()
		.antMatchers(HttpMethod.GET,"pessoas/*").permitAll()
		.anyRequest().authenticated();
	}
	
	//Configuração de recursos estaticos como Js, imagem, css
	public void configure(WebSecurity web) throws Exception {	
	}
}
