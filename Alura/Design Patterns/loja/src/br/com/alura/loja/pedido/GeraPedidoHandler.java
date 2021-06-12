package br.com.alura.loja.pedido;

import java.util.List;

import br.com.alura.loja.orcamento.Orcamento;

public class GeraPedidoHandler {
	
	private List<Acao> acoes;
	
	public GeraPedidoHandler(List<Acao> acoes) {
		this.acoes = acoes;
	}



	public void executa(GeraPedido dados) {
		Orcamento orcamento = new Orcamento(dados.getValorOrcamento(), dados.getQuantidadeDeItens());
		Pedido pedido = new Pedido(dados.getCliente(), orcamento);
		
		acoes.forEach(a -> a.executar(pedido));
	}

}
