package entities;

public class RelatorioPagamentos {
	private Double pagamento;
	private Double caixinhaTotal;
	private Double caixinhaConta;
	private Double caixinhaEspecie;
	private Double conducao;

	public RelatorioPagamentos() {
		
	}

	
	public RelatorioPagamentos(Double caixinhaTotal, Double caixinhaConta, Double caixinhaEspecie, Double conducao, Double pagamento) {
		this.caixinhaTotal = caixinhaTotal;
		this.caixinhaConta = caixinhaConta;
		this.caixinhaEspecie = caixinhaEspecie;
		this.conducao = conducao;
		this.pagamento = pagamento;
	}

	public Double getConducao() {
		return conducao;
	}

	public void setConducao(Double conducao) {
		this.conducao = conducao;
	}

	public Double getCaixinhaConta() {
		return caixinhaConta;
	}

	public void setCaixinhaConta(Double caixinhaConta) {
		this.caixinhaConta = caixinhaConta;
	}

	public Double getCaixinhaEspecie() {
		return caixinhaEspecie;
	}

	public void setCaixinhaEspecie(Double caixinhaEspecie) {
		this.caixinhaEspecie = caixinhaEspecie;
	}

	public Double getCaixinhaTotal() {
		return caixinhaTotal;
	}

	public void setCaixinhaTotal(Double caixinhaTotal) {
		this.caixinhaTotal = caixinhaTotal;
	}

	public double total() {
		return conducao + caixinhaConta + caixinhaEspecie + pagamento; 
	}
	public String dadosCaixinha() {
		return "Valor total da caixinha: " + caixinhaTotal + 
				"\nTotal de caixinha recebida: " + (caixinhaConta + caixinhaEspecie) + 
				"\nCaixinha pendente: " + (caixinhaTotal - caixinhaConta - caixinhaEspecie);
	}
	@Override
	public String toString() {
		return "***********************************"
		+ "\nVale/Pagamento: R$" + pagamento
		+ "\nCondução: R$" + conducao + "\n\n"
		+ dadosCaixinha() + "\n"
		+"\nTotal recebido : R$" + total() ;
	 	
	}
	
}
