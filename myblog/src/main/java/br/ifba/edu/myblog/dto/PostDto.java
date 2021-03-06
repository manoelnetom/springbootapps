package br.ifba.edu.myblog.dto;


import org.springframework.data.domain.Page;

import br.ifba.edu.myblog.model.Categoria;
import br.ifba.edu.myblog.model.Post;

public class PostDto {
	private Long id;
	private String titulo;
	private String texto;
	private String nomeUsuario;
	private Categoria categoria;
	
	
	
	public PostDto(Post post) {
		this.id = post.getId();
		this.titulo = post.getTitulo();
		this.texto = post.getTexto();
		this.nomeUsuario = post.getUsuario().getNome();
		this.categoria = post.getCategoria();
	}
	
	public static Page<PostDto> converte(Page<Post> page){
		
		//List<PostDto> listaDto=new ArrayList<>();
		//for (int i=0; i<lista.size();i++) {
		//	listaDto.add(new PostDto(lista.get(i)));
		//}
		return page.map(PostDto::new);
	
	
	}
	
	public PostDto() {
		
	}
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getTitulo() {
		return titulo;
	}
	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}
	public String getTexto() {
		return texto;
	}
	public void setTexto(String texto) {
		this.texto = texto;
	}
	public String getNomeUsuario() {
		return nomeUsuario;
	}
	public void setNomeUsuario(String nomeUsuario) {
		this.nomeUsuario = nomeUsuario;
	}
	public Categoria getCategoria() {
		return categoria;
	}
	public void setCategoria(Categoria categoria) {
		this.categoria = categoria;
	}
	
	
	
}
