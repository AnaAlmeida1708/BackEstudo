package br.com.alura.rh.service;

import java.math.BigDecimal;
import java.util.List;

import br.com.alura.rh.model.Funcionario;
import br.com.alura.rh.validacoes.service.ValidacoesReajuste;

public class ReajusteSalarioService {
	
	private List<ValidacoesReajuste> validacoes;
	
	public ReajusteSalarioService(List<ValidacoesReajuste> validacoes) {
		this.validacoes = validacoes;
	}

	public void reajustarSalarioDoFuncionario(Funcionario funcionario, BigDecimal valorAumento) {
		this.validacoes.forEach(v -> v.validar(funcionario, valorAumento));
		
		BigDecimal salarioAtual = funcionario.getSalario();
		BigDecimal novoSalario = salarioAtual.add(valorAumento);
		funcionario.atualizarSalario(novoSalario);
	}
	
}
