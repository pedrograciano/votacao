package br.com.sicred.votacao.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.sicred.votacao.model.Associado;
import br.com.sicred.votacao.service.AssociadoService;

@RestController
@RequestMapping("/api/v1")
public class AssociadoController {
	
	@Autowired
	AssociadoService associadoService;

	@GetMapping("/associados")
	public ResponseEntity<List<Associado>> get(){
		List<Associado> pautas =  associadoService.findAll();
		return new ResponseEntity<List<Associado>>(pautas, HttpStatus.OK); 
	}
	
	@PostMapping("/associado")
	public ResponseEntity<Associado> save(@RequestBody Associado associado){
		Associado associadoObj = associadoService.save(associado);
		return new ResponseEntity<Associado>(associadoObj, HttpStatus.OK);
	}
	
	
}
