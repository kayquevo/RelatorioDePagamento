package entities;

public abstract class RelatorioPagamentos {
	protected Double caixinhaTotal;
	protected Double caixinhaConta;
	protected Double caixinhaEspecie;
	protected Double conducao;

	public RelatorioPagamentos() {
		
	}

	
	public RelatorioPagamentos(Double caixinhaTotal, Double caixinhaConta, Double caixinhaEspecie, Double conducao) {
		this.caixinhaTotal = caixinhaTotal;
		this.caixinhaConta = caixinhaConta;
		this.caixinhaEspecie = caixinhaEspecie;
		this.conducao = conducao;
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
		return conducao + caixinhaConta + caixinhaEspecie; 
	}
	public String dadosCaixinha() {
		return "Valor total da caixinha: " + caixinhaTotal + 
				"\nTotal de caixinha recebida: " + (caixinhaConta + caixinhaEspecie) + 
				"\nCaixinha pendente: " + (caixinhaTotal - caixinhaConta - caixinhaEspecie);
	}
	
}
