package br.com.alura.leilao.dao;

import java.math.BigDecimal;
import java.time.LocalDate;

import javax.persistence.EntityManager;

import org.junit.Assert;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import br.com.alura.leilao.model.Leilao;
import br.com.alura.leilao.model.Usuario;
import br.com.alura.leilao.util.JPAUtil;
import br.com.alura.leilao.util.LeilaoBuilder;
import br.com.alura.leilao.util.UsuarioBuilder;

class LeilaoDaoTest {
	
	private LeilaoDao dao;
	
	private EntityManager em;
	
	@BeforeEach
	public void beforeEach(){
		this.em = JPAUtil.getEntityManager();
		this.dao = new LeilaoDao(em);
		em.getTransaction().begin();
	}
	
	@AfterEach
	public void afterEach() {
		em.getTransaction().rollback();
	}

	@Test
	void deveriaCadastrarUmLeilao() {
		Usuario usuario = new UsuarioBuilder()
				.comNome("fulano")
				.comEmail("fulano@email.com")
				.comSenha("12345678")
				.criar();
		em.persist(usuario);
		
		Leilao leilao = new LeilaoBuilder()
				.comNome("TV")
				.comValorInicial("500")
				.comUsuario(usuario)
				.comdataAbertura(LocalDate.now())
				.criar();
		leilao = dao.salvar(leilao);
		
		Leilao leilaoSalvo = dao.buscarPorId(leilao.getId());
		Assert.assertNotNull(leilaoSalvo);
		
	}
	
	@Test
	void deveriaAtualizarUmLeilao() {
		Usuario usuario = new UsuarioBuilder()
				.comNome("fulano")
				.comEmail("fulano@email.com")
				.comSenha("12345678")
				.criar();
		em.persist(usuario);
		
		Leilao leilao = new LeilaoBuilder()
				.comNome("TV")
				.comValorInicial("500")
				.comUsuario(usuario)
				.comdataAbertura(LocalDate.now())
				.criar();
		leilao = dao.salvar(leilao);
		
		leilao.setNome("TV LED");
		leilao.setValorInicial(new BigDecimal("700.00"));
		leilao = dao.salvar(leilao);
		
		Leilao leilaoSalvo = dao.buscarPorId(leilao.getId());
		Assert.assertEquals("TV LED", leilaoSalvo.getNome());
		Assert.assertEquals(new BigDecimal("700.00"), leilaoSalvo.getValorInicial());
		
	}
	

}
