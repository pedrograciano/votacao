package br.com.sicred.votacao.model;

import javax.persistence.Entity;
import javax.persistence.ForeignKey;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
//@IdClass(VotacaoId.class)
@Table(name="tbl_votacao")
public class Votacao {

	public Votacao() {}
	
	public Votacao(Associado associado, SessaoDeVotacao sessao, Character voto) {
		super();
		this.associado = associado;
		this.sessao = sessao;
		this.voto = voto;
	}

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@ManyToOne
	@JoinColumn(name= "cpf", nullable = false, foreignKey = @ForeignKey)
	private Associado associado;
	
	@ManyToOne
	@JoinColumn(name= "id_sessao", nullable = false, foreignKey = @ForeignKey)
	private SessaoDeVotacao sessao;
	
	private Character voto;

	
	public Associado getAssociado() {
		return associado;
	}

	public void setAssociado(Associado associado) {
		this.associado = associado;
	}

	public SessaoDeVotacao getSessao() {
		return sessao;
	}

	public void setSessao(SessaoDeVotacao sessao) {
		this.sessao = sessao;
	}

	public Character getVoto() {
		return voto;
	}

	public void setVoto(Character voto) {
		this.voto = voto;
	}		
}
