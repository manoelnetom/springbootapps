package br.ifba.edu.myblog.dto;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.Length;

import br.ifba.edu.myblog.model.Usuario;

public class UsuarioForm {
	
	
	private Long id;
	
	@NotNull(message = "O nome não pode ser nulo") 
	@NotBlank(message = "O nome não pode ser vazio")
	private String nome;
	@Length(min=5,message = "O login tem min de 5 caractres")
	private String login;
	private String senha;
	
	public UsuarioForm(Usuario usuario) {
		
		this.id= usuario.getId();
		this.nome = usuario.getNome();
		this.login = usuario.getLogin();
		this.senha=usuario.getSenha();
	}
	
	public Usuario converter() {
		Usuario usuario=new Usuario();
		usuario.setNome(this.getNome());
		usuario.setLogin(this.getLogin());
		usuario.setSenha(this.getSenha());
		return usuario;
	}
	
	public UsuarioForm() {}

	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}
	
	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}
	
}

