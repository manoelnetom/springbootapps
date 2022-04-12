package br.ifba.edu.myblog.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.ifba.edu.myblog.model.Usuario;

public interface UsuarioRepository extends JpaRepository<Usuario, Long> {

}
