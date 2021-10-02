package br.com.alura.leilao.leilao;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LeilaoPage {
	
	private WebDriver browser;
	
	public LeilaoPage(WebDriver browser) {
		this.browser = browser;
	}
	
	public void close() {
		this.browser.quit();
	}

	public CadastroLeilaoPage carregarFormulario() {
		browser.findElement(By.id("novo_leilao_link")).click();
		return new CadastroLeilaoPage(browser);
	}
	
	public boolean isLeilaoCadastrado(String nome, String valor, String data) {
		WebElement linhaDaTabela = browser.findElement(By.cssSelector("#tabela-leiloes tbody tr:last-child"));
		WebElement colunaNome =  linhaDaTabela.findElement(By.cssSelector("td:nth-child(1)"));
		WebElement colunaData = linhaDaTabela.findElement(By.cssSelector("td:nth-child(2)"));
		WebElement colunaValor = linhaDaTabela.findElement(By.cssSelector("td:nth-child(3)"));
		
		return colunaNome.getText().equalsIgnoreCase(nome)
				&& colunaValor.getText().equalsIgnoreCase(valor)
				&& colunaData.getText().equalsIgnoreCase(data);
	}
	

}
