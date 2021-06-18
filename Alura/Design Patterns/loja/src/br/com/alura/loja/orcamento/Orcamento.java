package br.com.alura.loja.orcamento;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import br.com.alura.loja.orcamento.situacao.EmAnalise;
import br.com.alura.loja.orcamento.situacao.Finalizado;
import br.com.alura.loja.orcamento.situacao.Situacao;

public class Orcamento implements Orcavel {
	
	private BigDecimal valor;
	private Situacao situacao;
	private List<Orcavel> itens;
	
	
	public Orcamento() {
		this.valor = BigDecimal.ZERO;
		this.itens = new ArrayList<>();
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
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			throw new RuntimeException();
		}
		return valor;
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
	
	public void adicionarItem(Orcavel item) {
		this.valor = this.valor.add(item.getValor());
		this.itens.add(item);
	}
	
	public Integer getQuantidadeDeItens() {
		return this.itens.size();
	}

}
