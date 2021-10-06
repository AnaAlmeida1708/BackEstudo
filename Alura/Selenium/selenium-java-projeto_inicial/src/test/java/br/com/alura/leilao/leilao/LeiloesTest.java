package br.com.alura.leilao.leilao;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import br.com.alura.leilao.login.LoginPage;

public class LeiloesTest {
	
	private LeilaoPage paginaDeLeilao;
	private CadastroLeilaoPage paginaDeCadastro;
	
	@BeforeEach
	public void beforeEach() {
		LoginPage paginaDeLogin = new LoginPage();
		paginaDeLogin.preencheFormularioDeLogin("fulano", "pass");
		this.paginaDeLeilao = paginaDeLogin.efetuarLogin();
		this.paginaDeCadastro = paginaDeLeilao.carregarFormulario();
	}
	
	@AfterEach
	public void afterEach() {
		this.paginaDeLeilao.close();
	}
	
	@Test
	public void deveriaCadastrarUmLeilao() {
		String hoje = LocalDate.now().format(DateTimeFormatter.ofPattern("dd/MM/yyyy"));
		String nome = "Leilao do dia " + hoje;
		String valorInicial = "500.00";
		
		this.paginaDeLeilao = paginaDeCadastro.cadastrarLeilao(nome, valorInicial, hoje);
		
		Assertions.assertTrue(this.paginaDeLeilao.isLeilaoCadastrado(nome, valorInicial, hoje));
	}
	
	@Test
	public void deveriaValidarCadastroLeilao() {
		this.paginaDeLeilao = paginaDeCadastro.cadastrarLeilao("", "", "");
		Assertions.assertFalse(this.paginaDeCadastro.isPaginaAtual());
		Assertions.assertTrue(this.paginaDeCadastro.containMensagensValidacao());
	}

}


