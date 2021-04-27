package br.com.alura.validacao;

import java.io.IOException;

import com.github.gilbertotorrezan.viacep.se.ViaCEPClient;
import com.github.gilbertotorrezan.viacep.shared.ViaCEPEndereco;

public class CEP {
	
	public static void main(String[] args) {
		buscaEnderecoCompleto("05565190");
		
	}
	
	public static void buscaEnderecoCompleto(String cep) {
		ViaCEPClient cliente = new ViaCEPClient();
		try {
			ViaCEPEndereco endereco = cliente.getEndereco(cep);
			System.out.println("Cep : " + endereco.getCep());
			System.out.println("Logradouro : " + endereco.getLogradouro());
			System.out.println("Complemento : " + endereco.getComplemento());
			System.out.println("Bairro : " + endereco.getBairro());
			System.out.println("Localidade : " + endereco.getLocalidade());
			System.out.println("UF : " + endereco.getUf());
		} catch (IOException e) {
			e.getMessage();
		}
	}
	
}
