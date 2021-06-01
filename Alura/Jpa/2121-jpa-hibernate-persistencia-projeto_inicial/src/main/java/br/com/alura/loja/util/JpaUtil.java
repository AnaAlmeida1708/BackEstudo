package br.com.alura.loja.util;

import java.math.BigDecimal;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import br.com.alura.loja.dao.CategoriaDAO;
import br.com.alura.loja.dao.ClienteDAO;
import br.com.alura.loja.dao.ProdutoDAO;
import br.com.alura.loja.model.Categoria;
import br.com.alura.loja.model.Cliente;
import br.com.alura.loja.model.Produto;

public class JpaUtil {
	
	private static final EntityManagerFactory FACTORY = Persistence.createEntityManagerFactory("loja");
	
	public EntityManager getEntityManager() {
		cadastrarItens();
		return FACTORY.createEntityManager();
	}
	
	public void cadastrarItens() {
		EntityManager em = FACTORY.createEntityManager();
		
		Categoria celulares = new Categoria("CELULARES");
		Categoria informatica = new Categoria("INFORMÁTICA");
		Categoria moveis = new Categoria("MÓVEIS");
		CategoriaDAO categoriaDAO = new CategoriaDAO(em);
		
		Produto celular = new Produto("nokia","novo", new BigDecimal("500"), celulares );
		Produto teclado = new Produto("teclado","sem fio", new BigDecimal("100"), celulares );
		Produto cadeira = new Produto("cadeira","gamer", new BigDecimal("1200"), celulares );
		ProdutoDAO produtoDAO = new ProdutoDAO(em);
		
		ClienteDAO clienteDAO = new ClienteDAO(em);
		Cliente cliente = new Cliente("Ana", "12345");
		
		em.getTransaction().begin();
		
		categoriaDAO.cadastrar(celulares);
		categoriaDAO.cadastrar(informatica);
		categoriaDAO.cadastrar(moveis);
		
		produtoDAO.cadastrar(celular);
		produtoDAO.cadastrar(teclado);
		produtoDAO.cadastrar(cadeira);
		
		clienteDAO.cadastrar(cliente);
		
		em.getTransaction().commit();
		em.close();

	}
	

}
