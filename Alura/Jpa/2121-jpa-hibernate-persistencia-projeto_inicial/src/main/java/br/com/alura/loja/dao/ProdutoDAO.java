package br.com.alura.loja.dao;

import java.util.List;

import javax.persistence.EntityManager;

import br.com.alura.loja.model.Produto;

public class ProdutoDAO {
	
	private EntityManager em;

	public ProdutoDAO(EntityManager em) {
		this.em = em;
	}
	
	public void cadastrar(Produto produto) {
		this.em.persist(produto);
	}
	
	public void atualizar(Produto produto) {
		this.em.merge(produto);
	}
	
	public void remover(Produto produto) {
		produto = this.em.merge(produto);
		this.em.remove(produto);
	}
	
	public Produto buscarPorId(Long id) {
		return this.em.find(Produto.class, id);
	}
	
	public List<Produto> buscaTodos(){
		String jpql = "SELECT p FROM Produto p";//A busca é sempre feita pelo nome da entidade, nunca pelo nome da tabela
		return this.em.createQuery(jpql, Produto.class).getResultList();
	}
	
	public List<Produto> buscaPorNome(String nome){
		String jpql = "SELECT p FROM Produto p WHERE p.nome = :nome";
		return this.em.createQuery(jpql, Produto.class)
				.setParameter("nome", nome)
				.getResultList();
	}
	
	public List<Produto> buscaPorNomeCategoria(String nome){
		String jpql = "SELECT p FROM Produto p WHERE p.categoria.nome = :nome";
		return this.em.createQuery(jpql, Produto.class)
				.setParameter("nome", nome)
				.getResultList();
	}
	
	public String buscaProdutoComNome(String nome){
		String jpql = "SELECT p.nome FROM Produto p WHERE p.nome = :nome";
		return this.em.createQuery(jpql, String.class)
				.setParameter("nome", nome)
				.getSingleResult();
	}
}
