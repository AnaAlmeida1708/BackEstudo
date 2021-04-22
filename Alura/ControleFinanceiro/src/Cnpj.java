
public class Cnpj {
	private String valor;
	
	public boolean ehValido() {
		return primeiroDigitoVerificador() == primeiroDigitoCorreto()
				&& segundoDigitoVerificador() == segundoDigitoCorreto();
	}
	
	private int primeiroDigitoCorreto() {
		return 1;
	}
	
	private int primeiroDigitoVerificador() {
		return 1;
	}
	
	private int segundoDigitoCorreto() {
		return 2;
	}
	
	private int segundoDigitoVerificador() {
		return 2;
	}
	
	public String getValor() {
		return valor;
	}

    public boolean equals(Object o) {
        if(!(o instanceof Cnpj)) {
            return false;
        } 
        Cnpj outro = (Cnpj) o;
        return this.valor.equals(outro.valor); // delegamos a comparação de dois Cnpj para seus atributos valor
    }
	
    public int hashCode() {
        return this.valor.hashCode(); // delegamos a geracao do hashCode da classe Cnpj para seu atributo String valor
    }
	
	
}
