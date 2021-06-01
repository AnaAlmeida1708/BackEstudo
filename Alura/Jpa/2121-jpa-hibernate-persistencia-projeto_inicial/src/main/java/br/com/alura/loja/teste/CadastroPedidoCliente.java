package br.com.alura.loja.teste;

import javax.persistence.EntityManager;

import br.com.alura.loja.dao.ClienteDAO;
import br.com.alura.loja.dao.PedidoDAO;
import br.com.alura.loja.dao.ProdutoDAO;
import br.com.alura.loja.model.Cliente;
import br.com.alura.loja.model.ItemPedido;
import br.com.alura.loja.model.Pedido;
import br.com.alura.loja.model.Produto;
import br.com.alura.loja.util.JpaUtil;

public class CadastroPedidoCliente {
	
	public static void main(String[] args) {
		EntityManager em = new JpaUtil().getEntityManager();
		
		ProdutoDAO produtoDAO = new ProdutoDAO(em);
		Produto produto = produtoDAO.buscarPorId(1l);
		
		ClienteDAO clienteDAO = new ClienteDAO(em);
		Cliente cliente = clienteDAO.buscarPorId(1l);
		
		PedidoDAO pedidoDAO = new PedidoDAO(em);
		Pedido pedido = new Pedido(cliente);
		pedido.adicionarItem(new ItemPedido(2, pedido, produto));
		
		em.getTransaction().begin();
		pedidoDAO.cadastrar(pedido);
		
		em.getTransaction().commit();
		
		Pedido pedidoCadastrado = pedidoDAO.buscarPorId(1l);
		System.out.println(pedidoCadastrado);
		em.close();
		
	}
	

	

}
