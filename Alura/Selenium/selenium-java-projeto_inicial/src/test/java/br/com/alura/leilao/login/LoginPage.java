package br.com.alura.leilao.login;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;

import br.com.alura.leilao.PageObject;
import br.com.alura.leilao.leilao.LeilaoPage;

public class LoginPage extends PageObject{
	
	private static final String HTTP_LOGIN = "http://localhost:8080/login";
	
	public LoginPage() {
		super(null);
		this.browser.navigate().to(HTTP_LOGIN);
	}

	public void preencheFormularioDeLogin(String login, String senha) {
		browser.findElement(By.id("username"))//busca o elemento na página pelo id do elemento
		.sendKeys(login); //preenche o campo input
		browser.findElement(By.id("password")).sendKeys(senha); 
	}
	
	public LeilaoPage efetuarLogin() {
		browser.findElement(By.id("btn-login")).click();
		//browser.findElement(By.id("login-form")).submit(); outra forma de fazer a submissão
		return new LeilaoPage(browser);
	}

	public Boolean isPaginaDeLogin() {
		return browser.getCurrentUrl().equals(HTTP_LOGIN);
	}

	public String getNomeUsuarioLogado() {
		try {
			return browser.findElement(By.id("usuario-logado")).getText();
		} catch (NoSuchElementException e) {
			return null;
		}
	}
	
	public Boolean isPaginaDeErroLogin() {
		return browser.getCurrentUrl().equals(HTTP_LOGIN+"?error");
	}
	
	public Boolean containTexto(String texto) {
		return browser.getPageSource().contains(texto);
	}
	
	public void acessaPaginaDeLeiloes() {
		browser.navigate().to("http://localhost:8080/leiloes/2");
	}
	

}
