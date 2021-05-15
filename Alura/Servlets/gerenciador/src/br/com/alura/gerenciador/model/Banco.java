package br.com.alura.gerenciador.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

public class Banco {
	
	private static List<Empresa> empresas = new ArrayList<Empresa>();
	private static List<Usuario> listaUsuarios= new ArrayList<>();
	
	static {
		Empresa empresa1 = new Empresa("Alura", "03/05/2003");
		Empresa empresa2 = new Empresa("Caellum", "27/07/2008");
		Empresa empresa3 = new Empresa("Marketdata", "07/06/2002");
		Banco.empresas.add(empresa1);
		Banco.empresas.add(empresa2);
		Banco.empresas.add(empresa3);
		
		Usuario u1 = new Usuario();
	    u1.setLogin("Ana");
	    u1.setSenha("1234");

	    Usuario u2 = new Usuario();
	    u2.setLogin("Higor");
	    u2.setSenha("4321");

	    listaUsuarios.add(u1);
	    listaUsuarios.add(u2);
		
	}
	
	public void adiciona(Empresa empresa) {
		Banco.empresas.add(empresa);
	}
	
	public List<Empresa> getEmpresas(){
		return Banco.empresas;
	}

	public void removeEmpresa(Integer idEmpresa) {
		Iterator<Empresa> it = empresas.iterator();

	    while(it.hasNext()) { 
	        Empresa emp = it.next();

	        if(emp.getId() == idEmpresa ) {
	            it.remove();
	        }
	    }
		
	}

	public Empresa buscaEmpresaPorId(Integer id) {
		for (Empresa empresa : empresas) {
			if(empresa.getId() == id)
				return empresa;
		}
	return null;
	}

	public void atualizaEmpresa(String nome, Date dataAbertura, Integer id) {
		Empresa empresa = buscaEmpresaPorId(id);
		empresa.setNome(nome);
		empresa.setDataAbertura(dataAbertura);
	}
	
	public Usuario existeUsuario(String senha, String login) {
		for (Usuario usuario : listaUsuarios) {
			if(usuario.ehIgual(login, senha)) {
				return usuario;
			}
		}
		return null;
	}

}
