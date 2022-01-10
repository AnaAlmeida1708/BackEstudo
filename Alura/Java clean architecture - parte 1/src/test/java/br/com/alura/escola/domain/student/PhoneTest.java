package br.com.alura.escola.domain.student;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import br.com.alura.escola.domain.student.Phone;

class PhoneTest {

	@Test
	void naoDeveriaCriarPhoneComDDDsInvalidos() {
		assertThrows(IllegalArgumentException.class,
				() -> new Phone(null, "123456789"));
		
		assertThrows(IllegalArgumentException.class,
				() -> new Phone("", "123456789"));
		
		assertThrows(IllegalArgumentException.class,
				() -> new Phone("1", "123456789"));
	}

	@Test
	void naoDeveriaCriarPhoneComNumerosInvalidos() {
		assertThrows(IllegalArgumentException.class,
				() -> new Phone("11", null));
		
		assertThrows(IllegalArgumentException.class,
				() -> new Phone("11", ""));
		
		assertThrows(IllegalArgumentException.class,
				() -> new Phone("11", "123"));
	}

	@Test
	void deveriaPermitirCriarPhoneComDDDENumeroValidos() {
		String ddd = "11";
		String number = "123456789";
		Phone Phone = new Phone(ddd, number);
		assertEquals(ddd, Phone.getDdd());
		assertEquals(number, Phone.getNumber());
	}

}
