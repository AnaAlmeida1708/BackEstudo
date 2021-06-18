package br.com.alura.loja.orcamento;

import java.math.BigDecimal;

import br.com.alura.loja.http.JavaHttpClient;

public class TesteAdaptador {

	public static void main(String[] args) {
		Orcamento orcamento = new Orcamento();
		orcamento.adicionarItem(new ItemOrcamento(new BigDecimal("200")));
		orcamento.aprovar();
		orcamento.finalizar();
		
		RegistroDeOrcamento registroDeOrcamento = new RegistroDeOrcamento(new JavaHttpClient());
		registroDeOrcamento.registrarOrcamento(orcamento);

	}

}
