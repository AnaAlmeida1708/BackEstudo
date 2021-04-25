package br.com.alura.validacao;

import br.com.caelum.stella.format.CNPJFormatter;
import br.com.caelum.stella.format.CPFFormatter;
import br.com.caelum.stella.format.Formatter;
import br.com.caelum.stella.format.TituloEleitoralFormatter;

public class FormatadorDocumento {
	
	public static void main(String[] args) {
		String cpf = "862.883.667-57";
		String cnpj = "18022756000105";
		String titulo = "437185780183";
		
		System.out.println(" ------------CPF------------ ");
		retirarFormatacao(new CPFFormatter(), cpf);
		estaFormatado(new CPFFormatter(), cpf);
		formatar(new CPFFormatter(), "86288366757");

		System.out.println(" ------------CNPJ------------ ");
		retirarFormatacao(new CNPJFormatter(), "18.022.756/0001-05");
		estaFormatado(new CNPJFormatter(), cnpj);
		formatar(new CNPJFormatter(), cnpj);
		
		System.out.println(" ------------TITULO------------ ");
		retirarFormatacao(new TituloEleitoralFormatter(), "4371857801/83");
		estaFormatado(new TituloEleitoralFormatter(), titulo);
		formatar(new TituloEleitoralFormatter(), titulo);
		
	}

	private static void formatar(Formatter formatador, String documento) {
		System.out.println("Documento formatado : " + formatador.format(documento));
	}
	
	private static void retirarFormatacao(Formatter formatador, String documento) {
		System.out.println("Documento sem formatação : " + formatador.unformat(documento));
	}
	
	private static void estaFormatado(Formatter formatador, String documento) {
		System.out.println("Documento está formatado ? " + formatador.isFormatted(documento));
	}
	
		
}
