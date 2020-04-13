package br.com.alura.testes;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;

public class TestaPerformance {

	public static void main(String[] args) {
		
		Collection<Integer> numeros = new ArrayList<Integer>();

        long inicio = System.currentTimeMillis();

        for (int i = 1; i <= 50000; i++) {
            numeros.add(i);
        }

        for (Integer numero : numeros) {
            numeros.contains(numero);
        }

        long fim = System.currentTimeMillis();

        long tempoDeExecucao = fim - inicio;
        
        System.out.println("Tempo gasto com ArrayList: " + tempoDeExecucao);
        
        ////////////////////////////////////////////////////////////
        
		Collection<Integer> numerosComHashSet = new HashSet<>();

        long inicioHash = System.currentTimeMillis();

        for (int i = 1; i <= 50000; i++) {
        	numerosComHashSet.add(i);
        }

        for (Integer numero : numerosComHashSet) {
        	numerosComHashSet.contains(numero);
        }

        long fimHash = System.currentTimeMillis();

        long tempoDeExecucaoComSet = fimHash - inicioHash;

        System.out.println("Tempo gasto com HashSet: " + tempoDeExecucaoComSet);

	}

}
