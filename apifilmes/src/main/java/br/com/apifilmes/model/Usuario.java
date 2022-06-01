package br.com.apifilmes.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;


@Entity(name = "usuarios")
public class Usuario {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	private String username;
	private String password;
	@ManyToMany(fetch = FetchType.EAGER)
	private List<Perfil> perfil=new ArrayList<>();
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	
	public void setUsername(String username) {
		this.username = username;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	
	
	public String getPassword() {
		// TODO Auto-generated method stub
		return this.password;
	}
	
	public String getUsername() {
		// TODO Auto-generated method stub
		return this.username;
	}
	
	public boolean isAccountNonExpired() {
		// TODO Auto-generated method stub
		return true;
	}
	
	public boolean isAccountNonLocked() {
		// TODO Auto-generated method stub
		return true;
	}
	
	public boolean isCredentialsNonExpired() {
		// TODO Auto-generated method stub
		return true;
	}
	
	public boolean isEnabled() {
		// TODO Auto-generated method stub
		return true;
	}

}
