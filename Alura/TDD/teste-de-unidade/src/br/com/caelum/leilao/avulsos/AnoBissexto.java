package br.com.caelum.leilao.avulsos;

public class AnoBissexto {
	
	
	/**
	 * 
	 * Um ano bissexto � aquele que tem 366 dias
	 * 
	 * De 4 em 4 anos � ano bissexto
	 * 
	 * De 100 em 100 anos n�o � ano bissexto
	 * 
	 * De 400 em 400 anos � ano bissexto
	 */
	
	public boolean isAnoBissexto(int ano) {
	    if (((ano % 4) == 0) && ((ano % 100) != 0)) return true; 
	        else if ((ano % 400) == 0) return true; 
	        else return false;                
	}

	
}
