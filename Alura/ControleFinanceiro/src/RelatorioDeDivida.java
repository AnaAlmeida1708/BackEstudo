import java.text.NumberFormat;

public class RelatorioDeDivida {
	
	private final Divida divida;

	public RelatorioDeDivida(Divida divida) {
		this.divida = divida;
	}
	
	public void geraRelatorio(NumberFormat nf) {
		System.out.println("Cnpj credor: " + divida.getDocumentoCredor());
		System.out.println("Credor: " +  divida.getCredor());
		
		//NumberFormat nf = NumberFormat.getCurrencyInstance(new Locale("pt", "BR"));
		System.out.println("Valor divida: " + nf.format(divida.getTotal()));
		System.out.println("Valor pago: " + nf.format(divida.getValorPago()));
	}
	

}
