package br.com.alura.springdata.service;

import java.util.List;
import java.util.Scanner;

import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import br.com.alura.springdata.orm.Funcionario;
import br.com.alura.springdata.repository.FuncionarioRepository;
import br.com.alura.springdata.specification.SpecificationFuncionario;

@Service
public class RelatorioFuncionarioDinamico {
	
	private final FuncionarioRepository funcionarioRepository;

	public RelatorioFuncionarioDinamico(FuncionarioRepository funcionarioRepository) {
		this.funcionarioRepository = funcionarioRepository;
	}
	
	public void inicial(Scanner scanner) {
			System.out.println("Digite o nome: ");
			String nome = scanner.next();
			
			List<Funcionario> funcionarios = 
					funcionarioRepository.findAll(Specification.where(SpecificationFuncionario.nome(nome)));
					
			funcionarios.forEach(f -> System.out.println(f));
	}

}
