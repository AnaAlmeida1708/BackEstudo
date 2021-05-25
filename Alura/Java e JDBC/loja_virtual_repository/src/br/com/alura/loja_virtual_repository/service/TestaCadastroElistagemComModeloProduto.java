package br.com.alura.loja_virtual_repository.service;

import java.sql.Connection;
import java.util.List;

import br.com.alura.loja_virtual_repository.dao.ConnectionFactory;
import br.com.alura.loja_virtual_repository.dao.ProdutoDAO;
import br.com.alura.loja_virtual_repository.model.Produto;

public class TestaCadastroElistagemComModeloProduto {

	public static void main(String[] args) throws Exception {

		Produto produto = new Produto();
		produto.setNome("MONITOR");
		produto.setDescricao("MONITOR 24 POLEGADAS");

		try(Connection connection = new ConnectionFactory().recuperaConexao()) {
			ProdutoDAO produtoDAO = new ProdutoDAO(connection); 
			produtoDAO.salvar(produto);
			List<Produto> produtos = produtoDAO.listar();
			produtos.forEach(p -> System.out.println(p));

		} catch (Exception e) {
			throw new Exception("Erro ao recuperar conexão com o banco de dados");
		}

	}

}
