package br.com.alura.gerenciador.models;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Banco {
	
	private static List<Empresa> empresas = new ArrayList<Empresa>();
	
	static {
		Empresa empresa1 = new Empresa("Alura", "03/05/2003");
		Empresa empresa2 = new Empresa("Caellum", "27/07/2008");
		Empresa empresa3 = new Empresa("Marketdata", "07/06/2002");
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
