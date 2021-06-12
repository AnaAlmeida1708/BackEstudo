package br.com.alura.loja.pedido;

public class EnviarEmailPedido implements Acao{
	
	public void executar(Pedido pedido) {
		System.out.println("Enviando e-mail dados pedido");
	}

}
