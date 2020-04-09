package br.com.alura.testes;

import java.util.List;

public class TestaCurso {

	public static void main(String[] args) {
		Curso javaColecoes = new Curso("Dominando as cole��es do Java", "Paulo Silveira");
		List<Aula> aulas = javaColecoes.getAulas();
		//At� este ponto s� temos uma lista de aulas vazia
		//System.out.println(aulas);
		
		//Aqui criamos um objeto Aula direto dentro do get da lista, agindo direto na Lista de aulas
		//Depois da altera��o feita com o m�todo Collections.unmodifiableList este agora lan�a uma exception (java.lang.UnsupportedOperationException)
//		javaColecoes.getAulas().add(new Aula("Trabalhando com ArrayList", 21));
//		System.out.println(aulas);
		
		javaColecoes.adiciona(new Aula("Trabalhando com ArrayList", 21));
		javaColecoes.adiciona(new Aula("Criando uma aula", 20));
		javaColecoes.adiciona(new Aula("Modelando com cole��es", 24));
		System.out.println(javaColecoes.getAulas());
	}

}
