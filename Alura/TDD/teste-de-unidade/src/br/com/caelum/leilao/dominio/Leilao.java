package br.com.caelum.leilao.dominio;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Leilao {

	private String descricao;
	private List<Lance> lances;
	
	public Leilao(String descricao) {
		this.descricao = descricao;
		this.lances = new ArrayList<Lance>();
	}
	
	public void propoe(Lance lance) {
		if(lances.isEmpty() || podeDarLance(lance.getUsuario())) {
			lances.add(lance);
		}
	}

	public String getDescricao() {
		return descricao;
	}

	public List<Lance> getLances() {
		return Collections.unmodifiableList(lances);
	}

	public Lance ultimoLance() {
		return lances.get(lances.size()-1);
	}
	
	private boolean podeDarLance(Usuario usuario) {
		return !ultimoLance().getUsuario().equals(usuario) && quantidadeDeLancesDoUsuario(usuario) < 5;
	}

	private int quantidadeDeLancesDoUsuario(Usuario usuario) {
		int total = 0;
		for(Lance lance : lances) {
			if(usuario.equals(lance.getUsuario())) {
				total ++;
			}
		}
		return total;
	}

	public void dobraLance(Usuario usuario) {
		Lance ultimoLance = ultimoLanceDo(usuario);
		if(ultimoLance != null) {
			propoe(new Lance(usuario, ultimoLance.getValor()*2));
		}
		
	}

	public Lance ultimoLanceDo(Usuario usuario) {
		Lance ultimo = null;
		for(Lance lance : lances) {
			if(lance.getUsuario().equals(usuario)) {
				ultimo = lance;
			}
		}
		return ultimo;
	}
}
