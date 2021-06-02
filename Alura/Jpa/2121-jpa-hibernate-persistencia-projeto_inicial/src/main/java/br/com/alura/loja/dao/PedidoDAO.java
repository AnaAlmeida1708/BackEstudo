package br.com.alura.loja.dao;

import java.math.BigDecimal;
import java.util.List;

import javax.persistence.EntityManager;

import br.com.alura.loja.model.Pedido;
import br.com.alura.loja.model.RelatorioDeVendasVo;

public class PedidoDAO {
	
	private EntityManager em;

	public PedidoDAO(EntityManager em) {
		this.em = em;
	}
	
	public void cadastrar(Pedido pedido) {
		this.em.persist(pedido);
	}
	
	public Pedido buscarPorId(Long id) {
		return this.em.find(Pedido.class, id);
	}
	
	public BigDecimal somaValorTotalPedidos() {
		String jpql = "SELECT SUM(p.valorTotal) FROM Pedido p";
		return em.createQuery(jpql, BigDecimal.class)
				.getSingleResult();
	}
	
	public List<RelatorioDeVendasVo> getRelatorioVendas(){
		String jpql = "SELECT new br.com.alura.loja.model.RelatorioDeVendasVo (produto.nome, SUM(item.quantidade), MAX(pedido.data)) "
				+ " FROM Pedido pedido "
				+ " JOIN pedido.itens item "
				+ " JOIN item.produto produto "
				+ " GROUP BY produto.nome, item.quantidade,pedido.data  "
				+ " ORDER BY item.quantidade DESC";
		return em.createQuery(jpql, RelatorioDeVendasVo.class)
				.getResultList();
	}
	
	
}
