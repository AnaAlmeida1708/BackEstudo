package br.com.alura.springdata.service;

import java.util.Optional;
import java.util.Scanner;

import org.springframework.stereotype.Service;

import br.com.alura.springdata.orm.Cargo;
import br.com.alura.springdata.repository.CargoRepository;

@Service
public class CrudCargoService {
	
	private final CargoRepository repository;
	
	private Boolean system = Boolean.TRUE;
	
	public CrudCargoService(CargoRepository repository) {
		this.repository = repository;
	}
	
	public void inicial(Scanner scanner) {
		while (system) {
			System.out.println("Qual ação de cargo deseja executar?");
			System.out.println("0 - Para sair");
			System.out.println("1 - Para cadastrar novo cargo");
			System.out.println("2 - Para atualizar cargo");
			System.out.println("3 - Listar cargos");
			System.out.println("4 - Remover cargo");

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
				listaCargos();
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
		System.out.println("Descrição do cargo: ");
		String descricao = scanner.next();
		Cargo cargo = new Cargo();
		cargo.setDescricao(descricao);
		repository.save(cargo);
		System.out.println("Salvo!");
	}
	
	public void atualizar(Scanner scanner) {
		System.out.println("Id: ");
		Integer id = scanner.nextInt();
		System.out.println("Descrição do cargo: ");
		String descricao = scanner.next();
		
		Cargo cargo = new Cargo();
		cargo.setId(id);
		cargo.setDescricao(descricao);
		
		repository.save(cargo);
		System.out.println("Atualizado!");
	}
	
	public void  listaCargos(){
		Iterable<Cargo> cargos = repository.findAll();
		cargos.forEach(c -> System.out.println(c));
	}
	
	public void deletar(Scanner scanner) {
		System.out.println("Id: ");
		Integer id = scanner.nextInt();
		
		repository.deleteById(id);
		System.out.println("Removido!");
	}
	
	public Optional<Cargo> findById(Integer id){
		return repository.findById(id);
	}
	

}
