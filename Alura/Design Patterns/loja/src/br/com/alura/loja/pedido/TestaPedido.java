package br.com.alura.loja.pedido;

import java.math.BigDecimal;

public class TestaPedido {

	public static void main(String[] args) {
		
		GeraPedido geraPedido = new GeraPedido("Higor", new BigDecimal("400"), 2);
		GeraPedidoHandler geraPedidoHandler = new GeraPedidoHandler(/*Depend�ncias necess�rias para execu��o*/);
		geraPedidoHandler.executa(geraPedido);
	}

}
