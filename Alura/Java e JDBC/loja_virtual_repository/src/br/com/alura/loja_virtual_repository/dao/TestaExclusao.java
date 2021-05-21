package br.com.alura.loja_virtual_repository.dao;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

public class TestaExclusao {
	
	public static void main(String[] args) throws SQLException {
		
		ConnectionFactory connectionFactory = new ConnectionFactory();
		Connection connection = connectionFactory.recuperaConexao();
		
		Statement stm = connection.createStatement();
		stm.execute(" DELETE FROM PRODUTO WHERE ID=5");
		
		Integer linhasModificadas = stm.getUpdateCount();
		
		System.out.println(linhasModificadas);
		
		connection.close();
	}

}
