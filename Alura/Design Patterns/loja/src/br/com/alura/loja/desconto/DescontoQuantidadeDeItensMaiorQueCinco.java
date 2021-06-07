package br.com.alura.loja.desconto;

import java.math.BigDecimal;

import br.com.alura.loja.orcamento.Orcamento;

public class DescontoQuantidadeDeItensMaiorQueCinco extends Desconto {

	public DescontoQuantidadeDeItensMaiorQueCinco(Desconto proximo) {
		super(proximo);
	}

	@Override
	public BigDecimal calcular(Orcamento orcamento) {
		BigDecimal desconto = BigDecimal.ZERO;
		if(orcamento.getQuantidadeDeItens() > 5) {
			desconto = orcamento.getValor().multiply(new BigDecimal("0.1"));
			return desconto;
		}
		return proximo.calcular(orcamento);
	}
	
	
}
