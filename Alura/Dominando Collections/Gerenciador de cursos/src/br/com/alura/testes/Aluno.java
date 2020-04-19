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
			throw new NullPointerException("Nome n�o pode ser nulo");
		}
		this.nome = nome;
		this.numeroMatricula = numeroMatricula;
	}
	
	/**
	 * IMPORTANTE: Em conjuntos, ao reescrever o m�todo equals, OBRIGATORIAMENTE � necess�rio 
	 * reescrever tamb�m o m�todo Hash, caso contr�rio dar� erro na hora de fazer compara��es
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
