package br.com.alura.testes;

import java.util.List;

public class TestaCurso {

	public static void main(String[] args) {
		Curso javaColecoes = new Curso("Dominando as coleções do Java", "Paulo Silveira");
		List<Aula> aulas = javaColecoes.getAulas();
		//Até este ponto só temos uma lista de aulas vazia
		//System.out.println(aulas);
		
		//Aqui criamos um objeto Aula direto dentro do get da lista, agindo direto na Lista de aulas
		//Depois da alteração feita com o método Collections.unmodifiableList este agora lança uma exception (java.lang.UnsupportedOperationException)
//		javaColecoes.getAulas().add(new Aula("Trabalhando com ArrayList", 21));
//		System.out.println(aulas);
		
		javaColecoes.adiciona(new Aula("Trabalhando com ArrayList", 21));
		javaColecoes.adiciona(new Aula("Criando uma aula", 20));
		javaColecoes.adiciona(new Aula("Modelando com coleções", 24));
		System.out.println(javaColecoes.getAulas());
	}

}
