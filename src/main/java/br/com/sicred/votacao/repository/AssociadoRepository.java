package br.com.sicred.votacao.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import br.com.sicred.votacao.model.Associado;

public interface AssociadoRepository extends JpaRepository<Associado, String>{
	
	@Query(value = "SELECT * FROM Associado.tbl_associados a WHERE a.cpf = ?1", nativeQuery = true)
	Associado buscaPorId(String cpf);

}
