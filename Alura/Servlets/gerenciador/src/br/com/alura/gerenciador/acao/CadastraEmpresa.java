package br.com.alura.gerenciador.acao;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.alura.gerenciador.model.Banco;
import br.com.alura.gerenciador.model.Empresa;

public class CadastraEmpresa implements Acao{
	
	public String executa(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String nomeEmpresa = request.getParameter("nome");
		String data = request.getParameter("dataAbertura");

		
		Empresa empresa = new Empresa(nomeEmpresa, data);
		Banco banco = new Banco();
		banco.adiciona(empresa);
		
		return "redirect:empresa?acao=ListaEmpresas";
	}

}
