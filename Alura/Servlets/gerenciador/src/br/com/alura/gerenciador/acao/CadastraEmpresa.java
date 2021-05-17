package br.com.alura.gerenciador.acao;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.alura.gerenciador.model.Banco;
import br.com.alura.gerenciador.model.Empresa;

public class CadastraEmpresa implements Acao{
	
	public String executa(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String nomeEmpresa = request.getParameter("nome");
		String dataString = request.getParameter("dataAbertura");
		Date data = null;
		
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		try {
			data = sdf.parse(dataString);
		} catch (ParseException e) {
			e.printStackTrace();
		};

		Empresa empresa = new Empresa(nomeEmpresa, data);
		Banco banco = new Banco();
		banco.adiciona(empresa);
		
		return "redirect:empresa?acao=ListaEmpresas";
	}

}
