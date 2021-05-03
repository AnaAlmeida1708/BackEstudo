package br.com.caelum.livraria.dominio;

public class Cliente {

	private final String id;
	private final String cep;
	private final String ddd;
	private final String telefone;
	
	public Cliente(String id, String ddd, String telefone, String cep) {
		this.id = id;
		this.cep = cep;
		this.ddd = ddd;
		this.telefone = telefone;
	}

	@Override
	public boolean equals(Object obj) {
		boolean iguais = false;
		if(obj instanceof Cliente) {
			Cliente outra = (Cliente) obj;
			iguais = id.equals(outra.id);
		}
		return iguais;
	}
	
	@Override
	public int hashCode() {
		return id.hashCode();
	}

	public String getTelefone() {
		return getTelefoneFormatado();
	}

	public String getCep() {
		return cep;
	}
	
	public String getTelefoneFormatado() {
		return String.format("(%s) %s", ddd, telefone); 
	}
}
