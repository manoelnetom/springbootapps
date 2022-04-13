package br.ifba.edu.myblog.controller;

import java.net.URI;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import br.ifba.edu.myblog.dto.UsuarioDto;
import br.ifba.edu.myblog.dto.UsuarioForm;
import br.ifba.edu.myblog.model.Usuario;
import br.ifba.edu.myblog.repository.UsuarioRepository;

@RestController
@RequestMapping("/usuarios")
public class UsuarioController {
	
	@Autowired
	private UsuarioRepository repository;
	
	@GetMapping
	public List<UsuarioDto> listar(){
		return UsuarioDto.converte(repository.findAll());
	}
	
	
	@PostMapping
	public ResponseEntity<Usuario> cadastrar(@RequestBody @Valid UsuarioForm usuarioForm, UriComponentsBuilder builder) {
		Usuario usuario= usuarioForm.converter();
		repository.save(usuario);
		//URI uri = builder.path("/usuarios/{id}").buildAndExpand(usuario.getId()).toUri();
		return new ResponseEntity<Usuario>(usuario,HttpStatus.CREATED);
		//return ResponseEntity.created(uri).body(usuario);
	}
	
	@GetMapping("/{id}")
	public UsuarioForm detalhar(@PathVariable Long id) {

		return new UsuarioForm(repository.getById(id));
	}

}
