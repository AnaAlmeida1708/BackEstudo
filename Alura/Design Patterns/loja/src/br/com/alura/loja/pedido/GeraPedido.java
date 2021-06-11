package br.com.alura.loja.pedido;

import java.math.BigDecimal;

public class GeraPedido {
	
	private String cliente;
	private BigDecimal valorOrcamento;
	private Integer quantidadeDeItens;
	
	public GeraPedido(String cliente, BigDecimal valorOrcamento, Integer quantidadeDeItens) {
		this.cliente = cliente;
		this.valorOrcamento = valorOrcamento;
		this.quantidadeDeItens = quantidadeDeItens;
	}

	public String getCliente() {
		return cliente;
	}

	public BigDecimal getValorOrcamento() {
		return valorOrcamento;
	}

	public Integer getQuantidadeDeItens() {
		return quantidadeDeItens;
	}
	
	
}
