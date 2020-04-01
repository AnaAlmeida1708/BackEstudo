package br.com.alura.testes;

import java.util.ArrayList;
import java.util.Collections;

public class TestandoListas {

	public static void main(String[] args) {
		String curso1 = "Spring Boot";
		String curso2 = "Trabalhando com Collection";
		String curso3 = "JavaScript";
		
		ArrayList<String> cursos = new ArrayList<>();
		cursos.add(curso1);
		cursos.add(curso2);
		cursos.add(curso3);
		
		System.out.println(cursos);
		System.out.println(cursos.size());
		
		for (String curso : cursos) {
			System.out.println("Curso : " + curso);
		}
		
		System.out.println("Primeiro curso :" + cursos.get(0));
		
		cursos.forEach(curso -> {System.out.println("Esse é o curso: " + curso);});
		
		Collections.sort(cursos);
		for (int i = 0; i < cursos.size(); i++) {
			System.out.println("Curso: " + cursos.get(i));
		}
		
		cursos.remove(0);
		System.out.println(cursos);
		
		
		

	}

}
