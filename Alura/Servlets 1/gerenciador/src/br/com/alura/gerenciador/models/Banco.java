package br.com.alura.gerenciador.models;

import java.util.ArrayList;
import java.util.List;

public class Banco {
	
	private static List<Empresa> empresas = new ArrayList<Empresa>();
	
	static {
		Empresa empresa1 = new Empresa("Alura");
		Empresa empresa2 = new Empresa("Caellum");
		Empresa empresa3 = new Empresa("Marketdata");
		Banco.empresas.add(empresa1);
		Banco.empresas.add(empresa2);
		Banco.empresas.add(empresa3);
		
	}
	
	public void adiciona(Empresa empresa) {
		Banco.empresas.add(empresa);
	}
	
	public List<Empresa> getEmpresas(){
		return Banco.empresas;
	}

}
