package br.com.alura.gerenciador.servlet;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

//@WebFilter("/empresa")
public class AutorizacaoFilter implements Filter {

	
	public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain chain) throws IOException, ServletException {
		
		System.out.println("Executanto AutorizacaoFilter");
		
		HttpServletRequest request = (HttpServletRequest) servletRequest;
		HttpServletResponse response = (HttpServletResponse) servletResponse;
		
		String paramAcao = request.getParameter("acao"); 
		HttpSession sessao = request.getSession();
		Boolean usuarioIsLogado = sessao.getAttribute("usuario") != null;
		Boolean ehUmaAcaoProtegida = paramAcao.equals("Login") || paramAcao.equals("LoginForm");
		if(!usuarioIsLogado && !ehUmaAcaoProtegida) {
			response.sendRedirect("empresa?acao=LoginForm");
			return;
		}
		chain.doFilter(request, response);
	}


}
