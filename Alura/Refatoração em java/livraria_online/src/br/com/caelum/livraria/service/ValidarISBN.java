package br.com.caelum.livraria.service;

public class ValidarISBN {
	
	private String valor;

	public ValidarISBN(String valor) {
		this.valor = valor;
	}
	
	public boolean validar() {
		if (valor == null) return false;
		
		String isbnSomenteNumeros = valor.replaceAll("-", "");
		if(isbnSomenteNumeros.length() != 13) return false;
		
		try{
			return validaNumerosISBN(isbnSomenteNumeros, numerosISBN(isbnSomenteNumeros));
		}
		catch (NumberFormatException nfe){
			return false;
		}
	}

	private boolean validaNumerosISBN(String isbnSomenteNumeros, int tot) {
		int checksum = 10 - (tot % 10);
		if (checksum == 10) checksum = 0;

		return checksum == Integer.parseInt(isbnSomenteNumeros.substring(12));
	}

	private int numerosISBN(String isbnSomenteNumeros) {
		int tot = 0;
		for (int i = 0; i < 12; i++ ){
			int digito = Integer.parseInt(isbnSomenteNumeros.substring(i, i + 1));
			tot += (i % 2 == 0) ? digito * 1 : digito * 3;
		}
		return tot;
	}

}
