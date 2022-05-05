package br.com.apifilmes.controller;



import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import br.com.apifilmes.dto.FilmeDto;
import br.com.apifilmes.service.FilmeService;

@RestController
@RequestMapping("/filmes")
public class FilmeController {
	
	@Autowired
	private FilmeService service;
	
	@GetMapping
	public Page<FilmeDto> listar(@RequestParam(required = false) String nome, Pageable pageble) {
		return service.listar(nome, pageble);	
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<FilmeDto> detalhar(@PathVariable Long id){
		return service.detalhar(id);
	}
	
	@PostMapping
	public ResponseEntity<FilmeDto> cadastrar(@RequestBody FilmeDto filmeDto){
		return service.cadastrar(filmeDto);
	}
	
	@PutMapping
	@Transactional
	public ResponseEntity<FilmeDto> atualizar(@RequestBody FilmeDto filme){
		return service.atualizar(filme);
	}
	
	@DeleteMapping("/{id}")
	@Transactional
	public ResponseEntity<FilmeDto> apagar(@PathVariable Long id){
		return service.apagar(id);
	}

}
