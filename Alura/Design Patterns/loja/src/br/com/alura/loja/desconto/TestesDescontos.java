package br.com.alura.loja.desconto;

import java.math.BigDecimal;

import br.com.alura.loja.orcamento.ItemOrcamento;
import br.com.alura.loja.orcamento.Orcamento;

public class TestesDescontos {

	public static void main(String[] args) {
		Orcamento orcamento1 = new Orcamento();
		orcamento1.adicionarItem(new ItemOrcamento(new BigDecimal("100")));
		orcamento1.adicionarItem(new ItemOrcamento(new BigDecimal("100")));
		orcamento1.adicionarItem(new ItemOrcamento(new BigDecimal("100")));
		orcamento1.adicionarItem(new ItemOrcamento(new BigDecimal("100")));
		orcamento1.adicionarItem(new ItemOrcamento(new BigDecimal("100")));
		orcamento1.adicionarItem(new ItemOrcamento(new BigDecimal("100")));
		
		Orcamento orcamento2 = new Orcamento();
		orcamento2.adicionarItem(new ItemOrcamento(new BigDecimal("1000")));
		
		CalculadoraDeDescontos calculadora = new CalculadoraDeDescontos();
		System.out.println(calculadora.calcular(orcamento1));
		System.out.println(calculadora.calcular(orcamento2));
	}

}
