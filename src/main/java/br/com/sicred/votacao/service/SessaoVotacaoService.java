package br.com.sicred.votacao.service;

import java.util.List;

import br.com.sicred.votacao.model.SessaoDeVotacao;

public interface SessaoVotacaoService {

	List<SessaoDeVotacao> findAll();

	SessaoDeVotacao save(SessaoDeVotacao sessaoVotacao);

	SessaoDeVotacao findById(Long id);

	void delete(Long id);

	Boolean isSessaoAberta(Long id);
}
