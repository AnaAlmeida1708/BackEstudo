package br.com.alura.leilao.login;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class LoginTest {
	
	private LoginPage paginaDeLogin;
	
	@BeforeEach
	public void beforeEach() {
		this.paginaDeLogin = new LoginPage();
	}
	
	@AfterEach
	public void afterEach() {
		this.paginaDeLogin.close();
		
	}
	
	@Test
	public void deveriaEfetuarLoginComDadosValidos() {
		paginaDeLogin.preencheFormularioDeLogin("fulano", "pass");
		paginaDeLogin.efetuarLogin();

		Assertions.assertFalse(paginaDeLogin.isPaginaDeLogin());
		Assertions.assertEquals("fulano", paginaDeLogin.getNomeUsuarioLogado());
	}
	
	@Test
	public void naoDeveriaEfetuarLoginComDadosInvalidos() {
		paginaDeLogin.preencheFormularioDeLogin("inválido", "123");
		paginaDeLogin.efetuarLogin();

		Assertions.assertTrue(paginaDeLogin.isPaginaDeErroLogin());
		Assertions.assertTrue(paginaDeLogin.containTexto("Usuário e senha inválidos."));
		Assertions.assertNull(paginaDeLogin.getNomeUsuarioLogado());
	}
	
	@Test
	public void naoDeveriaAcessarpaginaRestritaSemEstarLogado() {
		paginaDeLogin.acessaPaginaDeLeiloes();
		
		Assertions.assertTrue(paginaDeLogin.isPaginaDeLogin());
		Assertions.assertFalse(paginaDeLogin.containTexto("Dados do Leilão"));
	}

}
