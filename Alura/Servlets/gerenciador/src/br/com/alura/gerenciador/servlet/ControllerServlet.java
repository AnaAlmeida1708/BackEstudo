package br.com.alura.gerenciador.servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import br.com.alura.gerenciador.acao.Acao;

@WebServlet("/empresa")
public class ControllerServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	

	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		String paramAcao = request.getParameter("acao"); 

		String nomeDaClasse = "br.com.alura.gerenciador.acao." + 
	            paramAcao;
		
		HttpSession sessao = request.getSession();
		Boolean usuarioIsLogado = sessao.getAttribute("usuario") != null;
		Boolean ehUmaAcaoProtegida = paramAcao.equals("Login") || paramAcao.equals("LoginForm");
		if(!usuarioIsLogado && !ehUmaAcaoProtegida) {
			response.sendRedirect("empresa?acao=LoginForm");
			return;
		}

	        String nome;
	        try {
	            Class classe = Class.forName(nomeDaClasse); 
	            Acao acao = (Acao) classe.newInstance();
	            nome = acao.executa(request,response);
	        } catch (ClassNotFoundException | 
	                InstantiationException | 
	                IllegalAccessException e) {
	            throw new ServletException(e);
	        }

	        String[] tipoEEndereco = nome.split(":");
	        if(tipoEEndereco[0].equals("forward")) {
	            RequestDispatcher rd = 
	                request.getRequestDispatcher("WEB-INF/view/" + tipoEEndereco[1]);
	            rd.forward(request, response);
	        } else {
	            response.sendRedirect(tipoEEndereco[1]);
	        } 

	}
	
}
