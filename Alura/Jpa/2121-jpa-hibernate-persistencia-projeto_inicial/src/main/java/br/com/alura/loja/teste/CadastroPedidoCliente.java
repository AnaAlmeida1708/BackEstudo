package br.com.alura.loja.teste;

import java.math.BigDecimal;
import java.util.List;

import javax.persistence.EntityManager;

import br.com.alura.loja.dao.ClienteDAO;
import br.com.alura.loja.dao.PedidoDAO;
import br.com.alura.loja.dao.ProdutoDAO;
import br.com.alura.loja.model.Cliente;
import br.com.alura.loja.model.ItemPedido;
import br.com.alura.loja.model.Pedido;
import br.com.alura.loja.model.Produto;
import br.com.alura.loja.model.RelatorioDeVendasVo;
import br.com.alura.loja.util.JpaUtil;

public class CadastroPedidoCliente {
	
	public static void main(String[] args) {
		EntityManager em = new JpaUtil().getEntityManager();
		
		ProdutoDAO produtoDAO = new ProdutoDAO(em);
		Produto produto1 = produtoDAO.buscarPorId(1l);
		Produto produto2 = produtoDAO.buscarPorId(2l);
		Produto produto3 = produtoDAO.buscarPorId(3l);
		
		ClienteDAO clienteDAO = new ClienteDAO(em);
		Cliente cliente = clienteDAO.buscarPorId(1l);
		
		PedidoDAO pedidoDAO = new PedidoDAO(em);
		Pedido pedido1 = new Pedido(cliente);
		pedido1.adicionarItem(new ItemPedido(2, pedido1, produto1));
		Pedido pedido2 = new Pedido(cliente);
		pedido2.adicionarItem(new ItemPedido(5, pedido2, produto2));
		Pedido pedido3 = new Pedido(cliente);
		pedido3.adicionarItem(new ItemPedido(10, pedido3, produto3));
		
		em.getTransaction().begin();
		pedidoDAO.cadastrar(pedido1);
		pedidoDAO.cadastrar(pedido2);
		pedidoDAO.cadastrar(pedido3);
		
		em.getTransaction().commit();
		
		BigDecimal valorTotalPedidos = pedidoDAO.somaValorTotalPedidos();
		System.out.println("Valor total de pedidos: " + valorTotalPedidos);
		
		List<RelatorioDeVendasVo> relatorio = pedidoDAO.getRelatorioVendas();
		relatorio.forEach(r -> System.out.println(r));
				
		em.close();
		
	}
	

	

}
