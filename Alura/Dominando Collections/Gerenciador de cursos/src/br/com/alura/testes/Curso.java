package br.com.alura.testes;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Curso {
	
	private String nome;
	private String instrutor;
	
	/**
	 * ArrayList ou LinkedList?
	 * Cada um tem as suas vantagens e desvantagens, ambas mantém a ordem inserida dos objetos
	 * ArrayList: Melhor performance para buscar objetos de forma rápida pelo index, mas lenta ao inserir dados no início da coleção
	 * LinkedList: Melhor performance para inserir ou remover objetos de forma rápida no início da coleção, boa para listas que são muito alteradas 
	 * porém lenta para buscar objetos
	 */
	private List<Aula> aulas = new ArrayList<>();
	
	public Curso(String nome, String instrutor) {
		super();
		this.nome = nome;
		this.instrutor = instrutor;
	}
	
	/**
	 * Criamos este método para fazer com que apenas a classe cursos administre seus dados, desta forma a classe curso que 
	 * permite ou não adicionar uma aula não uma função de ação sobre o tipo ArrayList, sendo complementado pelo método Collections.unmodifiableList
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
	 * Para evitar que possam agir direto sobre a lista, podemos fazer com que o método getAulas devolva uma cópia da coleção de aulas.
	 * Melhor ainda: podemos devolver essa cópia de tal forma que ela não possa ser alterada, ou seja, que ela seja não modificável, 
	 * usando o método Collections.unmodifiableList
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
