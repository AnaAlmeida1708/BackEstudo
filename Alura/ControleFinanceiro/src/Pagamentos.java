import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collection;
import java.util.Iterator;

public class Pagamentos implements Iterable<Pagamento> {
	
	private Double valorPago = Double.MIN_VALUE;
	private Collection<Pagamento> pagamentos = new ArrayList<>();
	
	public Double getValorPago() {
		return valorPago;
	}
	
	public void registra(Pagamento pagamento) {
		  double valor = pagamento.getValor();
          if (valor < 0) {
            throw new IllegalArgumentException("Valor invalido para pagamento");
          }
          if (valor > 100) {
            valor = valor - 8;
          }
          this.valorPago += valor;
          this.pagamentos.add(pagamento);
	}
	
	public Collection<Pagamento> pagamentosAntesDe(Calendar data){
		ArrayList<Pagamento> pagamentosFiltrados = new ArrayList<Pagamento>();
		for(Pagamento pagamento : this) {
			if(pagamento.getData().before(data)) {
				pagamentosFiltrados.add(pagamento);
			}
		}
		return pagamentosFiltrados;
	}
	
	public Collection<Pagamento> pagamentosComValorMaiorQue(double valorMinimo){
		ArrayList<Pagamento> pagamentosFiltrados = new ArrayList<Pagamento>();
		for(Pagamento pagamento : this) {
			if(pagamento.getValor() > valorMinimo) {
				pagamentosFiltrados.add(pagamento);
			}
		}
		return pagamentosFiltrados;
	}
	
	public Collection<Pagamento> pagamentosDo(Documento documentoPagador){
		Collection<Pagamento> pagamentosFiltrados = new ArrayList<Pagamento>();
		for(Pagamento pagamento : this.pagamentos) {
			if(pagamento.getDocumentoPagador().equals(documentoPagador.getValor())) {
				pagamentosFiltrados.add(pagamento);
			}
		}
		return pagamentosFiltrados;
	}
	
	public boolean foiRealizado(Pagamento pagamento) {
		return pagamentos.contains(pagamento);
	}

	@Override
	public Iterator<Pagamento> iterator() {
		return this.pagamentos.iterator();
	}
	
	
}
