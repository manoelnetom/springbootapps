package br.ifba.edu.myblog.dto;

import br.ifba.edu.myblog.model.Categoria;
import br.ifba.edu.myblog.model.Post;
import br.ifba.edu.myblog.repository.PostRepository;
import br.ifba.edu.myblog.repository.UsuarioRepository;

public class PostForm {

	private Long id;
	private String titulo;
	private String texto;
	private Long usuario;
	private Categoria categoria;
	
	
	
	public PostForm(Post post) {
		this.id = post.getId();
		this.titulo = post.getTitulo();
		this.texto = post.getTexto();
		this.usuario = post.getUsuario().getId();
		this.categoria = post.getCategoria();
	}


	public PostForm() {
		
	}

	public Long getId() {
		return id;
	}



	public String getTitulo() {
		return titulo;
	}



	public String getTexto() {
		return texto;
	}



	public Long getUsuario() {
		return usuario;
	}



	public Categoria getCategoria() {
		return categoria;
	}


	public Post converter(UsuarioRepository usuarioRepository) {
		
		Post post=new Post();
		post.setId(id);
		post.setTitulo(titulo);
		post.setTexto(texto);
		post.setUsuario(usuarioRepository.getById(usuario));
		post.setCategoria(categoria);
		return post;
	}


	public Post atualiza(Long id, PostRepository repository, UsuarioRepository usuarioRepository) {
		
		Post post= repository.getById(id);
		post.setTitulo(titulo);
		post.setTexto(texto);
		post.setUsuario(usuarioRepository.getById(usuario));
		post.setCategoria(categoria);
		return post;
	}
	
}
