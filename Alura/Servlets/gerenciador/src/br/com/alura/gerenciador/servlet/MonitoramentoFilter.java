package br.com.alura.gerenciador.servlet;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;


//@WebFilter("/empresa")
public class MonitoramentoFilter implements Filter {

	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		
		System.out.println("Executanto MonitoramentoFilter");
		
		Long inicio = System.currentTimeMillis();
		chain.doFilter(request, response);
		Long fim = System.currentTimeMillis();
		
		String acao = request.getParameter("acao");
		
		System.out.println("Tempo de execução ação : " + acao + " = " +  (fim - inicio));
	}



}
