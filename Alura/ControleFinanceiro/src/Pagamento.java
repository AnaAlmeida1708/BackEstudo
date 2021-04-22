import java.util.Calendar;

public class Pagamento {
	private String pagador;
	private String cnpjPagador;
	private Double valor;
	private Calendar data;

	public String getPagador() {
		return pagador;
	}
	public void setPagador(String pagador) {
		this.pagador = pagador;
	}
	public String getCnpjPagador() {
		return cnpjPagador;
	}
	public void setCnpjPagador(String cnpjPagador) {
		this.cnpjPagador = cnpjPagador;
	}
	public Double getValor() {
		return valor;
	}
	public void setValor(Double valor) {
		this.valor = valor;
	}
	public Calendar getData() {
		return data;
	}
	public void setData(Calendar data) {
		this.data = data;
	}

	
	
}
