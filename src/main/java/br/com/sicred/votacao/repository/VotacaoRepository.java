package br.com.sicred.votacao.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import br.com.sicred.votacao.model.Votacao;

public interface VotacaoRepository extends JpaRepository<Votacao, Long>{

	@Query(
			  value = "SELECT * FROM Votacao.tbl_votacao v WHERE v.cpf = ?1 and v.id_sessao = ?2", 
			  nativeQuery = true)
	Votacao associadoJaVotouNaSessao(String cpf, Long idSessao);
	
	@Query(value= "SELECT v.voto, count(v.voto) FROM Votacao.tbl_votacao v WHERE v.id_sessao = ?1 GROUP BY v.voto;", nativeQuery = true)
	List<?> computaVotos(Long id_sessao);
}
