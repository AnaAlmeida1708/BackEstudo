package br.com.caelum.leilao.servico;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.*;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.List;

import org.junit.Test;
import org.mockito.InOrder;

import br.com.caelum.leilao.builder.CriadorDeLeilao;
import br.com.caelum.leilao.dominio.Leilao;
import br.com.caelum.leilao.infra.dao.LeilaoDao;
import br.com.caelum.leilao.infra.dao.RepositorioDeLeiloes;
import br.com.caelum.leilao.infra.email.EnviadorDeEmail;

public class EncerradorDeLeilaoTest {
	
	@Test
	public void deveEncerraLeiloesQueComecaramUmaSemanaAntes() {
		Calendar antiga = Calendar.getInstance();
		antiga.set(1999, 1, 20);
		
		Leilao leilao1 = new CriadorDeLeilao().para("TV 4K").naData(antiga).constroi();
		Leilao leilao2 = new CriadorDeLeilao().para("Geladeira").naData(antiga).constroi();
		List<Leilao> leiloesAntigos = Arrays.asList(leilao1, leilao2);
		
		//criamos um objeto falso DAO com mock
//		LeilaoDao daoFalso = mock(LeilaoDao.class);
		RepositorioDeLeiloes daoFalso = mock(RepositorioDeLeiloes.class);
		
		when(daoFalso.correntes()).thenReturn(leiloesAntigos);
		
		EnviadorDeEmail carteiroFalso = mock(EnviadorDeEmail.class);
		
		EncerradorDeLeilao encerrador = new EncerradorDeLeilao(daoFalso, carteiroFalso);
		encerrador.encerra();
		
		assertEquals(2, encerrador.getTotalEncerrados());
		
		assertTrue(leilao1.isEncerrado());
		assertTrue(leilao2.isEncerrado());
		
	}
	
	@Test
    public void naoDeveEncerrarLeiloesQueComecaramMenosDeUmaSemanaAtras() {

        Calendar ontem = Calendar.getInstance();
        ontem.add(Calendar.DAY_OF_MONTH, -1);

        Leilao leilao1 = new CriadorDeLeilao().para("TV de plasma")
            .naData(ontem).constroi();
        Leilao leilao2 = new CriadorDeLeilao().para("Geladeira")
            .naData(ontem).constroi();

		RepositorioDeLeiloes daoFalso = mock(RepositorioDeLeiloes.class);
        when(daoFalso.correntes()).thenReturn(Arrays.asList(leilao1, leilao2));

		EnviadorDeEmail carteiroFalso = mock(EnviadorDeEmail.class);
		
		EncerradorDeLeilao encerrador = new EncerradorDeLeilao(daoFalso, carteiroFalso);
        encerrador.encerra();

        assertEquals(0, encerrador.getTotalEncerrados());
        
        assertFalse(leilao1.isEncerrado());
        assertFalse(leilao2.isEncerrado());
        
        //never: garante que o m�todo em quest�o n�o foi invocado nenhuma vez
        verify(daoFalso, never()).atualiza(leilao1);
        verify(daoFalso, never()).atualiza(leilao2);
        
    }
	
	@Test
	public void naoDeveEncerrarLeiloesCasoNaoHajaNenhum() {
		
		RepositorioDeLeiloes daoFalso = mock(RepositorioDeLeiloes.class);
		when(daoFalso.correntes()).thenReturn(new ArrayList<Leilao>());
		
		EnviadorDeEmail carteiroFalso = mock(EnviadorDeEmail.class);
		
		EncerradorDeLeilao encerrador = new EncerradorDeLeilao(daoFalso, carteiroFalso);
        encerrador.encerra();
        
        assertEquals(0, encerrador.getTotalEncerrados());
		
	}
	
