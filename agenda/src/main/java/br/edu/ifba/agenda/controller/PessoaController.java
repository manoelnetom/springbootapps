package br.edu.ifba.agenda.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
//import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import br.edu.ifba.agenda.dto.PessoaDto;
import br.edu.ifba.agenda.repository.PessoaRepository;

@RestController
@RequestMapping("/pessoas")
public class PessoaController {
	
	@Autowired
	PessoaRepository repository;
	
	@GetMapping
	public Page<PessoaDto> listar(@RequestParam(required = false) String nome,Pageable pageable){
		//Pageable pageable = PageRequest.of(pagina, qtd);
		if(nome!=null) {
			return PessoaDto.coverteLista(repository.findByNome(nome,pageable));
		}
		return PessoaDto.coverteLista(repository.findAll(pageable));
		
	}

}
