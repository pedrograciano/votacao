package br.com.sicred.votacao.service;

import java.util.List;

import br.com.sicred.votacao.model.Pauta;

public interface PautaService {

	List<Pauta> findAll();

	Pauta save(Pauta pauta);

	Pauta findById(Long id);

	void delete(Long id);
}
