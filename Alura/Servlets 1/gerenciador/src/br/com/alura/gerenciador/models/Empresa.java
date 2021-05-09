package br.com.alura.gerenciador.models;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.ServletException;

public class Empresa {
	
	private Integer id;
	private String nome;
	private Date dataAbertura;
	
	SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

		
		
	public Empresa(String nome, String data) {
		this.nome = nome;
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

	@Override
	public String toString() {
		return "Empresa : "  + " " + (nome) ;
	}
	
}
