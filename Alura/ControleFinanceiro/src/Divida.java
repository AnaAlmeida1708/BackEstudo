public class Divida {
	private Double total;

	private String credor;
	private Cnpj cnpjCredor = new Cnpj();
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

	public Cnpj getCnpjCredor() {
		return cnpjCredor;
	}
	public void setCnpjCredor(Cnpj cnpjCredor) {
		this.cnpjCredor = cnpjCredor;
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
