package br.com.alura.gerenciador.models;

public class Empresa {
	
	private Integer id;
	private String nome;
	
	public Empresa(String nome) {
		this.nome = nome;
	}
	
	public String getNome() {
		return nome;
	}

	@Override
	public String toString() {
		return "Empresa : "  + " " + (nome) ;
	}
	
	
}
