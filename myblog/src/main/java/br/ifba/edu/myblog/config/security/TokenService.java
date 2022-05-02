package br.ifba.edu.myblog.config.security;

import java.util.Date;

import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Service;

import br.ifba.edu.myblog.model.Usuario;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

@Service
public class TokenService {

	public String gerarToken(Authentication auth) {
		Usuario logado =(Usuario) auth.getPrincipal();
		Date hoje = new Date();
		Date expiracao = new Date(hoje.getTime()+8000000);
		return Jwts.builder()
				.setIssuer("API DO BLOG")
				.setSubject(logado.getId().toString())
				.setIssuedAt(hoje)
				.setExpiration(expiracao)
				.signWith(SignatureAlgorithm.HS256, "$2a$10$Q4aa/OTpDIjvsua6rm0fqeTG4cU49S8DGCVjoKAn8k3n7DhUo0ozG")
				.compact();
	}

}
