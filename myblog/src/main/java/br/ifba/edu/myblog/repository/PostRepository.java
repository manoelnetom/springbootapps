package br.ifba.edu.myblog.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import br.ifba.edu.myblog.model.Post;

public interface PostRepository extends JpaRepository<Post, Long>{

	List<Post> findByTitulo(String titulo);

}
