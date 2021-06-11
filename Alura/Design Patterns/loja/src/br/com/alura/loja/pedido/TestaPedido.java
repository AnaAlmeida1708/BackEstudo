package br.com.alura.loja.pedido;

import java.math.BigDecimal;

public class TestaPedido {

	public static void main(String[] args) {
		
		GeraPedido geraPedido = new GeraPedido("Higor", new BigDecimal("400"), 2);
		GeraPedidoHandler geraPedidoHandler = new GeraPedidoHandler(/*Dependências necessárias para execução*/);
		geraPedidoHandler.executa(geraPedido);
	}

}
