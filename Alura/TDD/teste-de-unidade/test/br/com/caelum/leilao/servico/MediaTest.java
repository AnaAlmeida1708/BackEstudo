package br.com.caelum.leilao.servico;

import static org.junit.Assert.assertEquals;

import org.junit.Assert;
import org.junit.Test;

import br.com.caelum.leilao.dominio.Lance;
import br.com.caelum.leilao.dominio.Leilao;
import br.com.caelum.leilao.dominio.Usuario;

public class MediaTest {
	
	@Test
	public void deveCalcularAMedia() {
		Usuario joao = new Usuario("João");
        Usuario jose = new Usuario("José");
        Usuario maria = new Usuario("Maria");

        Leilao leilao = new Leilao("Playstation 3 Novo");

        leilao.propoe(new Lance(joao, 300.0));
        leilao.propoe(new Lance(jose, 400.0));
        leilao.propoe(new Lance(maria, 500.0));

        Avaliador leiloeiro = new Avaliador();
        leiloeiro.avalia(leilao);
        
        double media = 400;
        
        Assert.assertEquals(media, leiloeiro.getMedia(), 0.00001);
	}
	
	@Test
	public void testaMediaDeZeroLance() {
		// cenario
        Usuario ewertom = new Usuario("Ewertom");

        // acao
        Leilao leilao = new Leilao("Iphone 7");

        Avaliador avaliador = new Avaliador();
        avaliador.avalia(leilao);
        
        assertEquals(0, avaliador.getMedia(), 0.00001);
	}

}	
