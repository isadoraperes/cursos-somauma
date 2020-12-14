package br.com.somauma.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.somauma.model.Curso;

@Repository
public interface CursoRepository extends JpaRepository<Curso, Long> {
	public List<Curso> findAllByNomeContainingIgnoreCase(String nome);
}
