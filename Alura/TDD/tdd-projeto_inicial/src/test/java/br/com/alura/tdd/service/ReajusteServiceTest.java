package br.com.alura.tdd.service;

import java.math.BigDecimal;
import java.time.LocalDate;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import br.com.alura.tdd.modelo.Desempenho;
import br.com.alura.tdd.modelo.Funcionario;

public class ReajusteServiceTest {
	
	private ReajusteService service;
	private Funcionario funcionario;
	
	@BeforeEach 
	private void inicializar() {
		System.out.println("Executa m�todo ANTES de cada teste");
		this.service = new ReajusteService();
		this.funcionario = new Funcionario("Ana", LocalDate.now(), new BigDecimal("1000"));
	}
	
	@AfterEach
	private void fim() {
		System.out.println("Executa m�todo AP�S cada teste");
	}
	
	@BeforeAll
	private static void antesDeTodos() {
		System.out.println("Executa m�todo uma vez ANTES de todos os m�todos");
	}
	
	@AfterAll
	private static void depoisDeTodos() {
		System.out.println("Executa m�todo uma vez DEPOIS de todos os m�todos");
	}

	@Test
	public void reajusteDeveSerDeTresPorCentoQuandoDesempenhoForAdesejar() {
		service.concederReajuste(funcionario, Desempenho.A_DESEJAR);
		
		Assertions.assertEquals(new BigDecimal("1030.00"), funcionario.getSalario());
		
	}
	
	@Test
	public void reajusteDeveSerDe15PorCentoQuandoDesempenhoForBom() {
		service.concederReajuste(funcionario, Desempenho.BOM);
		
		Assertions.assertEquals(new BigDecimal("1150.00"), funcionario.getSalario());
		
	}
	
	@Test
	public void reajusteDeveSerDe20PorCentoQuandoDesempenhoForOtimo() {
		service.concederReajuste(funcionario, Desempenho.OTIMO);
		
		Assertions.assertEquals(new BigDecimal("1200.00"), funcionario.getSalario());
		
	}

}
