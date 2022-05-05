package br.com.apifilmes.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import br.com.apifilmes.dto.FilmeDto;
import br.com.apifilmes.model.Filme;
import br.com.apifilmes.repository.FilmeRepository;

@Service
public class FilmeService {

	@Autowired
	private FilmeRepository repository;
	
	public Page<FilmeDto> listar(String nome, Pageable pageble) {
		if(nome!=null && (!nome.equals(""))) {
			return FilmeDto.convertePaginas(repository.findByNomeContaining(nome,pageble));
		}
		return FilmeDto.convertePaginas(repository.findAll(pageble));
	}

	public ResponseEntity<FilmeDto> detalhar(Long id) {
		Filme filme=repository.getById(id);
		if(filme!=null) {
			return new ResponseEntity<FilmeDto>(new FilmeDto(filme),HttpStatus.OK);
		}
		return ResponseEntity.badRequest().build();
	}

	public ResponseEntity<FilmeDto> atualizar(FilmeDto filmedto) {
		Filme filme =repository.getById(filmedto.getId());
		if(filme!=null) {
			filme.setNome(filmedto.getNome());
			filme.setSinopse(filmedto.getSinopse());
			filme.setFoto(filmedto.getFoto());
			repository.save(filme);
			return new ResponseEntity<FilmeDto>(new FilmeDto(filme),HttpStatus.OK);
		}
		return ResponseEntity.badRequest().build();
	}

	public ResponseEntity<FilmeDto> cadastrar(FilmeDto filmeDto) {
		Filme filme=filmeDto.convertToFilme();
		repository.save(filme);
		return new ResponseEntity<FilmeDto>(new FilmeDto(filme),HttpStatus.CREATED);		
	}

	public ResponseEntity<FilmeDto> apagar(Long id) {
		 
		Filme filme =repository.getById(id);
		if(filme!=null) {
			FilmeDto filmeDto = new FilmeDto(filme);
			repository.deleteById(id);
			return new ResponseEntity<FilmeDto>(filmeDto,HttpStatus.OK);
		}
		return ResponseEntity.badRequest().build();
	}

}
