package br.com.alura.loja.imposto;

import java.math.BigDecimal;

import br.com.alura.loja.orcamento.ItemOrcamento;
import br.com.alura.loja.orcamento.Orcamento;

public class TestesImpostos {

	public static void main(String[] args) {
		Orcamento orcamento = new Orcamento();
		orcamento.adicionarItem(new ItemOrcamento(new BigDecimal("1000")));
		CalculadoraDeImposto calculadora = new CalculadoraDeImposto();
		System.out.println(calculadora.calculaImposto(orcamento, new ICMS(new ISS(null))));
		System.out.println(orcamento.getValor());

	}

}
