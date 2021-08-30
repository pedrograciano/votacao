package br.com.sicred.votacao.model;

import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ForeignKey;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonFormat;


@Entity
@Table(name = "tbl_sessao_votacao")
public class SessaoDeVotacao {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "sessao_id")
	private Long id;

	@ManyToOne
	@JoinColumn(name = "id_pauta", nullable = false, foreignKey = @ForeignKey)
	private Pauta pauta;

	@Column(columnDefinition = "integer default 1")
	private Integer minutos = 1;

	@Column(name = "dt_abertura", columnDefinition = "timestamp default current_timestamp")
	private LocalDateTime  dtAbertura = LocalDateTime.now() ;

	// Getters and Setters
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Pauta getPauta() {
		return pauta;
	}

	public void setPauta(Pauta pauta) {
		this.pauta = pauta;
	}

	public Integer getMinutos() {
		return minutos;
	}

	public void setMinutos(Integer minutos) {
		this.minutos = minutos;
	}

	public LocalDateTime getDtAbertura() {
		return dtAbertura;
	}

	public void setDtAbertura(LocalDateTime dtAbertura) {
		this.dtAbertura = dtAbertura;
	}


}
