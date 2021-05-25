package br.com.alura.loja_virtual_repository.service;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import br.com.alura.loja_virtual_repository.dao.ConnectionFactory;

public class TestaCadastro {

	public static void main(String[] args) throws SQLException {
		ConnectionFactory connectionFactory = new ConnectionFactory();
		try(Connection connection = connectionFactory.recuperaConexao()){//Desta forma como a classe em questão implementa AutoCloseable o recurso será fechado automaticamente, independente se der erro
			connection.setAutoCommit(false);

			try(PreparedStatement stm = connection.prepareStatement(" INSERT INTO PRODUTO (NOME,DESCRICAO) VALUES (?, ?)" , Statement.RETURN_GENERATED_KEYS)) {

				adicionarProduto("ROTEADOR", "ROTEADOR", stm);
				adicionarProduto("SSD", "SSD 1T", stm);

				connection.commit();

			} catch (Exception e) {
				e.printStackTrace();
				System.out.println("Fazendo Rollback");
				connection.rollback();
			} 

		}
	}

	private static void adicionarProduto(String nome, String descricao, PreparedStatement stm) throws SQLException {
		//		if(nome.equals("SSD")) {
		//			throw new RuntimeException("Erro ao cadastrar produto " + nome);
		//		}

		stm.setString(1, nome);
		stm.setString(2, descricao);

		stm.execute();
		try(ResultSet rs = stm.getGeneratedKeys()){

			while (rs.next()) {
				Integer id = rs.getInt(1);
				System.out.println(id);
			}
		}
	}

}
