package br.com.alura.loja_virtual_repository.service;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import br.com.alura.loja_virtual_repository.dao.CategoriaDAO;
import br.com.alura.loja_virtual_repository.dao.ConnectionFactory;
import br.com.alura.loja_virtual_repository.model.Categoria;

public class TestaListagemCategoria {

	public static void main(String[] args) throws SQLException {
		try(Connection connection = new ConnectionFactory().recuperaConexao()){
			
			CategoriaDAO categoriaDAO = new CategoriaDAO(connection);
			List<Categoria> categorias = categoriaDAO.listar();
			categorias.forEach(c -> System.out.println(c));
			
		}

	}

}
