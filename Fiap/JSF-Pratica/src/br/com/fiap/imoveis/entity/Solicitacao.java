package br.com.fiap.imoveis.entity;

import java.io.Serializable;
import java.util.Calendar;
import java.util.List;

public class Solicitacao implements Serializable{

	private static final long serialVersionUID = 1L;
	private int codigo;
	private String cidade;
	private float valor;
	private String descricao;
	private String senha;
	private boolean novo;
	private List<String> itens;
	private List<String> comodos;
	private String tipo;
	private String finalidade;
	private String operacao;
	private String email;
	private Calendar dataSolicitacao;
	
	public Solicitacao() {
	//Inicializa a data de solicitação
	dataSolicitacao= Calendar.getInstance();
	}

	public int getCodigo() {
		return codigo;
	}

	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}

	public String getCidade() {
		return cidade;
	}

	public void setCidade(String cidade) {
		this.cidade = cidade;
	}

	public float getValor() {
		return valor;
	}

	public void setValor(float valor) {
		this.valor = valor;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

	public boolean isNovo() {
		return novo;
	}

	public void setNovo(boolean novo) {
		this.novo = novo;
	}

	public List<String> getItens() {
		return itens;
	}

	public void setItens(List<String> itens) {
		this.itens = itens;
	}

	public List<String> getComodos() {
		return comodos;
	}

	public void setComodos(List<String> comodos) {
		this.comodos = comodos;
	}

	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	public String getFinalidade() {
		return finalidade;
	}

	public void setFinalidade(String finalidade) {
		this.finalidade = finalidade;
	}

	public String getOperacao() {
		return operacao;
	}

	public void setOperacao(String operacao) {
		this.operacao = operacao;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Calendar getDataSolicitacao() {
		return dataSolicitacao;
	}

	public void setDataSolicitacao(Calendar dataSolicitacao) {
		this.dataSolicitacao = dataSolicitacao;
	}
	
}
