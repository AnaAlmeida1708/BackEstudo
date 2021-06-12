package br.com.alura.loja.pedido;

public class SalvandoPedidoNoBancoDeDados implements Acao {
	
	public void executar(Pedido pedido) {
		System.out.println("Salvando pedido no banco de dados");
	}

}
