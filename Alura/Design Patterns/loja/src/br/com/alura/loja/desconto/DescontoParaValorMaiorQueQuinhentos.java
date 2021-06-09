package br.com.alura.loja.desconto;

import java.math.BigDecimal;

import br.com.alura.loja.orcamento.Orcamento;

public class DescontoParaValorMaiorQueQuinhentos extends Desconto{

	public DescontoParaValorMaiorQueQuinhentos(Desconto proximo) {
		super(proximo);
	}

	@Override
	protected BigDecimal efetuarCalculo(Orcamento orcamento) {
		BigDecimal desconto = orcamento.getValor().multiply(new BigDecimal("0.05"));
		return desconto;
	}

	@Override
	public boolean deveAplicar(Orcamento orcamento) {
		return orcamento.getValor().compareTo(new BigDecimal("500")) > 0;
	}
	
	
}
