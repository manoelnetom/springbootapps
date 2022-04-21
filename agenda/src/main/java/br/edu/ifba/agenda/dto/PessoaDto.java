package br.edu.ifba.agenda.dto;

import java.util.List;

import org.springframework.data.domain.Page;


import br.edu.ifba.agenda.model.Pessoa;
import br.edu.ifba.agenda.model.Telefone;
import br.edu.ifba.agenda.repository.PessoaRepository;


public class PessoaDto {

	private Long id;
	private String nome;
	private String sobrenome;
	private String email;
	private String endereco;
	private List<TelefoneDto> telefones;
	
	public PessoaDto(Pessoa pessoa) {
		this.id = pessoa.getId();
		this.nome = pessoa.getNome();
		this.sobrenome = pessoa.getSobrenome();
		this.email = pessoa.getEmail();
		this.endereco = pessoa.getEndereco();
		this.telefones = TelefoneDto.converLista(pessoa.getTelefones());
	}
	
	
	
	public PessoaDto() {
		
	}
	
	public static Page<PessoaDto> coverteLista(Page<Pessoa> page){
		return page.map(PessoaDto::new);
	}

    public Pessoa converter() {
    	Pessoa pessoa=new Pessoa();
    	pessoa.setId(id);
    	pessoa.setEmail(email);
    	pessoa.setEndereco(endereco);
    	pessoa.setNome(nome);
    	pessoa.setSobrenome(sobrenome);
		return pessoa;
	}
    
    public Pessoa atualiza(Long id, PessoaRepository repository) {
    	Pessoa pessoa=repository.getById(id);
    	pessoa.setId(id);
    	pessoa.setEmail(email);
    	pessoa.setEndereco(endereco);
    	pessoa.setNome(nome);
    	pessoa.setSobrenome(sobrenome);
		return pessoa;
	}

	public Long getId() {
		return id;
	}

	public String getNome() {
		return nome;
	}

	public String getSobrenome() {
		return sobrenome;
	}

	public String getEmail() {
		return email;
	}

	public String getEndereco() {
		return endereco;
	}

	public List<TelefoneDto> getTelefones() {
		return telefones;
	}
	
	
	
	
}
