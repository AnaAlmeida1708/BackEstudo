package br.com.caelum.leilao.servico;

import static org.junit.Assert.assertEquals;

import org.junit.Assert;
import org.junit.Test;

import br.com.caelum.leilao.dominio.Lance;
import br.com.caelum.leilao.dominio.Leilao;
import br.com.caelum.leilao.dominio.Usuario;

public class AvaliadorTest {
	
	@Test
	public void deveEntenderLancesEmOrdemCrescente() {//o método precisa ser public, não pode ser static e não retorna nada
		// cenario: 3 lances em ordem crescente
        Usuario joao = new Usuario("João");
        Usuario jose = new Usuario("José");
        Usuario maria = new Usuario("Maria");

        Leilao leilao = new Leilao("Playstation 3 Novo");

        leilao.propoe(new Lance(joao, 250.0));
        leilao.propoe(new Lance(jose, 300.0));
        leilao.propoe(new Lance(maria, 400.0));

        // parte 2: acao
        Avaliador leiloeiro = new Avaliador();
        leiloeiro.avalia(leilao);
        
        //parte 3: validação
        // exibindo a saida - a classe Assert tem vários métodos que nos ajudam a conferir o resultado calculado
        double maiorEsperado = 400;
        double menorEsperado = 250;

        /**
         * AssertEquals
         * primeiro o valor esperado, depois o método que vai ser testado e trazer o valor para comparação e depois um delta, 
         * devido o double e float ter problemas para arredondar, esta é a margem que ele pode deixar "passar"
         */
        assertEquals(maiorEsperado, leiloeiro.getMaiorLance(), 0.00001);
        assertEquals(menorEsperado, leiloeiro.getMenorLance(), 0.00001);
	}
}
