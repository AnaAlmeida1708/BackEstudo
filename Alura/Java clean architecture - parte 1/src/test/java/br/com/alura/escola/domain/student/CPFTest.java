package br.com.alura.escola.domain.student;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import br.com.alura.escola.domain.student.CPF;

class CPFTest {

	@Test
	void naoDeveriaCriarCPFComNumeroInvalido() {
		assertThrows(IllegalArgumentException.class, 
				()-> new CPF(null));
		
		assertThrows(IllegalArgumentException.class, 
				()-> new CPF(""));
		
		assertThrows(IllegalArgumentException.class, 
				()-> new CPF("0000"));
		
		assertThrows(IllegalArgumentException.class, 
				()-> new CPF("CPFInvalido"));
	}
	
	@Test
	void deveriaPermitirCriarCPFComNumeroValido() {
		String numero = "123.456.789-00";
		CPF cpf = new CPF(numero);
		assertEquals(numero, cpf.getCpf());
	}

}
