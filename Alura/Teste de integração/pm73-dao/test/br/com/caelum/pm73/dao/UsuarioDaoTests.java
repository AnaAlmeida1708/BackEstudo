package br.com.caelum.pm73.dao;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

import org.hibernate.Session;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import br.com.caelum.pm73.dominio.Usuario;

public class UsuarioDaoTests {
	
	private Session session;
	private UsuarioDao usuarioDao;
	
	@Before
	public void antes() {
		session = new CriadorDeSessao().getSession();
		usuarioDao = new UsuarioDao(session);
	}
	
	@After
	public void depois() {
		session.close();
	}
	
	
	@Test
	public void deveEncontrarPeloNomeEEmail() {
		//Inserimos um usuário no banco para teste
		Usuario novoUsuario = new Usuario("Higor do Carmo", "higor@gmail.com");
		usuarioDao.salvar(novoUsuario);
		
		//busca o usuário criado no banco
		Usuario usuario = usuarioDao.porNomeEEmail("Higor do Carmo", "higor@gmail.com");
		
		assertEquals("Higor do Carmo", usuario.getNome());
		assertEquals("higor@gmail.com", usuario.getEmail());
		
	}
	
	@Test
	public void deveRetornarNullSeNaoAcharUsuario() {
		//busca o usuário criado no banco
		Usuario usuario = usuarioDao.porNomeEEmail("Fabio Araujo", "fabio@gmail.com");
		
		assertNull(usuario);
		
	}

}
