package br.ifba.edu.myblog.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import br.ifba.edu.myblog.model.Post;

public interface PostRepository extends JpaRepository<Post, Long>{

	List<Post> findByTitulo(String titulo);

	List<Post> findByTituloContaining(String titulo);

	List<Post> findByUsuarioNome(String nome);

	List<Post> findByUsuarioNomeAndTitulo(String usuario, String titulo);

	List<Post> findByUsuarioNomeOrTituloContaining(String usuario, String titulo);

	List<Post> findByUsuarioNomeContainingAndTituloContaining(String usuario, String titulo);

	List<Post> findByTituloContainingAndTextoContaining(String titulo, String titulo2);

}
