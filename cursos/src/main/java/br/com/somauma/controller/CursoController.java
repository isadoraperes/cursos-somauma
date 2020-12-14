package br.com.somauma.controller;

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

import br.com.somauma.model.Curso;
import br.com.somauma.repository.CursoRepository;


@RestController
@CrossOrigin(origins = "*", allowedHeaders = "*" )
@RequestMapping("/cursos")
public class CursoController {
	
	@Autowired
	public CursoRepository repository;
	
	@GetMapping("/nome/{nome}")
	public ResponseEntity<List<Curso>> getByNome(@PathVariable String nome){
		return ResponseEntity.ok(repository.findAllByNomeContainingIgnoreCase(nome));
	}
	
	@GetMapping
	public ResponseEntity<List<Curso>> getAll(){
		return ResponseEntity.ok(repository.findAll());
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Curso> getById(@PathVariable long id){
		return repository.findById(id).map(resp -> ResponseEntity.ok(resp)).orElse(ResponseEntity.notFound().build());
	}
	
	@PostMapping
	public ResponseEntity<Curso> post(@RequestBody Curso curso){
		return ResponseEntity.status(HttpStatus.CREATED).body(repository.save(curso));
	}
	
	@PutMapping
	public ResponseEntity<Curso> put(@RequestBody Curso curso){
		return ResponseEntity.status(HttpStatus.OK).body(repository.save(curso));
	}
	
	@DeleteMapping("/{id}")
	public void delete(@PathVariable long id) {
		repository.deleteById(id);
	}

}
