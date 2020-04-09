package br.com.alura.testes;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Curso {
	
	private String nome;
	private String instrutor;
	
	/**
	 * ArrayList ou LinkedList?
	 * Cada um tem as suas vantagens e desvantagens, ambas mant�m a ordem inserida dos objetos
	 * ArrayList: Melhor performance para buscar objetos de forma r�pida pelo index, mas lenta ao inserir dados no in�cio da cole��o
	 * LinkedList: Melhor performance para inserir ou remover objetos de forma r�pida no in�cio da cole��o, boa para listas que s�o muito alteradas 
	 * por�m lenta para buscar objetos
	 */
	private List<Aula> aulas = new ArrayList<>();
	
	public Curso(String nome, String instrutor) {
		super();
		this.nome = nome;
		this.instrutor = instrutor;
	}
	
	/**
	 * Criamos este m�todo para fazer com que apenas a classe cursos administre seus dados, desta forma a classe curso que 
	 * permite ou n�o adicionar uma aula n�o uma fun��o de a��o sobre o tipo ArrayList, sendo complementado pelo m�todo Collections.unmodifiableList
	 */
	public void adiciona(Aula aula) {
		this.aulas.add(aula);
	}
	
	public String getNome() {
		return nome;
	}
	public String getInstrutor() {
		return instrutor;
	}
	/**
	 * Para evitar que possam agir direto sobre a lista, podemos fazer com que o m�todo getAulas devolva uma c�pia da cole��o de aulas.
	 * Melhor ainda: podemos devolver essa c�pia de tal forma que ela n�o possa ser alterada, ou seja, que ela seja n�o modific�vel, 
	 * usando o m�todo Collections.unmodifiableList
	 */
	public List<Aula> getAulas() {
		return Collections.unmodifiableList(aulas);
	}

	@Override
	public String toString() {
		return "Curso [" + (nome != null ? "nome=" + nome + ", " : "")
				+ (instrutor != null ? "instrutor=" + instrutor + ", " : "") + (aulas != null ? "aulas=" + aulas : "")
				+ "]";
	}
	
}
