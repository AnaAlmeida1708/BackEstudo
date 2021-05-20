package br.com.alura.rh.tributacao.service;

import java.math.BigDecimal;

public interface ReajusteTributavel extends Reajuste {
	
	BigDecimal valorImpostoDeRenda();

}
