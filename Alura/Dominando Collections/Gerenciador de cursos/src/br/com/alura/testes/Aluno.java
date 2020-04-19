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
		//tratando para evitar erros de NullPointerException
		if(nome == null) {
			throw new NullPointerException("Nome não pode ser nulo");
		}
		this.nome = nome;
		this.numeroMatricula = numeroMatricula;
	}
	
	/**
	 * IMPORTANTE: Em conjuntos, ao reescrever o método equals, OBRIGATORIAMENTE é necessário 
	 * reescrever também o método Hash, caso contrário dará erro na hora de fazer comparações
	 */
	@Override
	public boolean equals(Object obj) {
		Aluno outroAluno = (Aluno) obj;
		return this.nome.equals(outroAluno.nome);
	}
	
	@Override
	public int hashCode() {
		return this.nome.hashCode();
	}
	
	@Override
	public String toString() {
		return "Aluno [" + (nome != null ? "nome=" + nome + ", " : "")
				+ (numeroMatricula != null ? "numeroMatricula=" + numeroMatricula : "") + "]";
	}
	
	
}
