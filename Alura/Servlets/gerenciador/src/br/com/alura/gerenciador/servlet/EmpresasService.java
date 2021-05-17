package br.com.alura.gerenciador.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;
import com.thoughtworks.xstream.XStream;

import br.com.alura.gerenciador.model.Banco;
import br.com.alura.gerenciador.model.Empresa;

@WebServlet("/empresas")
public class EmpresasService extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {


		Banco banco = new Banco();
		List<Empresa> empresas = banco.getEmpresas();
		String valor = request.getHeader("Accept");

		if(valor.endsWith("json")) {
			Gson gson = new Gson();
			String json = gson.toJson(empresas);  

			System.out.println(json);

			response.setContentType("application/json");
			response.getWriter().print(json);
		} else if (valor.endsWith("xml") || valor.contains("xml")) {
			XStream xstream = new XStream();
			xstream.alias("empresa", Empresa.class);
			String xml = xstream.toXML(empresas);

			System.out.println(xml);

			response.setContentType("application/xml");
			response.getWriter().print(xml);
		}

	}

}
