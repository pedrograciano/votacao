package br.com.sicred.votacao.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.sicred.votacao.model.Pauta;

public interface PautaRepository extends JpaRepository<Pauta, Long>{

}
