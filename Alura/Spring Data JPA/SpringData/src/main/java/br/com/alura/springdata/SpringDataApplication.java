package br.com.alura.springdata;

import java.util.Scanner;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import br.com.alura.springdata.service.CrudCargoService;
import br.com.alura.springdata.service.CrudFuncionarioService;
import br.com.alura.springdata.service.CrudUnidadeTrabalhoService;
import br.com.alura.springdata.service.RelatorioFuncionarioDinamico;
import br.com.alura.springdata.service.RelatorioService;

@SpringBootApplication
public class SpringDataApplication implements CommandLineRunner{
	
	private final CrudCargoService cargoService;
	private final CrudFuncionarioService funcionarioService;
	private final CrudUnidadeTrabalhoService unidadeTrabalhoService;
	private final RelatorioService relatorioService;
	private final RelatorioFuncionarioDinamico relatorioDinamico;
	
	private Boolean system = Boolean.TRUE;

	public SpringDataApplication(CrudCargoService cargoService, 
			CrudFuncionarioService funcionarioService, 
			CrudUnidadeTrabalhoService unidadeTrabalhoService,
			RelatorioService relatorioService,
			RelatorioFuncionarioDinamico relatorioDinamico) {
		this.cargoService = cargoService;
		this.funcionarioService = funcionarioService;
		this.unidadeTrabalhoService = unidadeTrabalhoService;
		this.relatorioService = relatorioService;
		this.relatorioDinamico = relatorioDinamico;
	}

	public static void main(String[] args) {
		SpringApplication.run(SpringDataApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		
		Scanner scan = new Scanner(System.in);
		
		while (system) {
			System.out.println("Qual ação deseja executar?");
			System.out.println("0 - Sair");
			System.out.println("1 - Cargo");
			System.out.println("2 - Funcionario");
			System.out.println("3 - Unidade de trabalho");
			System.out.println("4 - Relatório");
			System.out.println("5 - Relatório Dinâmico");
			
			int action = scan.nextInt();
			switch (action) {
			case 1:
				cargoService.inicial(scan);
				break;
			case 2:
				funcionarioService.inicial(scan);
				break;
			case 3:
				unidadeTrabalhoService.inicial(scan);
				break;
			case 4:
				relatorioService.inicial(scan);
				break;
			case 5:
				relatorioDinamico.inicial(scan);
				break;
			default:
				system = Boolean.FALSE;
				break;
			}
		}
		
		
	}

}
