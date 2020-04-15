package br.com.alura.testes;

public class Aluno {
	
	private String nome;
	public Integer numeroMatricula;
	
	public String getNome() {
		return nome;
	}
	
	public Integer getnumeroMatricula() {
		return numeroMatricula;
	}
	
	public Aluno(String nome, Integer numeroMatricula) {
		this.nome = nome;
		this.numeroMatricula = numeroMatricula;
	}
	
	@Override
	public String toString() {
		return "Aluno [" + (nome != null ? "nome=" + nome + ", " : "")
				+ (numeroMatricula != null ? "numeroMatricula=" + numeroMatricula : "") + "]";
	}
	
	
}
