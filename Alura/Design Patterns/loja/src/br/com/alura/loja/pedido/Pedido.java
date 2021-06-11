package br.com.alura.loja.pedido;

import java.time.LocalDateTime;

import br.com.alura.loja.orcamento.Orcamento;

public class Pedido {
	
	private String cliente;
	private LocalDateTime data = LocalDateTime.now();
	private Orcamento orcamento;
	
	public Pedido(String cliente, Orcamento orcamento) {
		this.cliente = cliente;
		this.orcamento = orcamento;
	}
	
	public String getCliente() {
		return cliente;
	}
	public LocalDateTime getData() {
		return data;
	}
	public Orcamento getOrcamento() {
		return orcamento;
	}

	@Override
	public String toString() {
		return "Pedido [" + (cliente != null ? "cliente=" + cliente + ", " : "")
				+ (data != null ? "data=" + data + ", " : "") + (orcamento != null ? "orcamento=" + orcamento : "")
				+ "]";
	}

}
