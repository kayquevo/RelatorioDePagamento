package entities;

public class Dia5 extends RelatorioPagamentos{
	private Double pagamento = 0.0;
	
	public Dia5() {
		
	}

	public Dia5(Double caixinhaTotal, Double caixinhaConta, Double caixinhaEspecie, Double conducao, Double pagamento) {
		super(caixinhaTotal, caixinhaConta, caixinhaEspecie, conducao);
		this.pagamento = pagamento;
	}
	
	public Double getPagamento() {
		return pagamento;
	}

	public void setPagamento(Double pagamento) {
		this.pagamento = pagamento;
	}

	@Override
	public double total() {
		return pagamento + super.total();
	}
	@Override
	public String toString() {
		return "***********************************"
		+"\nRelatório do dia 5"
		+ "\nVale: R$" + pagamento
		+ "\nCondução: R$" + conducao + "\n\n"
		+ dadosCaixinha() + "\n"
		+"\nTotal recebido : R$" + total() ;
	 	
	}
}
