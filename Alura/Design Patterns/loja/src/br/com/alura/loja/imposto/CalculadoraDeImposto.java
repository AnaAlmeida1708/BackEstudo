package br.com.alura.loja.imposto;

import java.math.BigDecimal;

import br.com.alura.loja.orcamento.Orcamento;

public class CalculadoraDeImposto {
	
	public BigDecimal calculaImposto(Orcamento orcamento, Imposto imposto) {
		return imposto.calcular(orcamento);
	}

}
