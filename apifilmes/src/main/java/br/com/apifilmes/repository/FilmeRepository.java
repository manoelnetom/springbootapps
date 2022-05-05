package br.com.apifilmes.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import br.com.apifilmes.model.Filme;

public interface FilmeRepository extends JpaRepository<Filme, Long> {

	Page<Filme> findByNomeContaining(String nome, Pageable pageble);

}
