package br.ifba.edu.myblog.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import br.ifba.edu.myblog.model.Usuario;

public interface UsuarioRepository extends JpaRepository<Usuario, Long> {

	Optional<Usuario> findByLogin(String login); 
}
