package br.com.alura.leilao.login;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class LoginTest {
	
	private static final String HTTP_LOGIN = "http://localhost:8080/login";
	private WebDriver browser;

	@BeforeAll
	public static void beforeAll() {
		System.setProperty("webdriver.chrome.driver", "/drivers/chromedriver.exe");

	}
	
	@BeforeEach
	public void beforeEach() {
		browser = new ChromeDriver();
		browser.navigate().to(HTTP_LOGIN);
	}
	
	@AfterEach
	public void afterEach() {
		browser.quit();
	}
	
	@Test
	public void deveriaEfetuarLoginComDadosValidos() {
		browser.findElement(By.id("username"))//busca o elemento na página pelo id do elemento
			.sendKeys("fulano"); //preenche o campo input
		browser.findElement(By.id("password")).sendKeys("pass"); 
		
		browser.findElement(By.id("btn-login")).click();
		//browser.findElement(By.id("login-form")).submit(); outra forma de fazer a submissão
		
		Assertions.assertFalse(browser.getCurrentUrl().equals(HTTP_LOGIN));
		Assertions.assertEquals("fulano", browser.findElement(By.id("usuario-logado")).getText());
	}
	
	@Test
	public void naoDeveriaEfetuarLoginComDadosInvalidos() {
		browser.findElement(By.id("username")).sendKeys("invalido");
		browser.findElement(By.id("password")).sendKeys("123"); 
		browser.findElement(By.id("btn-login")).click();

		Assertions.assertTrue(browser.getCurrentUrl().equals("http://localhost:8080/login?error"));
		Assertions.assertTrue(browser.getPageSource().contains("Usuário e senha inválidos."));
		Assertions.assertFalse(browser.getCurrentUrl().contains("usuario-logado"));
	}
	
	@Test
	public void naoDeveriaAcessarpaginaRestritaSemEstarLogado() {
		browser.navigate().to("http://localhost:8080/leiloes/2");
		Assertions.assertTrue(browser.getCurrentUrl().equals(HTTP_LOGIN));
		Assertions.assertFalse(browser.getPageSource().contains("Dados do Leilão"));
	}

}
