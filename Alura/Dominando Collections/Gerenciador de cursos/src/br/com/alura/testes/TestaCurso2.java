package br.com.alura.testes;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class TestaCurso2 {

	public static void main(String[] args) {
		Curso javaColecoes = new Curso("Dominando as coleções do Java", "Paulo Silveira");
		
		javaColecoes.adiciona(new Aula("Trabalhando com ArrayList", 21));
		javaColecoes.adiciona(new Aula("Criando uma aula", 20));
		javaColecoes.adiciona(new Aula("Modelando com coleções", 24));
		
		List<Aula> aulasImutaveis = javaColecoes.getAulas();
		System.out.println(aulasImutaveis);
		
		List<Aula> aulas = new ArrayList<>(aulasImutaveis);
		Collections.sort(aulas);
		System.out.println(aulas);
		
		System.out.println(javaColecoes.getDuracaoTotal());
		System.out.println(javaColecoes.getTempoTotal());
		
	}
	
//	Collections.shuffle()
//	O método shuffle() serve para embaralhar a ordem de uma lista. 
//	Por exemplo em um caso de um sistema de sorteio, em que precisamos de uma ordem aleatória na nossa lista, 
//	utilizamos o método shuffle para embaralhá-la.

}
