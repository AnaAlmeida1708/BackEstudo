package br.com.alura.springdata.orm;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

@Entity
@Table(name = "unidade_trabalho")
public class UnidadeTrabalho {
	
	@Id
	@GeneratedValue (strategy = GenerationType.IDENTITY)
	private Integer id;
	private String nome;
	private String endereco;
	
	@ManyToMany(mappedBy = "unidadeTrabalhos", fetch = FetchType.EAGER)//Nome conforme java
	private List<Funcionario> funcionarios;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getEndereco() {
		return endereco;
	}

	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}

	@Override
	public String toString() {
		return "UnidadeTrabalho [" + (id != null ? "id=" + id + ", " : "")
				+ (nome != null ? "nome=" + nome + ", " : "")
				+ (endereco != null ? "endereco=" + endereco + ", " : "")
				+"]";
	}


}
