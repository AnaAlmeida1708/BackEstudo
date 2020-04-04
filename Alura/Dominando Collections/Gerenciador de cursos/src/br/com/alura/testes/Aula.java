package br.com.alura.testes;

public class Aula implements Comparable<Aula> {
	
	private String titulo;
	private Integer duracao;
	
	public Aula(String titulo, Integer duracao) {
		super();
		this.titulo = titulo;
		this.duracao = duracao;
	}
	public String getTitulo() {
		return titulo;
	}
	public Integer getDuracao() {
		return duracao;
	}
	
	@Override
	public int compareTo(Aula outraAula) {
		return this.titulo.compareTo(outraAula.titulo);
	}
	
	@Override
	public String toString() {
		return "Aula: " + this.titulo + ", " + "duração " + this.duracao + " minutos ";
	}

	

}
