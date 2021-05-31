package br.com.alura.loja.teste;

import java.math.BigDecimal;
import java.util.List;

import javax.persistence.EntityManager;

import br.com.alura.loja.dao.CategoriaDAO;
import br.com.alura.loja.dao.ProdutoDAO;
import br.com.alura.loja.model.Categoria;
import br.com.alura.loja.model.Produto;
import br.com.alura.loja.util.JpaUtil;

public class CadastroDeProduto {
	
	public static void main(String[] args) {
		EntityManager em = new JpaUtil().getEntityManager();
		ProdutoDAO produtoDAO = new ProdutoDAO(em);
		
		cadastrarProduto();
		Produto produto = produtoDAO.buscarPorId(1L);
		System.out.println(produto);
		List<Produto> todos = produtoDAO.buscaTodos();
		todos.forEach(p -> System.out.println(p));
		
		List<Produto> porNome = produtoDAO.buscaPorNomeCategoria("CELULARES");
		porNome.forEach(p -> System.out.println(p));
		
		String nomeProduto = produtoDAO.buscaProdutoComNome("nokia");
		System.out.println(nomeProduto);
		
	}

	private static void cadastrarProduto() {
		EntityManager em = new JpaUtil().getEntityManager();
		
		Categoria celulares = new Categoria("CELULARES");
		CategoriaDAO categoriaDAO = new CategoriaDAO(em);
		
		Produto celular = new Produto("nokia","legal", new BigDecimal("500"), celulares );
		ProdutoDAO produtoDAO = new ProdutoDAO(em);
		
		em.getTransaction().begin();
		categoriaDAO.cadastrar(celulares);
		produtoDAO.cadastrar(celular);
		em.getTransaction().commit();
		em.close();

	}

}
