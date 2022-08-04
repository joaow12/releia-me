package com.projetointegrador.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.projetointegrador.model.Avaliacao;
import com.projetointegrador.repository.AvaliacaoRepository;

@RestController
@RequestMapping("/avaliacao")
@CrossOrigin(origins = "*",allowedHeaders = "*")
public class AvaliacaoController {
	
	@Autowired
	private AvaliacaoRepository repository;
	
	
	@GetMapping
	public ResponseEntity <List<Avaliacao>> getAll(){
		return ResponseEntity.ok(repository.findAll());
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Avaliacao> getAvaliacaoById(@PathVariable long id) {
		return repository.findById(id)
			.map(resposta -> ResponseEntity.ok(resposta))
			.orElse(ResponseEntity.notFound().build());
	}
	
	@PostMapping
	public ResponseEntity<Avaliacao> post (@RequestBody Avaliacao avaliacao){
		return ResponseEntity.status(HttpStatus.CREATED).body(repository.save(avaliacao));
	}
	
	@PutMapping
	public ResponseEntity<Avaliacao> put (@RequestBody Avaliacao avaliacao){
		return ResponseEntity.status(HttpStatus.OK).body(repository.save(avaliacao));
	}
	
	@DeleteMapping("/{id}")
	public void delete(@PathVariable long id) {
		repository.deleteById(id);
	}
	
	
	
}
