package com.projetointegrador.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.projetointegrador.model.Avaliacao;

@Repository //Indicando que a interface é um repositório
public interface AvaliacaoRepository extends JpaRepository<Avaliacao, Long> {
	
	
	
}