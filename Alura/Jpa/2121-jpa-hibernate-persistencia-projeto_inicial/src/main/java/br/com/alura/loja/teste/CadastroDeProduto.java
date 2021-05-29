package br.com.alura.loja.teste;

import java.math.BigDecimal;

import javax.persistence.EntityManager;

import br.com.alura.loja.dao.ProdutoDAO;
import br.com.alura.loja.model.Categoria;
import br.com.alura.loja.model.Produto;
import br.com.alura.loja.util.JpaUtil;

public class CadastroDeProduto {

	public static void main(String[] args) {
		Produto celular = new Produto("nokia","legal", new BigDecimal("500"), Categoria.CELULARES);
		
		EntityManager em = new JpaUtil().getEntityManager();
		
		ProdutoDAO dao = new ProdutoDAO(em);
		
		em.getTransaction().begin();
		dao.cadastrar(celular);
		em.getTransaction().commit();
		em.close();

	}

}
