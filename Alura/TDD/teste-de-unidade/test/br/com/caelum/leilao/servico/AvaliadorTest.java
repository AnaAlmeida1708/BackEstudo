package br.com.caelum.leilao.servico;

import static org.junit.Assert.assertEquals;

import java.util.List;

import org.junit.Assert;
import org.junit.Test;

import br.com.caelum.leilao.dominio.Lance;
import br.com.caelum.leilao.dominio.Leilao;
import br.com.caelum.leilao.dominio.Usuario;

public class AvaliadorTest {
	
	@Test
	public void deveEntenderLancesEmOrdemCrescente() {//o método precisa ser public, não pode ser static e não retorna nada
		// cenario: 3 lances em ordem crescente
        Usuario joao = new Usuario("João");
        Usuario jose = new Usuario("José");
        Usuario maria = new Usuario("Maria");

        Leilao leilao = new Leilao("Playstation 3 Novo");

        leilao.propoe(new Lance(joao, 250.0));
        leilao.propoe(new Lance(jose, 300.0));
        leilao.propoe(new Lance(maria, 400.0));

        // parte 2: acao
        Avaliador leiloeiro = new Avaliador();
        leiloeiro.avalia(leilao);
        
        //parte 3: validação
        // exibindo a saida - a classe Assert tem vários métodos que nos ajudam a conferir o resultado calculado
        double maiorEsperado = 400;
        double menorEsperado = 250;

        /**
         * AssertEquals
         * primeiro o valor esperado, depois o método que vai ser testado e trazer o valor para comparação e depois um delta, 
         * devido o double e float ter problemas para arredondar, esta é a margem que ele pode deixar "passar"
         */
        assertEquals(maiorEsperado, leiloeiro.getMaiorLance(), 0.00001);
        assertEquals(menorEsperado, leiloeiro.getMenorLance(), 0.00001);
	}
	
	@Test
    public void deveEntenderLeilaoComApenasUmLance() {
        Usuario ana = new Usuario("Ana"); 
        Leilao leilao = new Leilao("Playstation 3 Novo");

        leilao.propoe(new Lance(ana, 1000.0));

        Avaliador leiloeiro = new Avaliador();
        leiloeiro.avalia(leilao);

        Assert.assertEquals(1000.0, leiloeiro.getMaiorLance(), 0.0001);
        Assert.assertEquals(1000.0, leiloeiro.getMenorLance(), 0.0001);
    }
	
	@Test
	public void deveEntenderLancesAleatorios() {
        Usuario higor = new Usuario("Higor");
        Usuario cris = new Usuario("Cris");

        Leilao leilao = new Leilao("Playstation 3 Novo");
        
        leilao.propoe(new Lance(higor, 200.0));
        leilao.propoe(new Lance(cris, 450.0));
        leilao.propoe(new Lance(higor, 120.0));
        leilao.propoe(new Lance(cris, 700.0));
        leilao.propoe(new Lance(higor, 630.0));
        leilao.propoe(new Lance(cris, 230.0));

        Avaliador leiloeiro = new Avaliador();
        leiloeiro.avalia(leilao);
        
        assertEquals(120, leiloeiro.getMenorLance(), 0.00001);
        assertEquals(700, leiloeiro.getMaiorLance(), 0.00001);
	}
	
	@Test
	public void deveEntenderLancesDecrescentes() {
		Usuario higor = new Usuario("Higor");
        Usuario cris = new Usuario("Cris");

        Leilao leilao = new Leilao("Playstation 3 Novo");
        
        leilao.propoe(new Lance(higor,400.0));
        leilao.propoe(new Lance(cris,300.0));
        leilao.propoe(new Lance(higor,200.0));
        leilao.propoe(new Lance(cris,100.0));

        Avaliador leiloeiro = new Avaliador();
        leiloeiro.avalia(leilao);
        
        assertEquals(100, leiloeiro.getMenorLance(), 0.00001);
        assertEquals(400, leiloeiro.getMaiorLance(), 0.00001);
	}
	
	@Test
	public void deveEncontrarOsTresMaioresLances() {
		Usuario higor = new Usuario("Higor");
        Usuario cris = new Usuario("Cris");

        Leilao leilao = new Leilao("Playstation 3 Novo");
        
        leilao.propoe(new Lance(higor, 200.0));
        leilao.propoe(new Lance(cris, 450.0));
        leilao.propoe(new Lance(higor, 120.0));
        leilao.propoe(new Lance(cris, 700.0));
        leilao.propoe(new Lance(higor, 630.0));
        leilao.propoe(new Lance(cris, 230.0));

        Avaliador leiloeiro = new Avaliador();
        leiloeiro.avalia(leilao);
        
        List<Lance> maiores = leiloeiro.getTresMaiores();
        
        assertEquals(3, maiores.size());
        assertEquals(700, maiores.get(0).getValor(), 0.00001);
        assertEquals(630, maiores.get(1).getValor(), 0.00001);
        assertEquals(450, maiores.get(2).getValor(), 0.00001);
	}
	
	@Test
	public void deveDevolverTodosOsLancesCasoNaoHajaNoMinimoTres() {
		Usuario higor = new Usuario("Higor");
        Usuario cris = new Usuario("Cris");

        Leilao leilao = new Leilao("Playstation 3 Novo");
        
        leilao.propoe(new Lance(higor, 200.0));
        leilao.propoe(new Lance(cris, 450.0));
        
        Avaliador leiloeiro = new Avaliador();
        leiloeiro.avalia(leilao);
        
        List<Lance> maiores = leiloeiro.getTresMaiores();
        assertEquals(2, maiores.size());
        assertEquals(450, maiores.get(0).getValor(), 0.00001);
        assertEquals(200, maiores.get(1).getValor(), 0.00001);
	}
	
	@Test
	public void deveDevolverListaVaziaCasoNaoHajaLances() {
		Leilao leilao = new Leilao("Playstation 3 Novo");
        
        Avaliador leiloeiro = new Avaliador();
        leiloeiro.avalia(leilao);
        
        List<Lance> maiores = leiloeiro.getTresMaiores();
        assertEquals(0, maiores.size());
	}
}
