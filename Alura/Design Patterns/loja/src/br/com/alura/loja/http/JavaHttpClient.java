package br.com.alura.loja.http;

import java.util.Map;

public class JavaHttpClient implements HttpAdapter {

	@Override
	public void post(String url, Map<String, Object> dados) {
		System.out.println("La la la la configura��o para chamada api externa");
	}

}
