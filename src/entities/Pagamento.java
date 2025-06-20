package entities;

public class Pagamento {
	private Double valorTotal;
	private Integer dia;
	
	public Pagamento() {
		
	}
	public Pagamento(Double valorTotal, Integer dia) {
		this.valorTotal = valorTotal;
		this.dia = dia;
	}
	public Double getValorTotal() {
		return valorTotal;
	}
	public void setValorTotal(Double valorTotal) {
		this.valorTotal = valorTotal;
	}
	public Integer getDia() {
		return dia;
	}
	public void setDia(Integer dia) {
		this.dia = dia;
	}

	public Double getCaixinha() {
		double caixinha = 0.0;
		
		if(dia == 5) {
			caixinha = valorTotal - 1190.0 - 120.0;
		}
		if(dia == 20) {
			caixinha = valorTotal - 865.0 - 160.0;
		}
		return caixinha;
	}
	
	public Double getPagamento(Double caixinha) {
		double pagamento = 0.0;
		if(dia == 5) {
			pagamento = valorTotal - caixinha - 120.00;
		}
		if(dia == 20) {
			pagamento = valorTotal - caixinha - 160.00;
		}
		return pagamento;
	}
	
	public Double getConducao() {
		double caixinha = getCaixinha();
		double pagamento = getPagamento(caixinha);
		double conducao = valorTotal - pagamento - caixinha;
		return conducao;
	}
	
}
