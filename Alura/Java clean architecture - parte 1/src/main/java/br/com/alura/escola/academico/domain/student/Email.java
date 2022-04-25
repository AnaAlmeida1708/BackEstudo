package br.com.alura.escola.academico.domain.student;

public class Email {
	
	//VALUE OBJECT - VO
	
	private String email;

	public Email(String email) {
		if(email == null ||
				!email.matches("^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@"
				        + "[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$")) {
			throw new IllegalArgumentException("Invalid email");
		}
		this.email = email;
	}
	
	public String getEmail() {
		return email;
	}
	

}
