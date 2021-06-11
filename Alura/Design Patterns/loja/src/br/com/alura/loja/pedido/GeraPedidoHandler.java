package br.com.alura.loja.pedido;

import br.com.alura.loja.orcamento.Orcamento;

public class GeraPedidoHandler {
	
	//construtor com inje��o de depend�ncias Service, Daos, etc
	
	public void executa(GeraPedido dados) {
		Orcamento orcamento = new Orcamento(dados.getValorOrcamento(), dados.getQuantidadeDeItens());
		Pedido pedido = new Pedido(dados.getCliente(), orcamento);
		
		System.out.println("Salvar pedido no banco de dados" + pedido.toString());
		System.out.println("Enviar e-mail com dados pedido");
	}

}
