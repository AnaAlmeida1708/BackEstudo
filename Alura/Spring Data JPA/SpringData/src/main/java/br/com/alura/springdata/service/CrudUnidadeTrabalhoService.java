package br.com.alura.springdata.service;

import java.util.Optional;
import java.util.Scanner;

import org.springframework.stereotype.Service;

import br.com.alura.springdata.orm.UnidadeTrabalho;
import br.com.alura.springdata.repository.UnidadeTrabalhoRepository;

@Service
public class CrudUnidadeTrabalhoService {
	
	private final UnidadeTrabalhoRepository repository;
	
	private Boolean system = Boolean.TRUE;
	
	public CrudUnidadeTrabalhoService(UnidadeTrabalhoRepository repository) {
		this.repository = repository;
	}
	
	public void inicial(Scanner scanner) {
		while (system) {
			System.out.println("Qual ação de unidade de trabalho deseja executar?");
			System.out.println("0 - Para sair");
			System.out.println("1 - Para cadastrar nova unidade");
			System.out.println("2 - Para atualizar unidade");
			System.out.println("3 - Listar unidades");
			System.out.println("4 - Remover unidade");

			int action = scanner.nextInt();
			switch (action) {
			case 0:
				system = Boolean.FALSE;
				break;
			case 1:
				salvar(scanner);
				break;
			case 2:
				atualizar(scanner);
				break;
			case 3:
				listar();
				break;
			case 4:
				deletar(scanner);
				break;
			default:
				system = Boolean.FALSE;
				break;
			}

		}
	}
	
	public void salvar(Scanner scanner) {
		System.out.println("Nome da unidade: ");
		String nome = scanner.next();
		System.out.println("Endereço da unidade: ");
		String endereco = scanner.next();
		
		UnidadeTrabalho unidadeTrabalho = new UnidadeTrabalho();
		unidadeTrabalho.setNome(nome);
		unidadeTrabalho.setEndereco(endereco);
		repository.save(unidadeTrabalho);
		System.out.println("Salvo!");
	}
	
	public void atualizar(Scanner scanner) {
		System.out.println("Id: ");
		Integer id = scanner.nextInt();
		System.out.println("Nome da unidade: ");
		String nome = scanner.next();
		System.out.println("Endereço da unidade: ");
		String endereco = scanner.next();
		
		UnidadeTrabalho unidadeTrabalho = new UnidadeTrabalho();
		unidadeTrabalho.setId(id);
		unidadeTrabalho.setNome(nome);
		unidadeTrabalho.setEndereco(endereco);
		
		repository.save(unidadeTrabalho);
		System.out.println("Atualizado!");
	}
	
	public void  listar(){
		Iterable<UnidadeTrabalho> unidades = repository.findAll();
		unidades.forEach(u -> System.out.println(u));
	}
	
	public void deletar(Scanner scanner) {
		System.out.println("Id: ");
		Integer id = scanner.nextInt();
		
		repository.deleteById(id);
		System.out.println("Removido!");
	}
	
	public Optional<UnidadeTrabalho> findById(Integer id){
		return repository.findById(id);
	}
	

}
