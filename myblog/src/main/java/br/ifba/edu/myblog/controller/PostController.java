package br.ifba.edu.myblog.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.ifba.edu.myblog.dto.PostDto;
import br.ifba.edu.myblog.repository.PostRepository;

@RestController
public class PostController {

	@Autowired
	private PostRepository repository;
	
	@RequestMapping("/posts")
	public List<PostDto> listar(String titulo){
		
		return PostDto.converte(repository.findAll());
		
	}
}
