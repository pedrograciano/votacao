package br.com.sicred.votacao.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.sicred.votacao.model.SessaoDeVotacao;

public interface SessaoRepository extends JpaRepository<SessaoDeVotacao, Long>{

}
