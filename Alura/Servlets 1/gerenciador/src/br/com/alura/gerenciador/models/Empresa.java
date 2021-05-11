package br.com.alura.gerenciador.models;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Empresa {
	private static Integer chaveSequencial = 1;
	
	private Integer id;
	private String nome;
	private Date dataAbertura;
	
	SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

		
		
	public Empresa(String nome, String data) {
		this.nome = nome;
		this.id = chaveSequencial++;
		try {
			this.dataAbertura = sdf.parse(data);
		} catch (ParseException e) {
			e.printStackTrace();
		};
	}
	
	public String getNome() {
		return nome;
	}
	
	public Date getDataAbertura() {
		return dataAbertura;
	}
	
	public Integer getId() {
		return id;
	}
	
	public void setNome(String nome) {
		this.nome = nome;
	}
	
	public void setDataAbertura(Date dataAbertura) {
		this.dataAbertura = dataAbertura;
	}

	@Override
	public String toString() {
		return "Empresa : "  + " " + (nome) ;
	}
	
}
