package br.com.alura.loja_virtual_repository.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import br.com.alura.loja_virtual_repository.model.Produto;

public class ProdutoDAO {

	private Connection connection;

	public ProdutoDAO(Connection connection) {
		this.connection = connection;
	}

	public void salvar (Produto produto) throws SQLException {

		String sql = " INSERT INTO PRODUTO (NOME, DESCRICAO) VALUES (?,?) ";

		try(PreparedStatement stm = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {
			stm.setString(1, produto.getNome());
			stm.setString(2, produto.getDescricao());

			stm.execute();

			try(ResultSet rs = stm.getGeneratedKeys()){

				while (rs.next()) {
					Integer id = rs.getInt(1);
					System.out.println(id);
				}
			}
		} 

	}
	
	public List<Produto> listar() throws SQLException{
		try(PreparedStatement stm = connection.prepareStatement(" SELECT * FROM PRODUTO ")){
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

			return produtos;
		}
	}


}
