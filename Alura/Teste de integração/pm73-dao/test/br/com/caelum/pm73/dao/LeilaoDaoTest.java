package br.com.caelum.pm73.dao;

import static org.junit.Assert.assertEquals;

import java.util.Calendar;
import java.util.List;

import org.hibernate.Session;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import br.com.caelum.pm73.dominio.Leilao;
import br.com.caelum.pm73.dominio.Usuario;

public class LeilaoDaoTest {
	
	private Session session;
	private UsuarioDao usuarioDao;
	private LeilaoDao leilaoDao;
	
	@Before
	public void antes() {
		session = new CriadorDeSessao().getSession();
		usuarioDao = new UsuarioDao(session);
		leilaoDao = new LeilaoDao(session);
		
		session.beginTransaction();
	}
	
	@After
	public void depois() {
		session.getTransaction().rollback();
		session.close();
	}
	
	@Test
	public void deveContarLeiloesNaoEncerrados() {
		Usuario fabio = new Usuario("Fabio Araújo", "fabio@gmail.com");
		
		Leilao ativo = new Leilao("geladeira", 1200.00, fabio, false);
		Leilao encerrado = new Leilao("TV", 700.00, fabio, false);
		encerrado.encerra();
		
		usuarioDao.salvar(fabio);
		leilaoDao.salvar(ativo);
		leilaoDao.salvar(encerrado);
		
		long total = leilaoDao.total();
		
		assertEquals(1L, total);
	}
	
	@Test
	public void deveRetornarZeroCasoNaoHajaLeiloesAtivos() {
		Usuario cris = new Usuario("Cris", "cris@gmail.com");
		
		Leilao encerrado2 = new Leilao("geladeira", 1200.00, cris, false);
		Leilao encerrado = new Leilao("TV", 700.00, cris, false);
		encerrado.encerra();
		encerrado2.encerra();
		
		usuarioDao.salvar(cris);
		leilaoDao.salvar(encerrado2);
		leilaoDao.salvar(encerrado);
		
		long total = leilaoDao.total();
		
		assertEquals(0L, total);
		
	}
	
	
	@Test
	public void deveRetornarApenasLeiloesNovos() {
		Usuario cris = new Usuario("Cris", "cris@gmail.com");
		
		Leilao produtoNovo = new Leilao("geladeira", 1200.00, cris, false);
		Leilao produtoUsado = new Leilao("TV", 700.00, cris, true);
		produtoUsado.encerra();
		produtoNovo.encerra();
		
		usuarioDao.salvar(cris);
		leilaoDao.salvar(produtoNovo);
		leilaoDao.salvar(produtoUsado);
		
		List<Leilao> novos = leilaoDao.novos();
		
		assertEquals(1L, novos.size());
		assertEquals("geladeira", novos.get(0).getNome());
	}
	
	@Test
	public void deveRetornarApenasLeiloesAntigos() {
		Calendar c = Calendar.getInstance();
		c.set(Calendar.YEAR, 2020);
		c.set(Calendar.MONTH, Calendar.APRIL);
		c.set(Calendar.DAY_OF_MONTH, 20);
		
		Calendar d = Calendar.getInstance();
		d.set(Calendar.YEAR, 2020);
		d.set(Calendar.MONTH, Calendar.AUGUST);
		d.set(Calendar.DAY_OF_MONTH, 25);
		
		Usuario cris = new Usuario("Cris", "cris@gmail.com");
		Leilao novo = new Leilao("geladeira", 1200.00, cris, false);
		novo.setDataAbertura(Calendar.getInstance());
		
		Leilao antigo1 = new Leilao("TV", 1000.00, cris, false);
		antigo1.setDataAbertura(c);
		
		Leilao antigo2 = new Leilao("Fogão", 500.00, cris, false);
		antigo2.setDataAbertura(d);
		
		usuarioDao.salvar(cris);
		leilaoDao.salvar(novo);
		leilaoDao.salvar(antigo1);
		leilaoDao.salvar(antigo2);
		
		List<Leilao> antigos = leilaoDao.antigos();
		
		assertEquals(2L, antigos.size());
		assertEquals("TV", antigos.get(0).getNome());
	}

}
