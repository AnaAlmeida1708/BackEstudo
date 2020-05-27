package br.com.caelum.leilao.avulsos;

import static org.junit.Assert.assertEquals;
import org.junit.Test;

public class ContaMalucaTest {
	
	@Test
	public void testeNumeroMenorQueDez() {
		MatematicaMaluca mat = new MatematicaMaluca();
		assertEquals(2, mat.contaMaluca(1));
	}
	
	@Test
	public void testeNumeroMaiorQueDezEmenorQueTrinta() {
		MatematicaMaluca mat = new MatematicaMaluca();
		assertEquals(60, mat.contaMaluca(20));
	}
	
	@Test
	public void testeNumeroMaiorQueTrinta() {
		MatematicaMaluca mat = new MatematicaMaluca();
		assertEquals(160, mat.contaMaluca(40));
	}
	
	@Test
	public void testeNumeroIgualATrintaOuIgualAdez() {
		MatematicaMaluca mat = new MatematicaMaluca();
		assertEquals(20, mat.contaMaluca(10));
		assertEquals(90, mat.contaMaluca(30));
	}
	
}
