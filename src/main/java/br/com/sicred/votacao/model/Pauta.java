package br.com.sicred.votacao.model;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Transient;

@Entity
@Table(name="tbl_pauta")
public class Pauta {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_pauta" )
	private Long id;
	private String assunto;
	
	@OneToMany(mappedBy = "pauta", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	private Set<SessaoDeVotacao> sessoesDeVotacao = new HashSet<>();
	
	@Transient
	private List<?> resultadoVotacao;
	
	public Pauta() {};
	
	public Pauta(Long id, String assunto) {
		super();
		this.id = id;
		this.assunto = assunto;
	}
	
	
	
	//Getters and Setters
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getAssunto() {
		return assunto;
	}
	public void setAssunto(String assunto) {
		this.assunto = assunto;
	}

	public List<?> getResultadoVotacao() {
		return resultadoVotacao;
	}

	public void setResultadoVotacao(List<?> resultadoVotacao) {
		this.resultadoVotacao = resultadoVotacao;
	}
	
	
}
