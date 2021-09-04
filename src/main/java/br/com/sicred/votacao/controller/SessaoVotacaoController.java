package br.com.sicred.votacao.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.sicred.votacao.model.Pauta;
import br.com.sicred.votacao.model.SessaoDeVotacao;
import br.com.sicred.votacao.service.PautaService;
import br.com.sicred.votacao.service.SessaoVotacaoService;

@RestController
@RequestMapping("/api/v1")
public class SessaoVotacaoController {
	
	@Autowired
	SessaoVotacaoService sessaoService;
	
	@Autowired
	PautaService pautaService;

	@GetMapping("/sessao-votacao")
	public ResponseEntity<List<SessaoDeVotacao>> get(){
		List<SessaoDeVotacao> sessoes =  sessaoService.findAll();
		return new ResponseEntity<List<SessaoDeVotacao>>(sessoes, HttpStatus.OK); 
	}
	
	@PostMapping("/abrir-sessao-votacao")
	public ResponseEntity<SessaoDeVotacao> save(@RequestBody SessaoDeVotacao sessao){
		SessaoDeVotacao sessaoObj = sessaoService.save(sessao);
		Pauta pauta = new Pauta(sessaoObj.getPauta().getId(),pautaService.findById(sessaoObj.getPauta().getId()).getAssunto());
		sessaoObj.setPauta(pauta);
		return new ResponseEntity<SessaoDeVotacao>(sessaoObj, HttpStatus.OK);
	}
	
	@GetMapping("/sessao-votacao/{id}")
	public ResponseEntity<SessaoDeVotacao> get(@PathVariable Long id){
		 SessaoDeVotacao sessao = sessaoService.findById(id);
		 return new ResponseEntity<SessaoDeVotacao>(sessao, HttpStatus.OK);
	}
	
	@DeleteMapping("/sessao-votacao/{id}")
	public ResponseEntity<String> delete (@PathVariable Long id){
		sessaoService.delete(id);
		 return new ResponseEntity<String>("Sessao de Votação apagada com sucesso", HttpStatus.OK);
	}
}
