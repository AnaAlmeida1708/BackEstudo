package br.com.alura.validacao;

import java.math.BigDecimal;

import br.com.caelum.stella.inwords.FormatoDeReal;
import br.com.caelum.stella.inwords.InteiroSemFormato;
import br.com.caelum.stella.inwords.NumericToWordsConverter;

public class NumeroPorExtenso {
	
	public static void main(String[] args) {
		
		NumericToWordsConverter conversor = new NumericToWordsConverter(new InteiroSemFormato());
		NumericToWordsConverter conversorMoeda = new NumericToWordsConverter(new FormatoDeReal());
		
		BigDecimal valor = new BigDecimal("900.56");
		System.out.println(conversor.toWords(valor.doubleValue()));
		System.out.println(conversorMoeda.toWords(valor.doubleValue()));
		
		System.out.println(valorPorExtenso(new BigDecimal("1346.62")));
		
	}
	
	public static String valorPorExtenso(BigDecimal valor) {
		NumericToWordsConverter conversor = new NumericToWordsConverter(new FormatoDeReal());
		return conversor.toWords(valor.doubleValue());
		
	}

}
