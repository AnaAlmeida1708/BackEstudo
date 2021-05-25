package br.com.alura.loja_virtual_repository.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.com.alura.loja_virtual_repository.model.Categoria;

public class CategoriaDAO {
	
	private Connection connection;

	public CategoriaDAO(Connection connection) {
		this.connection = connection;
	}
	
	public List<Categoria> listar() throws SQLException{
		try(PreparedStatement stm = connection.prepareStatement(" SELECT * FROM CATEGORIA ")){
			stm.execute();

			ResultSet rs = stm.getResultSet();

			List<Categoria> categorias = new ArrayList<Categoria>();
			while (rs.next()) {
				Categoria categoria = new Categoria();
				categoria.setId(rs.getInt("ID"));
				categoria.setNome(rs.getString("NOME"));

				categorias.add(categoria);
			}

			return categorias;
		}
	}


}
