package br.com.sicred.votacao.service;

import java.util.List;

import br.com.sicred.votacao.model.Associado;

public interface AssociadoService {

	List<Associado> findAll();

	Associado buscaPorId(String cpf);
	
	Associado save(Associado associado);

}
