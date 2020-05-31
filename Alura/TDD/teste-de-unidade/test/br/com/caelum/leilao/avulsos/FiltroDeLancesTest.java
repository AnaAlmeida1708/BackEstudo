package br.com.caelum.leilao.avulsos;

import static org.junit.Assert.assertEquals;
import java.util.Arrays;
import java.util.List;

import org.junit.Test;

import br.com.caelum.leilao.dominio.Lance;
import br.com.caelum.leilao.dominio.Usuario;

public class FiltroDeLancesTest {
	
	@Test
	public void deveSelecionarLancesEntre1000e3000() {
		Usuario maria = new Usuario("Maria");
		
		FiltroDeLances filtro = new FiltroDeLances();
        List<Lance> resultado = filtro.filtra(Arrays.asList(
                new Lance(maria,2000), 
                new Lance(maria,1000), 
                new Lance(maria,3000), 
                new Lance(maria, 800)));
		
        assertEquals(1, resultado.size());
        assertEquals(2000, resultado.get(0).getValor(), 0.00001);
	}
	
	@Test
    public void deveSelecionarLancesEntre500e700() {
        Usuario maria = new Usuario("Maria");

        FiltroDeLances filtro = new FiltroDeLances();
        List<Lance> resultado = filtro.filtra(Arrays.asList(
                new Lance(maria,600), 
                new Lance(maria,500), 
                new Lance(maria,200), 
                new Lance(maria, 800)));
        
        assertEquals(1, resultado.size());
        assertEquals(600, resultado.get(0).getValor(), 0.00001);
        
	}
	
	@Test
	public void deveSelecionarLancesMaioresQue5000() {
		Usuario maria = new Usuario("Maria");

        FiltroDeLances filtro = new FiltroDeLances();
        List<Lance> resultado = filtro.filtra(Arrays.asList(
                new Lance(maria,6000), 
                new Lance(maria,5000), 
                new Lance(maria,700), 
                new Lance(maria, 3000)));
        
        assertEquals(1, resultado.size());
        assertEquals(6000, resultado.get(0).getValor(), 0.00001);
	}
	
    @Test
    public void deveEliminarMenoresQue500() {
        Usuario maria = new Usuario("Maria");

        FiltroDeLances filtro = new FiltroDeLances();
        List<Lance> resultado = filtro.filtra(Arrays.asList(
                new Lance(maria,400), 
                new Lance(maria, 300)));

        assertEquals(0, resultado.size());
    }

    @Test
    public void deveEliminarEntre700E1000() {
        Usuario maria = new Usuario("Maria");

        FiltroDeLances filtro = new FiltroDeLances();
        List<Lance> resultado = filtro.filtra(Arrays.asList(
                new Lance(maria, 800),
                new Lance(maria, 1000),
                new Lance(maria, 700),
                new Lance(maria, 900)));

        assertEquals(0, resultado.size());
    }

    @Test
    public void deveEliminarEntre3000E5000() {
        Usuario maria = new Usuario("Maria");

        FiltroDeLances filtro = new FiltroDeLances();
        List<Lance> resultado = filtro.filtra(Arrays.asList(
                new Lance(maria,4000), 
                new Lance(maria, 3500)));

        assertEquals(0, resultado.size());
    }
}
