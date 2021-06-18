package br.com.alura.loja.pedido;

import java.util.List;

import br.com.alura.loja.orcamento.ItemOrcamento;
import br.com.alura.loja.orcamento.Orcamento;
import br.com.alura.loja.pedido.acao.Acao;

public class GeraPedidoHandler {
	
	private List<Acao> acoes;
	
	public GeraPedidoHandler(List<Acao> acoes) {
		this.acoes = acoes;
	}

	public void executa(GeraPedido dados) {
		Orcamento orcamento = new Orcamento();
		orcamento.adicionarItem(new ItemOrcamento(dados.getValorOrcamento()));
		
		Pedido pedido = new Pedido(dados.getCliente(), orcamento);
		
		acoes.forEach(a -> a.executar(pedido));
	}

}
