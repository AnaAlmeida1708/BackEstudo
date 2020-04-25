package br.com.alura.testes;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.Set;

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
	
	/**
	 * Outras opções de collection:
	 * LinkedHashSet - Guarda a ordem de inserção dos elementos
	 * TreeSet - Guarda a ordem natural dos elementos (necessário que a coleção implemente o comparable, para que ela possa identificar a 
	 * ordem natural
	 */
	private Set<Aluno> alunos = new HashSet<>();
	
	/**
	 * Cria um mapa através da chave indicada, neste caso a matrícula, muito rápido para buscas
	 */
	private Map<Integer, Aluno> alunoMatriculado = new HashMap<>();
	
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
	
	public int getDuracaoTotal() {
	    int duracaoTotal = 0;
	    for (Aula aula : aulas) {
	        duracaoTotal += aula.getDuracao();
	    }
	    return duracaoTotal;
	}
	
	//Este é o mesmo método, mas usando Java 8
	public int getTempoTotal() {
	    return this.aulas.stream().mapToInt(Aula::getDuracao).sum();
	}
	
	//também poderíamos ter criado um atributo que toda vez que uma aula fosse adicionada, somaríamos o tempo total
//	public void adiciona(Aula aula) {
//	    this.aulas.add(aula);
//	    this.tempoTotal += aula.getTempo();
//	}



	public void matricula(Aluno aluno) {
		this.alunos.add(aluno);
		this.alunoMatriculado.put(aluno.getnumeroMatricula(), aluno);
	}
	
	public Set<Aluno> getAlunos(){
		return Collections.unmodifiableSet(alunos);
	}
	
	public boolean estaMatriculado(Aluno aluno) {
		return this.alunos.contains(aluno);
	}
	
	@Override
	public String toString() {
		return "Curso [" + (nome != null ? "nome=" + nome + ", " : "")
				+ (instrutor != null ? "instrutor=" + instrutor + ", " : "") + (aulas != null ? "aulas=" + aulas : "")
				+ "]";
	}
	
	//busca otimizada usando o Map
	public Aluno buscaPorMatricula(int matricula) {
		if(!alunoMatriculado.containsKey(matricula)) {
			throw new NoSuchElementException("Matricula " + matricula
		            + " não encontrada");
		}
		return this.alunoMatriculado.get(matricula);
	}
	
	//Forma mais lenta de fazer a busca por matrícula, se forem muitos elementos não é performático
	public Aluno buscaMatriculado(int numero) {
	    for (Aluno aluno : alunos) {
	        if (aluno.getnumeroMatricula() == numero) {
	            return aluno;
	        }
	    }
	    throw new NoSuchElementException("Matricula " + numero
	            + " não encontrada");
	}


	
}
