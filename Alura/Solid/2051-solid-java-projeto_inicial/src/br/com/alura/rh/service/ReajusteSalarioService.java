package br.com.alura.rh.service;

import java.math.BigDecimal;
import java.math.RoundingMode;

import br.com.alura.rh.ValidacaoException;
import br.com.alura.rh.model.Funcionario;

public class ReajusteSalarioService {
	
	public void reajustarSalarioDoFuncionario(Funcionario funcionario, BigDecimal valorAumento) {
		BigDecimal salarioAtual = funcionario.getSalario();
		BigDecimal percentualReajuste = valorAumento.divide(salarioAtual, RoundingMode.HALF_UP);
		if (percentualReajuste.compareTo(new BigDecimal("0.4")) > 0) {
			throw new ValidacaoException("Reajuste nao pode ser superior a 40% do salario!");
		}
		BigDecimal novoSalario = salarioAtual.add(valorAumento);
		funcionario.atualizarSalario(novoSalario);
	}
}
