package br.ifba.edu.myblog.dto;

public class TokenForm {

	private String token;
	private String tipo;
	
	public TokenForm(String token, String tipo) {
		this.token = token;
		this.tipo=tipo;
	}

	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	public String getToken() {
		return token;
	}

	public void setToken(String token) {
		this.token = token;
	}
	
	
	
}
