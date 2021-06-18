package br.com.alura.loja.orcamento;

import java.math.BigDecimal;

public class TesteComposição {

	public static void main(String[] args) {
		Orcamento antigo = new Orcamento();
		antigo.adicionarItem(new ItemOrcamento(new BigDecimal("500")));
		antigo.reprovar();
		
		Orcamento novo = new Orcamento();
		novo.adicionarItem(new ItemOrcamento(new BigDecimal("1000")));
		novo.adicionarItem(antigo);
		
		System.out.println(novo.getValor());
		
		OrcamentoProxy proxy = new OrcamentoProxy(novo);
		System.out.println(proxy.getValor());
		System.out.println(proxy.getValor());
		System.out.println(proxy.getValor());
		System.out.println(proxy.getValor());
		System.out.println(proxy.getValor());

	}

}
