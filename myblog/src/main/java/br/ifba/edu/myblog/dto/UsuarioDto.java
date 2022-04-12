package br.ifba.edu.myblog.dto;

import java.util.List;
import java.util.stream.Collectors;

import br.ifba.edu.myblog.model.Usuario;

public class UsuarioDto {

    private Long id;
	private String nome;
	private String login;
	
	
	
	
	public static List<UsuarioDto> converte(List<Usuario> lista){
		return lista.stream().map(UsuarioDto::new).collect(Collectors.toList());
	}
	
	public UsuarioDto(Usuario usuario) {
		super();
		this.id = usuario.getId();
		this.nome = usuario.getNome();
		this.login = usuario.getLogin();
	}
	
	public UsuarioDto() {}
	
	public Long getId() {
		return id;
	}
	public String getNome() {
		return nome;
	}
	public String getLogin() {
		return login;
	}
	
	
}
