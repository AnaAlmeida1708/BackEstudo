package br.com.alura.rh.tributacao.service;

import java.math.BigDecimal;
import java.time.LocalDate;

public interface Reajuste {
	
	BigDecimal valor();
	LocalDate data();

}
