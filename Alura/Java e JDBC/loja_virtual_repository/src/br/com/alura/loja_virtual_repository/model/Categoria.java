package br.com.alura.loja_virtual_repository.model;

public class Categoria {
	
	private Integer id;
	private String nome;
	
	
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
	
	@Override
	public String toString() {
		return "Categoria [" + (id != null ? "id=" + id + ", " : "") + (nome != null ? "nome=" + nome : "") + "]";
	}
	
	

}
