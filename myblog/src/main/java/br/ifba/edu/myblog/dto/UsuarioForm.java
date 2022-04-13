package br.ifba.edu.myblog.dto;



import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.Length;

import br.ifba.edu.myblog.model.Usuario;
import br.ifba.edu.myblog.repository.UsuarioRepository;

public class UsuarioForm {
	
	
	private Long id;
	@NotNull @NotEmpty @Length(min = 2)
	private String nome;
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
	
	public Usuario atualiza(UsuarioRepository repository, Long id) {
		Usuario usuario=repository.getById(id);
		usuario.setNome(nome);
		usuario.setLogin(login);
		usuario.setSenha(senha);
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

