package br.com.alura.loja_virtual_repository.service;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import br.com.alura.loja_virtual_repository.dao.ConnectionFactory;

public class TestaExclusao {
	
	public static void main(String[] args) throws SQLException {
		
		ConnectionFactory connectionFactory = new ConnectionFactory();
		Connection connection = connectionFactory.recuperaConexao();
		
		Integer id = 7;
		
		PreparedStatement stm = connection.prepareStatement(" DELETE FROM PRODUTO WHERE ID=? ");
		stm.setInt(1, id);
		stm.execute();
		
		Integer linhasModificadas = stm.getUpdateCount();
		
		System.out.println(linhasModificadas);
		
		connection.close();
	}

}
