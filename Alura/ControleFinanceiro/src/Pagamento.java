import java.util.Calendar;

public class Pagamento {
	private String pagador;
	private Documento documentoPagador;
	private Double valor;
	private Calendar data;

	public String getPagador() {
		return pagador;
	}
	public void setPagador(String pagador) {
		this.pagador = pagador;
	}
	public Documento getDocumentoPagador() {
		return documentoPagador;
	}
	public void setDocumentoPagador(Documento documentoPagador) {
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
