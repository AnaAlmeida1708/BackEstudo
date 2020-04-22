package br.com.alura.testes;

import java.util.Iterator;
import java.util.Set;
import java.util.Vector;

public class TestaCursoComAluno {

	public static void main(String[] args) {

		Curso javaColecoes = new Curso("Dominando as cole��es do Java", "Paulo Silveira");

		javaColecoes.adiciona(new Aula("Trabalhando com ArrayList", 21));
		javaColecoes.adiciona(new Aula("Criando uma aula", 20));
		javaColecoes.adiciona(new Aula("Modelando com cole��es", 24));

		Aluno a1 = new Aluno("Ana Almeida", 123);
		Aluno a2 = new Aluno("Fabio Ara�jo", 456);
		Aluno a3 = new Aluno("Higor do Carmo", 789);

		javaColecoes.matricula(a1);
		javaColecoes.matricula(a2);
		javaColecoes.matricula(a3);
		
		
		System.out.println("Todos os alunos matr�culados:");
		//Este forEach � do Java 8
		System.out.println("Este forEach � do Java 8:");
		javaColecoes.getAlunos().forEach(aluno -> {System.out.println(aluno);});
		
		//Este for � do Java 5
		System.out.println("Este For � do Java 5:");
		for(Aluno aluno : javaColecoes.getAlunos()) {
			System.out.println(aluno);
		}
		
		//Esta era a forma usada ANTES do Java 5
		System.out.println("Esta era a forma usada ANTES do Java 5:");
		Set<Aluno> alunos = javaColecoes.getAlunos();
		Iterator<Aluno> iterador = alunos.iterator();
		
		while(iterador.hasNext()) {
			System.out.println(iterador.next());
		}
		
		/**
		 * Um outro objeto antigo que pode ser citado � o Vector, que era utilizado antes da interface 
		 * Collection existir (Collection existe desde o Java 1.2):
		 * Essa classe � muito antiga e se parece com o ArrayList, inclusive ela implementa List atualmente. 
		 * A diferen�a � que ela pode ser utilizada por v�rias threads simultaneamente, chamado de thread safe,
		 * mesmo assim n�o � recomendada a sua utiliza��o.
		 */
		Vector<Aluno> vetor = new Vector<>();
		
		
//		System.out.println("O " + a1 + " est� matriculado?");
//		System.out.println(javaColecoes.estaMatriculado(a1));
//		
//		Aluno ana = new Aluno("Ana Almeida", 123);
//		System.out.println("O " + ana + " est� matriculado?");
//		System.out.println(javaColecoes.estaMatriculado(ana));
		
	}

}
