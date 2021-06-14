package br.com.alura.loja.orcamento;

import java.util.HashMap;
import java.util.Map;

import br.com.alura.loja.exception.DomainException;
import br.com.alura.loja.http.HttpAdapter;

public class RegistroDeOrcamento {
	
	private HttpAdapter http;

	public RegistroDeOrcamento(HttpAdapter http) {
		this.http = http;
	}
	
	public void registrarOrcamento(Orcamento orcamento) {
		if(!orcamento.isFinalizado()) {
			throw new DomainException("Orcamento não finalizado!");
		}
		
		String url = "teste";
		Map<String, Object> dados = new HashMap<String, Object>();
		dados.put("valor", orcamento.getValor());
		dados.put("quantidade", orcamento.getQuantidadeDeItens());
		
		http.post(url, dados);
	}

}
