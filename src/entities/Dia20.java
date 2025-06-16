package entities;

public class Dia20 extends RelatorioPagamentos{
	private Double vale;
	
	public Dia20() {
		
	}

	public Dia20(Double caixinhaTotal, Double caixinhaConta, Double caixinhaEspecie, Double conducao, Double vale) {
		super(caixinhaTotal, caixinhaConta, caixinhaEspecie, conducao);
		this.vale = vale;
	}

	public Double getVale() {
		return vale;
	}

	public void setVale(Double vale) {
		this.vale = vale;
	}
	
	@Override
	public double total() {
		return vale + super.total();
	}
	@Override
	public String toString() {
		return "***********************************"
		+"\nRelatório do dia 20"
		+ "\nVale: R$" + vale
		+ "\nCondução: R$" + conducao + "\n\n"
		+ dadosCaixinha() + "\n"
		+"\nTotal recebido : R$" + total() ;
	 	
	}
}
