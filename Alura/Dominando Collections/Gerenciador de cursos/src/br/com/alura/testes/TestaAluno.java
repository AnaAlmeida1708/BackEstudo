package br.com.alura.testes;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class TestaAluno {
	
	public static void main(String[] args) {
		
		/**
		 * Um Set não garante a ordem dos elementos, não insere objetos repetidos, não tem index, 
		 * acessa, exclui e verifica um objeto de forma mais performática.
		 * Preferível quando se trabalha com muitos elementos e a ordem não é importante
		 * Possível declarar diretamente a Collection, sem afetar em nada e fica mais genérico
		 */
		Set<String> alunos = new HashSet<>();
//		Collection<String> alunos = new HashSet<>();
		alunos.add("Ana Carolina");
		alunos.add("Fabio Araújo");
		alunos.add("Higor do Carmo");
		alunos.add("Cristiene Oliveira");
		alunos.add("Jack Raimundo");
		alunos.add("Dorileide Santos");
		
		for (String aluno : alunos) {
			System.out.println(aluno);
		}
		
		System.out.println(alunos);
		
		boolean anaEstaMatriculada = alunos.contains("Ana Carolina");
		System.out.println(anaEstaMatriculada);
		
		List<String> alunoLista = new ArrayList<>(alunos);// O ArrayList também aceita receber uma coleção, além de listas.
		Collections.sort(alunoLista);
		System.out.println(alunoLista);
	
	}

}
