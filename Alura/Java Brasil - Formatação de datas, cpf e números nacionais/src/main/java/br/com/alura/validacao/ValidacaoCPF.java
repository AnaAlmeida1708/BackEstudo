package br.com.alura.validacao;

import br.com.caelum.stella.validation.CPFValidator;
import br.com.caelum.stella.validation.InvalidStateException;

public class ValidacaoCPF {
	
	public static void main(String[] args) {
		/*
		 * Cpfs para teste
		 * V�LIDO: 86288366757
		 * INV�LIDO: 98745366797
		 */
		String cpf = "86288366757";
		
		CPFValidator validador = new CPFValidator();
		try {
			validador.assertValid(cpf);
			System.out.println("V�lido");
			
		} catch (InvalidStateException e) {
			System.out.println("Inv�lido : " + e.getMessage());
		}
	}

}
