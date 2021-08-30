package br.com.sicred.votacao.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import br.com.sicred.votacao.model.Votacao;
import br.com.sicred.votacao.service.SessaoVotacaoService;
import br.com.sicred.votacao.service.VotacaoService;

@RestController
@RequestMapping("/api/v1")
public class VotacaoController {

	@Autowired
	VotacaoService votacaoService;

	@Autowired
	SessaoVotacaoService sessaoService;

	@PostMapping("/votacao")
	public ResponseEntity<Votacao> save(@RequestBody Votacao votacao) {
		Boolean isSessaoAberta = sessaoService.isSessaoAberta(votacao.getSessao().getId());
		Boolean associadoJaVotou = votacaoService.associadoJaVotou(votacao.getAssociado().getCpf(), votacao.getSessao().getId());
		if (!isSessaoAberta) {
			throw new ResponseStatusException(HttpStatus.METHOD_NOT_ALLOWED, "Sessao já encerrada");
		}
		if (associadoJaVotou) {
			throw new ResponseStatusException(HttpStatus.METHOD_NOT_ALLOWED, "Associado já votou nessa Pauta");
		}

		Votacao votacaoObj = votacaoService.save(votacao);
		return new ResponseEntity<Votacao>(votacaoObj, HttpStatus.OK);
	}

}
