package br.com.sicred.votacao.service;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.sicred.votacao.model.SessaoDeVotacao;
import br.com.sicred.votacao.repository.SessaoRepository;

@Service
public class SessaoVotacaoServiceImpl implements SessaoVotacaoService{

	@Autowired
	SessaoRepository sessaoRepository;

	@Override
	public List<SessaoDeVotacao> findAll() {
		return sessaoRepository.findAll();
	}

	@Override
	public SessaoDeVotacao save(SessaoDeVotacao sessao) {
		return sessaoRepository.save(sessao);
	}

	@Override
	public SessaoDeVotacao findById(Long id) {
		if (sessaoRepository.findById(id).isPresent()) {
			return sessaoRepository.findById(id).get();
		}
		return null;
	}

	@Override
	public void delete(Long id) {
		SessaoDeVotacao sessao = findById(id);
		sessaoRepository.delete(sessao);
	}

	@Override
	public Boolean isSessaoAberta(Long id) {
		 LocalDateTime now = LocalDateTime.now();
		SessaoDeVotacao sessaoDeVotacao = findById(id);
		return sessaoDeVotacao.getDtAbertura().plusMinutes(sessaoDeVotacao.getMinutos()).isAfter(now) ? true : false;
		
	}
}
