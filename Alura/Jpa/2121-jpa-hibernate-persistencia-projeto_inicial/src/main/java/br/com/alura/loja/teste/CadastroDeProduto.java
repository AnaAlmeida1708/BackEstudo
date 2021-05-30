package br.com.alura.loja.teste;

import javax.persistence.EntityManager;

import br.com.alura.loja.model.Categoria;
import br.com.alura.loja.util.JpaUtil;

public class CadastroDeProduto {

	public static void main(String[] args) {
		EntityManager em = new JpaUtil().getEntityManager();
		
		Categoria celulares = new Categoria("CELULARES");
		
		em.getTransaction().begin();
		em.persist(celulares);
		celulares.setNome("XPTO");
		em.flush();
		em.clear();
		
		celulares = em.merge(celulares);
		celulares.setNome("1234");
		em.flush();
		
		em.remove(celulares);
		em.flush();

	}

}
