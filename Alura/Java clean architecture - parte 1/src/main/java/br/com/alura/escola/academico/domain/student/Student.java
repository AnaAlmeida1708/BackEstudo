package br.com.alura.escola.academico.domain.student;

import java.util.ArrayList;
import java.util.List;

//AGREGATE ROOT
public class Student {
	
	//ENTITY
	
	private String name;
	private CPF cpf;
	private Email email;
	private List<Phone> phones = new ArrayList<>();
	private String password;
	
	public void addPhone(String ddd, String number) {
		if(this.phones.size() == 2) {
			throw new IllegalArgumentException("Max phones");
		}
		this.phones.add(new Phone(ddd, number));
	}

	public Student(String name, CPF cpf, Email email) {
		this.name = name;
		this.cpf = cpf;
		this.email = email;
	}

	public String getName() {
		return name;
	}

	public String getCpf() {
		return cpf.getCpf();
	}

	public String getEmail() {
		return email.getEmail();
	}

	public List<Phone> getPhones() {
		return phones;
	}
	
	

}
