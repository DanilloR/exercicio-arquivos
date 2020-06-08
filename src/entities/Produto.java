package entities;

public class Produto {
	
	private String nomeProduto;
	private Double precoProduto;
	private Integer quantidade;
	
	public Produto(String nomeProduto, Double precoProduto, Integer quantidade) {
		this.nomeProduto = nomeProduto;
		this.precoProduto = precoProduto;
		this.quantidade = quantidade;
	}

	public String getNomeProduto() {
		return nomeProduto;
	}

	public Double getPrecoProduto() {
		return precoProduto;
	}

	public Integer getQuantidade() {
		return quantidade;
	}
	
	public Double precoFinal () {
		return precoProduto*quantidade;
	}
	
	@Override
	public String toString() {
		return nomeProduto
				+","+
				String.format("%.2f", precoFinal());
	}
}
