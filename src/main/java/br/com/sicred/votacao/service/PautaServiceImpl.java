package br.com.sicred.votacao.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.sicred.votacao.model.Pauta;
import br.com.sicred.votacao.repository.PautaRepository;

@Service
public class PautaServiceImpl implements PautaService{

	@Autowired
	PautaRepository pautaRepository;

	@Override
	public List<Pauta> findAll() {
		return pautaRepository.findAll();
	}

	@Override
	public Pauta save(Pauta pauta) {
		return pautaRepository.save(pauta);
	}

	@Override
	public Pauta findById(Long id) {
		if (pautaRepository.findById(id).isPresent()) {
			return pautaRepository.findById(id).get();
		}
		return null;
	}

	@Override
	public void delete(Long id) {
		Pauta pauta = findById(id);
		pautaRepository.delete(pauta);
	}
	
}
