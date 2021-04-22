import java.util.ArrayList;
import java.util.Calendar;

public class Pagamentos extends ArrayList<Pagamento>{
	
	private Double valorPago;
	
	public Double getValorPago() {
		return valorPago;
	}
	
	private void paga(Double valor) {
		if(valor < 0) {
			throw new IllegalArgumentException("Valor inválido para pagamento");
		}
		if(valor > 100) {
			valor = valor - 8;
		}
		this.valorPago += valor;
	}
	
	public void registra(Pagamento pagamento) {
		this.add(pagamento);
		this.paga(pagamento.getValor());
	}
	
	public ArrayList<Pagamento> pagamentosAntesDe(Calendar data){
		ArrayList<Pagamento> pagamentosFiltrados = new ArrayList<Pagamento>();
		for(Pagamento pagamento : this) {
			if(pagamento.getData().before(data)) {
				pagamentosFiltrados.add(pagamento);
			}
		}
		return pagamentosFiltrados;
	}
	
	public ArrayList<Pagamento> pagamentosComValorMaiorQue(double valorMinimo){
		ArrayList<Pagamento> pagamentosFiltrados = new ArrayList<Pagamento>();
		for(Pagamento pagamento : this) {
			if(pagamento.getValor() > valorMinimo) {
				pagamentosFiltrados.add(pagamento);
			}
		}
		return pagamentosFiltrados;
	}
	
	public ArrayList<Pagamento> pagamentosDo(String cnpjPagador){
		ArrayList<Pagamento> pagamentosFiltrados = new ArrayList<Pagamento>();
		for(Pagamento pagamento : this) {
			if(pagamento.getCnpjPagador().equals(cnpjPagador)) {
				pagamentosFiltrados.add(pagamento);
			}
		}
		return pagamentosFiltrados;
	}
	
}
