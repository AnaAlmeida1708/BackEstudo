package br.com.alura.loja_virtual_repository.dao;

import java.sql.Connection;
import java.sql.SQLException;

import javax.sql.DataSource;

import com.mchange.v2.c3p0.ComboPooledDataSource;

public class ConnectionFactory {
	
	public DataSource dataSource;
	
		public ConnectionFactory() {
			ComboPooledDataSource comboPooledDataSource = new ComboPooledDataSource();
			comboPooledDataSource.setJdbcUrl("jdbc:mysql://localhost/loja_virtual?useTimezone=true&serverTimezone=UTC");
			comboPooledDataSource.setUser("root");
			comboPooledDataSource.setPassword("rosa");
			comboPooledDataSource.setMaxPoolSize(15);
			this.dataSource = comboPooledDataSource;
		}
	
		public Connection recuperaConexao() throws SQLException {
			 Connection connection = this.dataSource.getConnection();
			 return connection;
		}

}
