package br.com.alura.springdata.repository;

import java.time.LocalDate;
import java.util.List;

import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;

import br.com.alura.springdata.orm.Funcionario;
import br.com.alura.springdata.orm.FuncionarioProjecao;

public interface FuncionarioRepository extends PagingAndSortingRepository<Funcionario, Integer>,
 JpaSpecificationExecutor<Funcionario>{
	
	List<Funcionario> findByNome(String nome);
	
	List<Funcionario> findByNomeLike(String nome);
	
	List<Funcionario> findByNomeEndingWith(String nome);
	
	List<Funcionario> findByNomeStartingWith(String nome);
	
	List<Funcionario> findByNomeIsNull();
	
	List<Funcionario> findByNomeIsNotNull();
	
	List<Funcionario> findByNomeOrderByNomeAsc(String nome);
	
	@org.springframework.data.jpa.repository.Query(" SELECT f FROM Funcionario f WHERE f.nome = :nome "
			+ " AND f.salario >= :salario AND f.dataDeContratacao = :data ")
	List<Funcionario> findNomeSalarioMaiorDataContratacao(@Param("nome")String nome, 
			@Param("salario")Double salario, @Param("data")LocalDate data);
	
	List<Funcionario> findByCargoDescricao(String descricao);
	
	@Query("SELECT f FROM Funcionario f JOIN f.cargo c WHERE c.descricao = :descricao")
	List<Funcionario> findByCargoPelaDescricao(String descricao);
	
	//Quando o nome da entidade é composto é necessário separar os atributos usando _ 
//	List<Funcionario> findByUnidadeTrabalhos_Descricao(String descricao);
	
	@org.springframework.data.jpa.repository.Query(value = " SELECT * FROM Funcionarios f WHERE f.nome = :nome ", nativeQuery=true)
	List<Funcionario> findFuncionariosPorNome(@Param("nome")String nome);
	
	@org.springframework.data.jpa.repository.Query(value = " SELECT F.ID, F.NOME, F.SALARIO FROM Funcionarios f ", nativeQuery=true)
	List<FuncionarioProjecao> findFuncionarioSalario();
	
	

}
