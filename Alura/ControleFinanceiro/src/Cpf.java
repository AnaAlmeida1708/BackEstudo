
public class Cpf implements Documento{
	private String valor;
	

	public Cpf(String valor) {
		super();
		this.valor = valor;
	}
	
	public Cpf() {
	}

	public boolean ehValido() {
		return true;
	}
	
	public String getValor() {
		return valor;
	}

    public boolean equals(Object o) {
        if(!(o instanceof Cpf)) {
            return false;
        } 
        Cpf outro = (Cpf) o;
        return this.valor.equals(outro.valor); 
    }
	
    public int hashCode() {
        return this.valor.hashCode(); 
    }

	@Override
	public String toString() {
		return this.valor;
	}
	
	
}
