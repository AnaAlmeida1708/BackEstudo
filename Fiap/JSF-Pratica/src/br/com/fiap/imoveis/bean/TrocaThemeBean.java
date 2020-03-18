package br.com.fiap.imoveis.bean;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import br.com.fiap.imoveis.entity.Theme;
import br.com.fiap.imoveis.service.ThemePreferenceService;

@SessionScoped
@ManagedBean
public class TrocaThemeBean {
	
	//atributo com a lista de temas
	private List<Theme> themes;
	//Atributo com o nome do tema corrente
	private String theme;
	private ThemePreferenceService tp;
	
	public String getTheme() {
		return theme;
	}
	public void setTheme(String theme) {
		this.theme = theme;
	}
	public List<Theme> getThemes() {
		return themes;
	}
	@PostConstruct
	public void init() {
		tp = new ThemePreferenceService();
		//Busca no service todos os temas carregados do json
		themes = tp.getThemes();
		//Busca do service o tema default
		theme = tp.getTheme();
	}
	
	public void saveTheme() {
		tp.setTheme(theme);
	}
}
