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
import br.com.sicred.votacao.service.PautaService;
import br.com.sicred.votacao.service.SessaoVotacaoService;
import br.com.sicred.votacao.service.VotacaoService;

@RestController
@RequestMapping("/api/v1")
public class PautaController {
	
	@Autowired
	PautaService pautaService;

	@Autowired
	VotacaoService votacaoService;

	@Autowired
	SessaoVotacaoService sessaoService;
	
	@GetMapping("/pautas")
	public ResponseEntity<List<Pauta>> get(){
		List<Pauta> pautas =  pautaService.findAll();
		return new ResponseEntity<List<Pauta>>(pautas, HttpStatus.OK); 
	}
	
	@PostMapping("/pautas")
	public ResponseEntity<Pauta> save(@RequestBody Pauta pauta){
		Pauta pautaObj = pautaService.save(pauta);
		return new ResponseEntity<Pauta>(pautaObj, HttpStatus.OK);
	}
	
	@GetMapping("/pautas/{id}")
	public ResponseEntity<Pauta> get(@PathVariable Long id){
		 Pauta pauta = pautaService.findById(id);
		 return new ResponseEntity<Pauta>(pauta, HttpStatus.OK);
	}
	
	@DeleteMapping("/pautas/{id}")
	public ResponseEntity<String> delete (@PathVariable Long id){
		pautaService.delete(id);
		 return new ResponseEntity<String>("Pauta apagada com sucesso", HttpStatus.OK);
	}
	
  @GetMapping("/resultado/sessao/{id_sessao}/pauta/{id_pauta}")
	public ResponseEntity<Pauta> resultadoVotacao(@PathVariable Long id_sessao, @PathVariable Long id_pauta) {
		List<?> computaVotos = votacaoService.computaVotos(id_sessao);
		Pauta pauta = pautaService.findById(id_pauta);
		pauta.setResultadoVotacao(computaVotos);
		return new ResponseEntity<Pauta>(pauta, HttpStatus.OK);
	}
}
