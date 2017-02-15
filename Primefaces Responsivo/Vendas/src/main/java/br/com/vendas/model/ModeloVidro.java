package br.com.vendas.model;

public enum ModeloVidro 
{
	INCOLOR("Incolor"), FUME("Fumê"), VERDE("Verde"), JATIADODESENHO("Jateado com Desenho"), 
	JATEADOTOTAL("Jateado Total"),BIZOTADO("Bizotado");
	
	private String descricao;
	
	private ModeloVidro(String descricao)
	{
		this.descricao = descricao;
	}

	public String getDescricao() {
		return descricao;
	}
	
	
}
