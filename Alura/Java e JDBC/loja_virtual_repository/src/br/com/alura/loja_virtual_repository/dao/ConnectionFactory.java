package br.com.alura.loja_virtual_repository.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionFactory {
	
		public Connection recuperaConexao() throws SQLException {
			 Connection connection = DriverManager
					.getConnection("jdbc:mysql://localhost/loja_virtual?useTimezone=true&serverTimezone=UTC","root", "rosa");
			 
			 return connection;
		}

}
