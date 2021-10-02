package br.com.alura.leilao.leilao;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import br.com.alura.leilao.PageObject;

public class CadastroLeilaoPage extends PageObject{
	
	private static final String URL_CADASTRO_LEILAO = "http://localhost:8080/leiloes/new";
	
	public CadastroLeilaoPage(WebDriver browser) {
		super(browser);
	}

	public LeilaoPage cadastrarLeilao(String nome, String valorInicial, String hoje) {
		browser.findElement(By.id("nome")).sendKeys(nome);
		browser.findElement(By.id("valorInicial")).sendKeys(valorInicial); 
		browser.findElement(By.id("dataAbertura")).sendKeys(hoje); 
		browser.findElement(By.id("button-submit")).click();
		
		return new LeilaoPage(browser);
	}

	public Boolean isPaginaAtual() {
		return browser.getCurrentUrl().equals(URL_CADASTRO_LEILAO);
	}
	
	public Boolean containMensagensValidacao() {
		return browser.getPageSource().contains("minimo 3 caracteres")
				&& browser.getPageSource().contains("não deve estar em branco")
				&& browser.getPageSource().contains("deve ser um valor maior de 0.1")
				&& browser.getPageSource().contains("deve ser uma data no formato dd/MM/yyyy");
	}
	

}
