package br.com.alura.loja_virtual_repository.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.com.alura.loja_virtual_repository.model.Produto;

public class TestaListagem {

	public static void main(String[] args) throws SQLException {
		ConnectionFactory connectionFactory = new ConnectionFactory();
		Connection connection = connectionFactory.recuperaConexao();

		PreparedStatement stm = connection.prepareStatement(" SELECT * FROM PRODUTO ");
		stm.execute();

		ResultSet rs = stm.getResultSet();

		List<Produto> produtos = new ArrayList<Produto>();
		while (rs.next()) {
			Produto produto = new Produto();
			produto.setId(rs.getInt("ID"));
			produto.setNome(rs.getString("NOME"));
			produto.setDescricao(rs.getString("descricao"));

			produtos.add(produto);
		}

		produtos.forEach(p -> System.out.println(p));

		System.out.println("Fechando conexão!");
		connection.close();
	}

}
