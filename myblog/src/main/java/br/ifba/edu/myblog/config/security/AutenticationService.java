package br.ifba.edu.myblog.config.security;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import br.ifba.edu.myblog.model.Usuario;
import br.ifba.edu.myblog.repository.UsuarioRepository;

@Service
public class AutenticationService implements UserDetailsService {

	@Autowired
	UsuarioRepository repository;
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		Optional<Usuario> usuario=repository.findByLogin(username);
		if(usuario.isPresent()) {
			return usuario.get();
		}
		throw new UsernameNotFoundException("Usuário não encontrado");
	}

}
