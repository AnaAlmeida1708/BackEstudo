package br.com.alura.loja_virtual_repository.model;

public class Produto {
	
	private Integer id;
	private String nome;
	private String descricao;
	
	private Categoria categoria;
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getDescricao() {
		return descricao;
	}
	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	
	public Categoria getCategoria() {
		return categoria;
	}
	public void setCategoria(Categoria categoria) {
		this.categoria = categoria;
	}
	
	@Override
	public String toString() {
		return "Produto [" + (id != null ? "id=" + id + ", " : "") + (nome != null ? "nome=" + nome + ", " : "")
				+ (descricao != null ? "descricao=" + descricao + ", " : "")
				+ (categoria != null ? "categoria=" + categoria : "") + "]";
	}


}
