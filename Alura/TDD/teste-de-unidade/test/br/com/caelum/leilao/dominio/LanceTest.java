package br.com.caelum.leilao.dominio;

import org.junit.Before;
import org.junit.Test;

public class LanceTest {
	
	private Usuario higor;
	
	@Before
	public void criaUsuario() {
        this.higor = new Usuario("Higor");
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void naoDevePermitirLanceIgualAzero() {
		
		new Lance(higor, 0);
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void naoDevePermitirLanceDeValorMenorQueZero() {
		
		new Lance(higor, -1);
		
	}

}
