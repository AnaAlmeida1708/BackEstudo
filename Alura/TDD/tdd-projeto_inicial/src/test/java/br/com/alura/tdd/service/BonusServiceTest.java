package br.com.alura.tdd.service;

import java.math.BigDecimal;
import java.time.LocalDate;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import br.com.alura.tdd.modelo.Funcionario;

class BonusServiceTest {

	@Test
	void bonusDeveSerZeroParaFuncionarioComSalarioMuitoAlto() {
		BonusService service = new BonusService();
		
		Assertions.assertThrows(IllegalArgumentException.class, 
				() -> service.calcularBonus(new Funcionario("Ana", LocalDate.now(), new BigDecimal("25000"))));
		
		//Geralmente usado quando se quer validar além da exception a mensagem da exception
//		try {
//			service.calcularBonus(new Funcionario("Ana", LocalDate.now(), new BigDecimal("25000")));
//			Assertions.fail("Não deu a exception");
//		} catch (Exception e) {
//			Assertions.assertEquals("Funcionário não pode receber bônus, pois valor bônus seria superior a R$ 1000,00", e.getMessage());
//		}

	}
	
	@Test
	void bonusDeveSerDezPorCentoDoSalario() {
		BonusService service = new BonusService();
		BigDecimal bonus = service.calcularBonus(new Funcionario("Ana", LocalDate.now(), new BigDecimal("4500")));
		
		Assertions.assertEquals(new BigDecimal("450.00"), bonus);
	}
	
	@Test
	void bonusDeveSerMilReaisParaSalarioDe10mil() {
		BonusService service = new BonusService();
		BigDecimal bonus = service.calcularBonus(new Funcionario("Ana", LocalDate.now(), new BigDecimal("10000")));
		
		Assertions.assertEquals(new BigDecimal("1000.00"), bonus);
	}

}
