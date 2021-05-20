package br.com.alura.rh.promocao.service;

import br.com.alura.rh.ValidacaoException;
import br.com.alura.rh.model.Cargo;
import br.com.alura.rh.model.Funcionario;

public class PromocaoService {
	
	public void promover (Funcionario funcionario, Boolean metaBatida) {
		Cargo cargoAtual  = funcionario.getCargo();
		if(Cargo.GERENTE.equals(cargoAtual)) {
			throw new ValidacaoException("Gerentes não podem ser promovidos!");
		}
		
		if(metaBatida) {
			Cargo novoCargo = cargoAtual.getProximoCargo();
			funcionario.promover(novoCargo);
		} else {
			throw new ValidacaoException("Funcionário não bateu a meta!");
		}
		
	}
}
