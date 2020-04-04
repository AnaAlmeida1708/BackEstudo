package br.com.alura.testes;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class TestaListaDeAulas {
	
	public static void main(String[] args) {
		
        Aula a1 = new Aula("Revisitando as ArrayLists", 21);
        Aula a2 = new Aula("Listas de objetos", 20);
        Aula a3 = new Aula("Relacionamento de listas e objetos", 15);

        ArrayList<Aula> aulas = new ArrayList<>();
        aulas.add(a1);
        aulas.add(a2);
        aulas.add(a3);

        //System.out.println(aulas);
        
        System.out.println("------antes de ordenar------");
        aulas.forEach(aula -> {System.out.println("Essa é a " + aula);});
        
        Collections.sort(aulas);

        System.out.println("------depois de ordenar por título------");
        aulas.forEach(aula -> {System.out.println("Essa é a " + aula);});
        
        System.out.println("------depois de ordenar por duração da Aula------");
        aulas.sort(Comparator.comparing(Aula::getDuracao));
        aulas.forEach(aula -> {System.out.println("Essa é a " + aula);});
	}
}
