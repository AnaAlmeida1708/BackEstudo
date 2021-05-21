package br.com.alura.loja_virtual_repository.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import br.com.alura.loja_virtual_repository.model.Produto;

public class TestaConexao {

	public static void main(String[] args) throws SQLException {
			Connection connection = DriverManager
					.getConnection("jdbc:mysql://localhost/loja_virtual?useTimezone=true&serverTimezone=UTC","root", "rosa");

			System.out.println("Fechando conexão!");
			connection.close();
	}

}
