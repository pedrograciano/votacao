package br.com.sicred.votacao.model;

import java.io.Serializable;

public class VotacaoId implements Serializable{

	private static final long serialVersionUID = 1L;
	
	private String cpf;
	private Long id_sessao;

	public VotacaoId() {}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public Long getId_sessao() {
		return id_sessao;
	}

	public void setId_sessao(Long id_sessao) {
		this.id_sessao = id_sessao;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((cpf == null) ? 0 : cpf.hashCode());
		result = prime * result + ((id_sessao == null) ? 0 : id_sessao.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		VotacaoId other = (VotacaoId) obj;
		if (cpf == null) {
			if (other.cpf != null)
				return false;
		} else if (!cpf.equals(other.cpf))
			return false;
		if (id_sessao == null) {
			if (other.id_sessao != null)
				return false;
		} else if (!id_sessao.equals(other.id_sessao))
			return false;
		return true;
	}
	
}
