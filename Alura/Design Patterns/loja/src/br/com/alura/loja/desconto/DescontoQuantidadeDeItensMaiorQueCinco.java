package br.com.alura.loja.desconto;

import java.math.BigDecimal;

import br.com.alura.loja.orcamento.Orcamento;

public class DescontoQuantidadeDeItensMaiorQueCinco extends Desconto {

	public DescontoQuantidadeDeItensMaiorQueCinco(Desconto proximo) {
		super(proximo);
	}

	@Override
	protected BigDecimal efetuarCalculo(Orcamento orcamento) {
		BigDecimal desconto = orcamento.getValor().multiply(new BigDecimal("0.1"));
		return desconto;
	}

	@Override
	public boolean deveAplicar(Orcamento orcamento) {
		return orcamento.getQuantidadeDeItens() > 5;
	}
	
	
}
