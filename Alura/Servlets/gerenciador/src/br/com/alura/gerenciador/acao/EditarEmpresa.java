package br.com.alura.gerenciador.acao;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.alura.gerenciador.model.Banco;

public class EditarEmpresa implements Acao {
	
	public String executa(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String nomeEmpresa = request.getParameter("nome");
		String data = request.getParameter("dataAbertura");
		String id = request.getParameter("id");
		Integer idEmpresa = Integer.parseInt(id);
		
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		Date dataAbertura = null;
		try {
			 dataAbertura = sdf.parse(data);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		
		Banco banco = new Banco();
		banco.atualizaEmpresa(nomeEmpresa, dataAbertura, idEmpresa);
		
		return "redirect:empresa?acao=ListaEmpresas";
	}
}
