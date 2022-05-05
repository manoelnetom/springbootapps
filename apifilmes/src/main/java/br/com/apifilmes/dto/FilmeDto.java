package br.com.apifilmes.dto;

import org.springframework.data.domain.Page;

import br.com.apifilmes.model.Filme;

public class FilmeDto {
	
	private Long id;
	private String nome;
	private String sinopse;
	private String foto;
	
	public FilmeDto(Filme filme) {
		
		this.id = filme.getId();
		this.nome = filme.getNome();
		this.sinopse = filme.getSinopse();
		this.foto = filme.getFoto();
	}
	
	public FilmeDto() {}

	public static Page<FilmeDto> convertePaginas(Page<Filme> paginas){
		return paginas.map(FilmeDto::new);
	}
	
	public Filme convertToFilme() {
		Filme filme= new Filme();
		filme.setNome(nome);
		filme.setSinopse(sinopse);
		filme.setFoto(foto);
		return filme;
	}
	
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

	public String getSinopse() {
		return sinopse;
	}

	public void setSinopse(String sinopse) {
		this.sinopse = sinopse;
	}

	public String getFoto() {
		return foto;
	}

	public void setFoto(String foto) {
		this.foto = foto;
	}

	
	
	
	
	
}
