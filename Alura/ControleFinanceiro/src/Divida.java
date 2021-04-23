public class Divida {
	private Double total;

	private String credor;
	private Documento documentoCredor;
	private Pagamentos pagamentos = new Pagamentos();
	
	public Double getTotal() {
		return total;
	}
	public void setTotal(Double total) {
		this.total = total;
	}
	public String getCredor() {
		return credor;
	}
	
	public void setCredor(String credor) {
		this.credor = credor;
	}

	public Documento getDocumentoCredor() {
		return documentoCredor;
	}
	public void setDocumentoCredor(Documento documentoCredor) {
		this.documentoCredor = documentoCredor;
	}
	
	public double valorAPagar() {
        return this.total - this.pagamentos.getValorPago();
      }
	
	public void registra(Pagamento pagamento) {
		pagamentos.registra(pagamento);
	}
	
	public double getValorPago() {
		return pagamentos.getValorPago();
	}

}
