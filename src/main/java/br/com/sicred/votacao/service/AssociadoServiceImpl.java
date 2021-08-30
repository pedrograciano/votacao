package br.com.sicred.votacao.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.sicred.votacao.model.Associado;
import br.com.sicred.votacao.repository.AssociadoRepository;

@Service
public class AssociadoServiceImpl implements AssociadoService{

	@Autowired
	AssociadoRepository associadoRepository;

	@Override
	public List<Associado> findAll() {
		return associadoRepository.findAll();
	}

	@Override
	public Associado save(Associado associado) {
		return associadoRepository.save(associado);
	}

	@Override
	public Associado buscaPorId(String cpf) {
		return associadoRepository.buscaPorId(cpf);
	}



	
}
