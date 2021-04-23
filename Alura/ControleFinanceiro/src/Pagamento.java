import java.util.Calendar;

public class Pagamento {
	private String pagador;
	private String documentoPagador;
	private Double valor;
	private Calendar data;

	public String getPagador() {
		return pagador;
	}
	public void setPagador(String pagador) {
		this.pagador = pagador;
	}
	public String getDocumentoPagador() {
		return documentoPagador;
	}
	public void setDocumentoPagador(String documentoPagador) {
		this.documentoPagador = documentoPagador;
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
