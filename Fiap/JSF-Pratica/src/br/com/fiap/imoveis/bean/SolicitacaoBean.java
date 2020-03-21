package br.com.fiap.imoveis.bean;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import javax.annotation.PostConstruct;
import javax.enterprise.context.RequestScoped;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import br.com.fiap.imoveis.entity.Solicitacao;
import javax.inject.Named;

@Named
@RequestScoped
public class SolicitacaoBean {
	
	private Solicitacao solicitacao;
	private Locale locale;
	
	@PostConstruct // Inicializando os atributos
	private void init() {
		solicitacao = new Solicitacao();
	}
	
	public void cadastrar() {
		System.out.println("Cidade " + solicitacao.getCidade());
		System.out.println("Valor: " + solicitacao.getValor());
		System.out.println("Desc: " + solicitacao.getDescricao());
		System.out.println("Senha: " + solicitacao.getSenha());
		System.out.println("Novo: " + solicitacao.isNovo());
		
		System.out.println(solicitacao.getItens());
		System.out.println(solicitacao.getComodos());
		System.out.println(solicitacao.getTipo());
		System.out.println(solicitacao.getFinalidade());
		System.out.println(solicitacao.getOperacao());
		System.out.println(solicitacao.getEmail());
		
		// Mensagem que será associada ao componente h:h:messages – Por ser uma simulação, não está internacionalizado
		FacesMessage msg = new FacesMessage("Imóvel Cadastrado!");
				//Adiciona a menssagem na instância corrente da solicitação
				FacesContext.getCurrentInstance().addMessage(null,msg);
	}
	//Navega para a tela home
	public String navegarHome() {
		return "index?faces-redirect=true";
	}
	//Retorna true se a linguagem for pt
	//Novamente utilizamos o contexto, agora para obter o Locale
	private boolean getLocalePt() {
		locale =
				FacesContext.getCurrentInstance().getViewRoot().getLocale();
		return
				locale.getLanguage().toString().equals("pt");
	}
	//Retorna uma lista de tipos para a página xhtml, tratando internacionalização
	public List<String> getTipos() {
		List<String> lista = new ArrayList<String>();
		if (getLocalePt()) {
			lista.add("Casa");
			lista.add("Apartamento");
			lista.add("Armazém");
			lista.add("Sitio");
			lista.add("Fazenda");
		} else {
			lista.add("House");
			lista.add("Apartment");
			lista.add("Warehouse");
			lista.add("Rural");
			lista.add("Farm");
		}
		return lista;
	}
	//Retorna uma lista de comodos para a página xhtml, tratando internacionalização
	public List<String> getListaComodos() {List<String> lista = new ArrayList<String>();
	if (getLocalePt()) {
		lista.add("Quarto");
		lista.add("Sala");
		lista.add("Cozinha");
		lista.add("Banheiro");
		lista.add("Varanda");
	} else {
		lista.add("Bedroom");
		lista.add("Living room");
		lista.add("Kitchen");
		lista.add("Bathroom");
		lista.add("Balcony");
	}
	return lista;
	}
	
	public Solicitacao getSolicitacao() {
		return solicitacao;
	}
	public void setSolicitacao(Solicitacao solicitacao) {
		this.solicitacao = solicitacao;
	}
}
