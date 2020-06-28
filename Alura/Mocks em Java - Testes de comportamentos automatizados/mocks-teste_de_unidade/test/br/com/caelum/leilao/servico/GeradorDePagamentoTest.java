package br.com.caelum.leilao.servico;

import static org.mockito.Mockito.mock;
import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.*;

import java.util.Arrays;
import java.util.Calendar;

import org.junit.Test;
import org.mockito.ArgumentCaptor;

import br.com.caelum.leilao.builder.CriadorDeLeilao;
import br.com.caelum.leilao.dominio.Leilao;
import br.com.caelum.leilao.dominio.Pagamento;
import br.com.caelum.leilao.dominio.Usuario;
import br.com.caelum.leilao.infra.dao.RepositorioDeLeiloes;
import br.com.caelum.leilao.infra.dao.RepositorioDePagamentos;
import br.com.caelum.leilao.infra.relogio.Relogio;

public class GeradorDePagamentoTest {
	
	@Test
	public void deveGerarPagamentoParaUmLeilaoEncerrado() {
		//primeiro criamos todos os mocks que vamos precisar
		RepositorioDeLeiloes leiloes = mock(RepositorioDeLeiloes.class);
		RepositorioDePagamentos pagamentos = mock(RepositorioDePagamentos.class);
		
		//criamos um Leilao
		Leilao leilao = new CriadorDeLeilao().para("Geladeira")
				.lance(new Usuario("Higor"), 2000.00)
				.lance(new Usuario("Fabio"), 2500.00)
				.constroi();
		
		//ensinar o mock a devolver o leilao quando o método encerrados for invocado
		when(leiloes.encerrados()).thenReturn(Arrays.asList(leilao));
		
		//classe que queremos testar
		GeradorDePagamento gerador = new GeradorDePagamento(leiloes, pagamentos, new Avaliador());
		gerador.gera();
		
		//Capturamos o pagamento que foi passado ao Repositorie do Mock
		ArgumentCaptor<Pagamento> argumento = ArgumentCaptor.forClass(Pagamento.class);
		
		//no lugar de passar o pagamento, passamos o argumento.capture que criamos para pagamento
		verify(pagamentos).salva(argumento.capture());
		
		//Pedimos a instância gerada para o capture
		Pagamento pagamentoGerado = argumento.getValue();
		
		assertEquals(2500.0, pagamentoGerado.getValor(), 0.00001);
	}
	
	@Test
	public void seSabadoDeveEmpurrarParaOproximoDiaUtil() {
		RepositorioDeLeiloes leiloes = mock(RepositorioDeLeiloes.class);
		RepositorioDePagamentos pagamentos = mock(RepositorioDePagamentos.class);
		Relogio relogio = mock(Relogio.class);
		
		Leilao leilao = new CriadorDeLeilao().para("Geladeira")
				.lance(new Usuario("Higor"), 2000.00)
				.lance(new Usuario("Fabio"), 2500.00)
				.constroi();
		
		when(leiloes.encerrados()).thenReturn(Arrays.asList(leilao));
		
		Calendar sabado = Calendar.getInstance();
		sabado.set(2020, Calendar.JUNE, 27);
		
		when(relogio.hoje()).thenReturn(sabado);
		
		GeradorDePagamento gerador = new GeradorDePagamento(leiloes, pagamentos, new Avaliador(), relogio);
		gerador.gera();
		
		ArgumentCaptor<Pagamento> argumento = ArgumentCaptor.forClass(Pagamento.class);
		verify(pagamentos).salva(argumento.capture());
		
		Pagamento pagamentoGerado = argumento.getValue();
		
		assertEquals(Calendar.MONDAY, pagamentoGerado.getData().get(Calendar.DAY_OF_WEEK));
		assertEquals(29, pagamentoGerado.getData().get(Calendar.DAY_OF_MONTH));
		
	}
	
	@Test
	public void seDomingoDeveEmpurrarParaOproximoDiaUtil() {
		RepositorioDeLeiloes leiloes = mock(RepositorioDeLeiloes.class);
		RepositorioDePagamentos pagamentos = mock(RepositorioDePagamentos.class);
		Relogio relogio = mock(Relogio.class);
		
		Leilao leilao = new CriadorDeLeilao().para("Geladeira")
				.lance(new Usuario("Higor"), 2000.00)
				.lance(new Usuario("Fabio"), 2500.00)
				.constroi();
		
		when(leiloes.encerrados()).thenReturn(Arrays.asList(leilao));
		
		Calendar domingo = Calendar.getInstance();
		domingo.set(2020, Calendar.JUNE, 28);
		
		when(relogio.hoje()).thenReturn(domingo);
		
		GeradorDePagamento gerador = new GeradorDePagamento(leiloes, pagamentos, new Avaliador(), relogio);
		gerador.gera();
		
		ArgumentCaptor<Pagamento> argumento = ArgumentCaptor.forClass(Pagamento.class);
		verify(pagamentos).salva(argumento.capture());
		
		Pagamento pagamentoGerado = argumento.getValue();
		
		assertEquals(Calendar.MONDAY, pagamentoGerado.getData().get(Calendar.DAY_OF_WEEK));
		assertEquals(29, pagamentoGerado.getData().get(Calendar.DAY_OF_MONTH));
		
	}
}
