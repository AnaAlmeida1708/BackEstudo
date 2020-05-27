package br.com.caelum.leilao.avulsos;

import br.com.caelum.leilao.dominio.Lance;
import br.com.caelum.leilao.dominio.Leilao;

public class Media {
	
    private double media = 0;

    public void avalia(Leilao leilao) {
    	double total = 0;
        for(Lance lance : leilao.getLances()) {
        	total += lance.getValor();
        }
        if(total == 0) {
        	media = 0;
        	return;
        }
        media = total / leilao.getLances().size();
    }
    
    public double getMedia() {
    	return media;
    }

}
