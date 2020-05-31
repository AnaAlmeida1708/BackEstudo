package br.com.caelum.leilao.dominio;

import static org.junit.Assert.assertEquals;
import org.junit.Test;

public class LeilaoTest {
	
	@Test
	public void naoDeveAceitarDoisLancesSeguidoDoMesmoUsuario() {
		Leilao leilao = new Leilao("Iphone 8");
		
		Usuario joao = new Usuario("João");
		
		leilao.propoe(new Lance(joao, 300));
		leilao.propoe(new Lance(joao, 400));
		
		assertEquals(1, leilao.getLances().size());
		assertEquals(300, leilao.getLances().get(0).getValor(), 0.0001);
	}
	
	@Test
	public void naoDeveAceitarMaisQue5LancesDoMesmoUsuario() {
		Leilao leilao = new Leilao("Iphone 8");
		
		Usuario joao = new Usuario("João");
		Usuario maria = new Usuario("Maria");
		
		leilao.propoe(new Lance(joao, 300));
		leilao.propoe(new Lance(maria, 400));
		
		leilao.propoe(new Lance(joao, 500));
		leilao.propoe(new Lance(maria, 600));
		
		leilao.propoe(new Lance(joao, 700));
		leilao.propoe(new Lance(maria, 800));
		
		leilao.propoe(new Lance(joao, 900));
		leilao.propoe(new Lance(maria, 1000));
		
		leilao.propoe(new Lance(joao, 1100));
		leilao.propoe(new Lance(maria, 1200));
		
		//deve ser ignorado
		leilao.propoe(new Lance(joao, 1300));
		
		assertEquals(10, leilao.getLances().size());
		int ultimo = leilao.getLances().size()-1;
		assertEquals(1200, leilao.getLances().get(ultimo).getValor(), 0.0001);
		
	}
	
	@Test
	public void dobraLanceUsuario() {
Leilao leilao = new Leilao("Iphone 8");
		
		Usuario joao = new Usuario("João");
		Usuario maria = new Usuario("Maria");
		
		leilao.propoe(new Lance(joao, 2000));
		leilao.propoe(new Lance(maria, 3000));
		

		leilao.dobraLance(joao);
		
		assertEquals(4000, leilao.getLances().get(2).getValor(), 0.00001);
		
	}
	
	 @Test
	    public void naoDeveDobrarCasoNaoHajaLanceAnterior() {
	        Leilao leilao = new Leilao("Macbook Pro 15");
	        Usuario steveJobs = new Usuario("Steve Jobs");

	        leilao.dobraLance(steveJobs);

	        assertEquals(0, leilao.getLances().size());
	    }
}
