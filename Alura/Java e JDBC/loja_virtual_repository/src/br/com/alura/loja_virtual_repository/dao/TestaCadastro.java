package br.com.alura.loja_virtual_repository.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class TestaCadastro {

	public static void main(String[] args) throws SQLException {
		ConnectionFactory connectionFactory = new ConnectionFactory();
		Connection connection = connectionFactory.recuperaConexao();
		
		String nome = "TECLADO";
		String descricao = "TECLADO SEM FIO";
		
		PreparedStatement stm = connection.prepareStatement(" INSERT INTO PRODUTO (NOME,DESCRICAO) VALUES (?, ?)" , Statement.RETURN_GENERATED_KEYS);
		
		stm.setString(1, nome);
		stm.setString(2, descricao);
		
		stm.execute();
		 ResultSet rs = stm.getGeneratedKeys();
		
		 while (rs.next()) {
			Integer id = rs.getInt(1);
			System.out.println(id);
		}
		 
		 
		connection.close();

	}

}
