
public class GerenciadorDeDividas {
	
	public void efetuaPagamento(Divida divida, Pagamento pagamento) {
		divida.registra(pagamento);
	}
}
