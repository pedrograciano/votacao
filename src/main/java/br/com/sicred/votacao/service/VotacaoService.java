package br.com.sicred.votacao.service;

import java.util.List;

import br.com.sicred.votacao.model.Votacao;

public interface VotacaoService {

	List<?> computaVotos(Long idSessao);
	

	Votacao save(Votacao votacao);


	Boolean associadoJaVotou(String cpf, Long id_sessao);

}
