package br.com.alura.loja.pedido;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class TestaPedido {

	public static void main(String[] args) {
		
		GeraPedido geraPedido = new GeraPedido("Higor", new BigDecimal("400"), 2);
		
		List<Acao> acoes = new ArrayList<>();
		acoes.add(new EnviarEmailPedido());
		acoes.add(new SalvandoPedidoNoBancoDeDados());
		
		GeraPedidoHandler geraPedidoHandler = 
				new GeraPedidoHandler(Arrays.asList(
						new EnviarEmailPedido(), 
						new SalvandoPedidoNoBancoDeDados()));
		geraPedidoHandler.executa(geraPedido);
	}

}
