package br.com.alura.validacao;

import br.com.caelum.stella.validation.CPFValidator;
import br.com.caelum.stella.validation.InvalidStateException;

public class ValidacaoCPF {
	
	public static void main(String[] args) {
		/*
		 * Cpfs para teste
		 * VÁLIDO: 86288366757
		 * INVÁLIDO: 98745366797
		 */
		String cpf = "86288366757";
		
		CPFValidator validador = new CPFValidator();
		try {
			validador.assertValid(cpf);
			System.out.println("Válido");
			
		} catch (InvalidStateException e) {
			System.out.println("Inválido : " + e.getMessage());
		}
	}

}
