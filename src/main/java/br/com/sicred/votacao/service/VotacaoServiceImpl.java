package br.com.sicred.votacao.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.sicred.votacao.model.Votacao;
import br.com.sicred.votacao.repository.VotacaoRepository;

@Service
public class VotacaoServiceImpl implements VotacaoService{

	@Autowired
	VotacaoRepository votacaoRepository;

	@Override
	public List<?> computaVotos(Long idSessao) {
		return votacaoRepository.computaVotos(idSessao);
	}

	@Override
	public Votacao save(Votacao votacao) {
		return votacaoRepository.save(votacao);
	}

	@Override
	public Boolean associadoJaVotou(String cpf, Long id_sessao) {
		return votacaoRepository.associadoJaVotouNaSessao(cpf, id_sessao) == null ? false : true;
	}


	}
