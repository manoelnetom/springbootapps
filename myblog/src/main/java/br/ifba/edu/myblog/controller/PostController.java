package br.ifba.edu.myblog.controller;

import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
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
import br.ifba.edu.myblog.dto.PostDto;
import br.ifba.edu.myblog.dto.PostForm;
import br.ifba.edu.myblog.model.Post;
import br.ifba.edu.myblog.repository.PostRepository;
import br.ifba.edu.myblog.repository.UsuarioRepository;

@RestController
@RequestMapping("/posts")
public class PostController {

	@Autowired
	private PostRepository repository;
	@Autowired
	private UsuarioRepository usuarioRepository;
	
	@GetMapping
	public Page<PostDto> listar(@RequestParam(required = false) String titulo, Pageable pageable){
		
		//Pageable pageable = PageRequest.of(pagina, qtd);
		
		if((titulo!=null) && (!titulo.equals(""))) {
			return PostDto.converte(repository.findByTitulo(titulo,pageable));
		}
		
		return PostDto.converte(repository.findAll(pageable));	
	}
	
	@PostMapping
	public ResponseEntity<PostDto> cadastrar(@RequestBody PostForm form){
		Post post= form.converter(usuarioRepository);
		repository.save(post);
		return new ResponseEntity<PostDto>(new PostDto(post),HttpStatus.CREATED);
	}
	
	@PutMapping("/{id}")
	@Transactional
	public ResponseEntity<PostDto> atualizar(@PathVariable Long id, @RequestBody PostForm form){
	
		Post post= form.atualiza(id, repository, usuarioRepository);
		
		return new ResponseEntity<PostDto>(new PostDto(post),HttpStatus.OK);
	}
	
	@DeleteMapping("/{id}")
	@Transactional
	public ResponseEntity<?> apagar(@PathVariable Long id){
	
		 repository.deleteById(id);
		
		return new ResponseEntity<>(HttpStatus.OK);
	}	
}
