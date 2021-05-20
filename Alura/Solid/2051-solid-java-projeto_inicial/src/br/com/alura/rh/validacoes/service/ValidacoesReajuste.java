package br.com.alura.rh.validacoes.service;

import java.math.BigDecimal;

import br.com.alura.rh.model.Funcionario;

public interface ValidacoesReajuste {
	
	void validar(Funcionario funcionario, BigDecimal valorAumento);

}
