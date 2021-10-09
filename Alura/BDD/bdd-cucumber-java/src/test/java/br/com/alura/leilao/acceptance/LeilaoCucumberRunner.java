package br.com.alura.leilao.acceptance;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class) // Informa para usar o cucumber para rodar
@CucumberOptions(features = "classpath:features") // informa em qual pasta está o arquivo a ser testado
public class LeilaoCucumberRunner {

}