	@Test
	public void deveAtualizarLeiloesEncerrados() {
		Calendar antiga = Calendar.getInstance();
		antiga.set(2001, 1, 20);
		
		Leilao leilao1 = new CriadorDeLeilao().para("Gameboy").naData(antiga).constroi();
		
		RepositorioDeLeiloes daoFalso = mock(RepositorioDeLeiloes.class);
		when(daoFalso.correntes()).thenReturn(Arrays.asList(leilao1));
		
		EnviadorDeEmail carteiroFalso = mock(EnviadorDeEmail.class);
		
		EncerradorDeLeilao encerrador = new EncerradorDeLeilao(daoFalso, carteiroFalso);
		encerrador.encerra();
		
		//Verify: faz com que o mockito verifique se o m�todo foi invocado, caso contr�rio ele falha o teste
		//times: informa a quantidade de vezes que o m�todo em quest�o deve ser invocado, neste caso, uma �nica vez
		verify(daoFalso, times(1)).atualiza(leilao1);
	}
	
	@Test
	public void deveEnviarEmailAposPersistirLeilaoEncerrado() {
		Calendar antiga = Calendar.getInstance();
		antiga.set(2001, 1, 20);
		
		Leilao leilao1 = new CriadorDeLeilao().para("Gameboy").naData(antiga).constroi();
		
		RepositorioDeLeiloes daoFalso = mock(RepositorioDeLeiloes.class);
		when(daoFalso.correntes()).thenReturn(Arrays.asList(leilao1));
		
		EnviadorDeEmail carteiroFalso = mock(EnviadorDeEmail.class);
		
		EncerradorDeLeilao encerrador = new EncerradorDeLeilao(daoFalso, carteiroFalso);
		encerrador.encerra();
		
		// passamos os mocks que serao verificados
        InOrder inOrder = inOrder(daoFalso, carteiroFalso);
        // a primeira invoca��o
        inOrder.verify(daoFalso, times(1)).atualiza(leilao1); 
        // a segunda invoca��o
        inOrder.verify(carteiroFalso, times(1)).envia(leilao1);
        
	}
	
	@Test
	public void deveContinuarAexecucaoMesmoQuandoDaoFalhar() {
		Calendar antiga = Calendar.getInstance();
		antiga.set(2001, 1, 20);
		
		Leilao leilao1 = new CriadorDeLeilao().para("Gameboy").naData(antiga).constroi();
		Leilao leilao2 = new CriadorDeLeilao().para("Play 3").naData(antiga).constroi();
		
		RepositorioDeLeiloes daoFalso = mock(RepositorioDeLeiloes.class);
		when(daoFalso.correntes()).thenReturn(Arrays.asList(leilao1, leilao2));
		//doThrow: indica que ele deve lan�ar uma exce��o, o quando indica o momento do lan�amento dela
		doThrow(new RuntimeException()).when(daoFalso).atualiza(leilao1);
		
		EnviadorDeEmail carteiroFalso = mock(EnviadorDeEmail.class);
		
		EncerradorDeLeilao encerrador = new EncerradorDeLeilao(daoFalso, carteiroFalso);
		encerrador.encerra();
		
		verify(daoFalso).atualiza(leilao2);
		verify(carteiroFalso).envia(leilao2);
		
		verify(carteiroFalso, never()).envia(leilao1);
		
	}
	
	@Test
	public void deveDesistirSeDaoFalharPraSempre() {
		Calendar antiga = Calendar.getInstance();
		antiga.set(2001, 1, 20);
		
		Leilao leilao1 = new CriadorDeLeilao().para("Gameboy").naData(antiga).constroi();
		Leilao leilao2 = new CriadorDeLeilao().para("Play 3").naData(antiga).constroi();
		
		RepositorioDeLeiloes daoFalso = mock(RepositorioDeLeiloes.class);
		when(daoFalso.correntes()).thenReturn(Arrays.asList(leilao1, leilao2));
		//doThrow: indica que ele deve lan�ar uma exce��o, o quando indica o momento do lan�amento dela
		doThrow(new RuntimeException()).when(daoFalso).atualiza(leilao1);
		doThrow(new RuntimeException()).when(daoFalso).atualiza(leilao2);
		
		EnviadorDeEmail carteiroFalso = mock(EnviadorDeEmail.class);
		
		EncerradorDeLeilao encerrador = new EncerradorDeLeilao(daoFalso, carteiroFalso);
		encerrador.encerra();
		
		verify(carteiroFalso, never()).envia(leilao1);
		verify(carteiroFalso, never()).envia(leilao2);
		
	}
	
	
}
