package br.com.alura.loja_virtual_repository.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import br.com.alura.loja_virtual_repository.model.Categoria;
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
	
	//SELECT P.ID,P.NOME,P.DESCRICAO,P.CATEGORIA_ID, C.NOME CATEGORIA FROM PRODUTO P INNER JOIN CATEGORIA C ON C.ID = P.CATEGORIA_ID;
	public List<Produto> listar() throws SQLException{
		try(PreparedStatement stm = connection.prepareStatement(" SELECT P.ID,P.NOME,P.DESCRICAO,P.CATEGORIA_ID, C.NOME CATEGORIA FROM PRODUTO P INNER JOIN CATEGORIA C ON C.ID = P.CATEGORIA_ID; ")){
			stm.execute();

			ResultSet rs = stm.getResultSet();

			List<Produto> produtos = new ArrayList<Produto>();
			while (rs.next()) {
				Categoria categoria = new Categoria();
				categoria.setId(rs.getInt("CATEGORIA_ID"));
				categoria.setNome(rs.getString("CATEGORIA"));
				
				Produto produto = new Produto();
				produto.setId(rs.getInt("ID"));
				produto.setNome(rs.getString("NOME"));
				produto.setDescricao(rs.getString("descricao"));
				produto.setCategoria(categoria);

				produtos.add(produto);
			}

			return produtos;
		}
	}


}
