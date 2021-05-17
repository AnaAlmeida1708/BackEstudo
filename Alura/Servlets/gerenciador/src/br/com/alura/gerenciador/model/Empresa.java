package br.com.alura.gerenciador.model;

import java.util.Date;

public class Empresa {
	private static Integer chaveSequencial = 1;

	private Integer id;
	private String nome;
	private Date dataAbertura;


	public Empresa(String nome, Date data) {
		this.nome = nome;
		this.id = chaveSequencial++;
		this.dataAbertura = data;
	}

	public String getNome() {
		return nome;
	}

	public Date getDataAbertura() {
		return dataAbertura;
	}

	public Integer getId() {
		return id;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public void setDataAbertura(Date dataAbertura) {
		this.dataAbertura = dataAbertura;
	}

	@Override
	public String toString() {
		return "Empresa : "  + " " + (nome) ;
	}

}
