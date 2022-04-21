package br.edu.ifba.agenda.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import br.edu.ifba.agenda.model.Pessoa;

public interface PessoaRepository extends JpaRepository<Pessoa, Long>{

	Page<Pessoa> findByNome(String nome, Pageable pageable);

}
