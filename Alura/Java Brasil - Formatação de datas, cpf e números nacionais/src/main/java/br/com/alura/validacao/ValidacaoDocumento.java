package br.com.alura.validacao;

import br.com.caelum.stella.validation.CNPJValidator;
import br.com.caelum.stella.validation.CPFValidator;
import br.com.caelum.stella.validation.InvalidStateException;
import br.com.caelum.stella.validation.TituloEleitoralValidator;
import br.com.caelum.stella.validation.Validator;

public class ValidacaoDocumento {
	
	public static void main(String[] args) {

		String cpf = "86288366757";
		String cnpj = "18022756000105";
		String titulo = "437185780183";

		validarDocumentos(new CPFValidator(), cpf);
		validarDocumentos(new CNPJValidator(), cnpj);
		validarDocumentos(new TituloEleitoralValidator(), titulo);
	}
	
	private static void  validarDocumentos(Validator<String> validador, String documento) {
		try {
			validador.assertValid(documento);
			System.out.println("Válido");
		} catch (InvalidStateException e) {
			System.out.println("Inválido : " + e.getMessage());
		}
	}

}
