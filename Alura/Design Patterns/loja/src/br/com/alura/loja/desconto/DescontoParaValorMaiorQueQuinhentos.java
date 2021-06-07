package br.com.alura.loja.desconto;

import java.math.BigDecimal;

import br.com.alura.loja.orcamento.Orcamento;

public class DescontoParaValorMaiorQueQuinhentos extends Desconto{

	public DescontoParaValorMaiorQueQuinhentos(Desconto proximo) {
		super(proximo);
	}

	@Override
	public BigDecimal calcular(Orcamento orcamento) {
		BigDecimal desconto = BigDecimal.ZERO;
		if(orcamento.getValor().compareTo(new BigDecimal("500")) > 0) {
			desconto = orcamento.getValor().multiply(new BigDecimal("0.05"));
			return desconto;
		}
		return proximo.calcular(orcamento);
	}
	
	
}
