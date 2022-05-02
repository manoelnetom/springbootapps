package br.ifba.edu.myblog.controller;


import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.ifba.edu.myblog.config.security.TokenService;
import br.ifba.edu.myblog.dto.LoginForm;
import br.ifba.edu.myblog.dto.TokenForm;

@RestController
@RequestMapping("/auth")
public class AutenticacaoController {
	
	@Autowired
	private AuthenticationManager authManager;
	
	@Autowired
	private TokenService tokenService;
	
	@PostMapping
	public ResponseEntity<TokenForm> autenticar(@RequestBody @Valid LoginForm form){
		
		UsernamePasswordAuthenticationToken dadosLogin= form.converter();
		try {
			Authentication auth=  authManager.authenticate(dadosLogin);
			String token=tokenService.gerarToken(auth);
			return ResponseEntity.ok(new TokenForm(token,"Bearer"));
			
		} catch (AuthenticationException e) {
			return ResponseEntity.badRequest().build();
					
		}
		
	}

}
