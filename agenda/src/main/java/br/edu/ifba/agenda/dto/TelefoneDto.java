package br.edu.ifba.agenda.dto;



import java.util.ArrayList;
import java.util.List;

import br.edu.ifba.agenda.model.Categoria;
import br.edu.ifba.agenda.model.Pessoa;
import br.edu.ifba.agenda.model.Telefone;

public class TelefoneDto {
    
	private Long id;
	private String numero;
	private Categoria categoria;
	
	
	public TelefoneDto(Telefone telefone) {
		
		this.id = telefone.getId();
		this.numero = telefone.getNumero();
		this.categoria = telefone.getCategoria();
	}
	public TelefoneDto() {
		
	}
	
	public static List<TelefoneDto> converLista(List<Telefone> lista){
		List<TelefoneDto> listaDto=new ArrayList<>();
		for (int i=0; i<lista.size();i++) {
			listaDto.add(new TelefoneDto(lista.get(i)));
		}
		return listaDto;
	}
	
	public Long getId() {
		return id;
	}
	public String getNumero() {
		return numero;
	}
	public Categoria getCategoria() {
		return categoria;
	}
	
	
}
