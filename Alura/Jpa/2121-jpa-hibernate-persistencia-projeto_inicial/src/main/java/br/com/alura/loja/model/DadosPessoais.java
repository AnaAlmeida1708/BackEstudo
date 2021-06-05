package br.com.alura.loja.model;

import javax.persistence.Embeddable;

@Embeddable
public class DadosPessoais {
	
	private String nome;
	private String cpf;
	
	public DadosPessoais(String nome, String cpf) {
		this.nome = nome;
		this.cpf = cpf;
	}
	
	public DadosPessoais() {
	}

	public String getNome() {
		return nome;
	}

	public String getCpf() {
		return cpf;
	}

	@Override
	public String toString() {
		return "DadosPessoais [" + (nome != null ? "nome=" + nome + ", " : "") + (cpf != null ? "cpf=" + cpf : "")
				+ "]";
	}
	

}
