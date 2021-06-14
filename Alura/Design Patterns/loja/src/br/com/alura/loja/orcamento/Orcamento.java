package br.com.alura.loja.orcamento;

import java.math.BigDecimal;

import br.com.alura.loja.orcamento.situacao.EmAnalise;
import br.com.alura.loja.orcamento.situacao.Finalizado;
import br.com.alura.loja.orcamento.situacao.Situacao;

public class Orcamento {
	
	private BigDecimal valor;
	private Integer quantidadeDeItens;
	private Situacao situacao;
	
	
	public Orcamento(BigDecimal valor, Integer quantidadeDeItens) {
		this.valor = valor;
		this.quantidadeDeItens = quantidadeDeItens;
		this.situacao = new EmAnalise();
	}
	
	public void calcularDescontoExtra() {
		BigDecimal desconto = this.situacao.calcularDescontoExtra(this);
		this.valor.subtract(desconto);
	}
	
	public void aprovar() {
		this.situacao.aprovar(this);
	}
	
	public void reprovar() {
		this.situacao.reprovar(this);
	}
	
	public void finalizar() {
		this.situacao.finalizar(this);
	}

	public BigDecimal getValor() {
		return valor;
	}
	
	public Integer getQuantidadeDeItens() {
		return quantidadeDeItens;
	}

	public Situacao getSituacao() {
		return situacao;
	}

	public void setSituacao(Situacao situacao) {
		this.situacao = situacao;
	}
	
	public boolean isFinalizado() {
		return situacao instanceof Finalizado;
	}

	@Override
	public String toString() {
		return "Orcamento [" + (valor != null ? "valor=" + valor + ", " : "")
				+ (quantidadeDeItens != null ? "quantidadeDeItens=" + quantidadeDeItens + ", " : "")
				+ (situacao != null ? "situacao=" + situacao : "") + "]";
	}

}
