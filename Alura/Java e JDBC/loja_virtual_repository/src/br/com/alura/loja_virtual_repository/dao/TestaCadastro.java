package br.com.alura.loja_virtual_repository.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class TestaCadastro {

	public static void main(String[] args) throws SQLException {
		ConnectionFactory connectionFactory = new ConnectionFactory();
		Connection connection = connectionFactory.recuperaConexao();
		
		Statement stm = connection.createStatement();
		stm.execute(" INSERT INTO PRODUTO (NOME,DESCRICAO) VALUES ('CADEIRA', 'CADEIRA GAMER')" , Statement.RETURN_GENERATED_KEYS);
		 ResultSet rs = stm.getGeneratedKeys();
		
		 while (rs.next()) {
			Integer id = rs.getInt(1);
			System.out.println(id);
		}
		 
		 
		connection.close();

	}

}
