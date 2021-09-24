package br.com.alura.springdata.service;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Scanner;

import org.springframework.stereotype.Service;

import br.com.alura.springdata.orm.Funcionario;
import br.com.alura.springdata.repository.FuncionarioRepository;

@Service
public class RelatorioService {
	
	private final FuncionarioRepository funcionarioRepository;
	
	private Boolean system = Boolean.TRUE;
	private final DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");

	public RelatorioService(FuncionarioRepository funcionarioRepository) {
		this.funcionarioRepository = funcionarioRepository;
	}
	
	public void inicial(Scanner scanner) {
		while (system) {
			System.out.println("Qual ação de relatório deseja executar?");
			System.out.println("0 - Para sair");
			System.out.println("1 - Busca por nome funcionário");
			System.out.println("2 - Busca por nome, salário maior que o informado e data contratação ");

			int action = scanner.nextInt();
			switch (action) {
			case 0:
				system = Boolean.FALSE;
				break;
			case 1:
				findByNome(scanner);
				break;
			case 2:
				findNomeSalarioMaiorDataContratacao(scanner);
				break;
			default:
				system = Boolean.FALSE;
				break;
			}

		}
	}
	
	private void findByNome(Scanner scanner) {
		System.out.println("Nome: ");
		String nome = scanner.next();
		
		List<Funcionario> funcionarios = funcionarioRepository.findByNome(nome);
		funcionarios.forEach(f -> System.out.println(f));
	}
	
	private void findNomeSalarioMaiorDataContratacao(Scanner scanner) {
		System.out.println("Nome: ");
		String nome = scanner.next();
		
        System.out.println("Salario: ");
        Double salario = scanner.nextDouble();
        
        System.out.println("Data de contracao");
        String dataContratacao = scanner.next();
		
		List<Funcionario> funcionarios = funcionarioRepository
				.findNomeSalarioMaiorDataContratacao(nome, salario, LocalDate.parse(dataContratacao, formatter));
//				.findByNomeLike(nome);
//		funcionarios.forEach(f -> System.out.println(f));
//				.findFuncionariosPorNome(nome);
		funcionarios.forEach(f -> System.out.println(f));
	}

}
