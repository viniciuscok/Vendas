package br.com.vendas.model;

public enum Tipo 
{
	COMUM("Comum"), TEMPERADO("Temperado");
	
	private String descricao;

	private Tipo(String descricao)
	{
		this.descricao = descricao;
	}
	
	public String getDescricao() {
		return descricao;
	}
	
	

}
