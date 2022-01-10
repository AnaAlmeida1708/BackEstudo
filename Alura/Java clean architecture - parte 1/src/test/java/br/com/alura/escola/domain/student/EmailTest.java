package br.com.alura.escola.domain.student;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import br.com.alura.escola.domain.student.Email;

class EmailTest {

	@Test
	void naoDeveriaCriarEmailsComEnderecosInvalidos() {
		assertThrows(IllegalArgumentException.class, 
				()-> new Email(null));
		
		assertThrows(IllegalArgumentException.class, 
				()-> new Email(""));
		
		assertThrows(IllegalArgumentException.class, 
				()-> new Email("emailInvalido"));
	}
	
	@Test
	void deveriaPermitirCriarEmailComEnderecoValido() {
		String endereco = "fulano@alura.com.br";
		Email email = new Email(endereco);
		assertEquals(email, email.getEmail());
	}

}
