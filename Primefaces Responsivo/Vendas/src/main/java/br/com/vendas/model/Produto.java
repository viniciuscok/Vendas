package br.com.vendas.model;

import java.io.Serializable;

public class Produto implements Serializable 
{
	private static final long serialVersionUID = 1L;
	
	private Long codigo;
	private String nome;
	private TipoVidro tipoVidro;
	private Marca marca;
	private Categoria categoria;
	private Espessura espessura;
	private Double valorMetro;
	private Integer estoque;
	
	public Produto()
	{
		this.tipoVidro = TipoVidro.COMUM;
	}

	public Long getCodigo() {
		return codigo;
	}

	public void setCodigo(Long codigo) {
		this.codigo = codigo;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public TipoVidro getTipoVidro() {
		return tipoVidro;
	}

	public void setTipoVidro(TipoVidro tipoVidro) {
		this.tipoVidro = tipoVidro;
	}

	public Marca getMarca() {
		return marca;
	}

	public void setMarca(Marca marca) {
		this.marca = marca;
	}

	public Espessura getEspessura() {
		return espessura;
	}

	public void setEspessura(Espessura espessura) {
		this.espessura = espessura;
	}

	public Double getValorMetro() {
		return valorMetro;
	}

	public void setValorMetro(Double valorMetro) {
		this.valorMetro = valorMetro;
	}

	public Integer getEstoque() {
		return estoque;
	}

	public void setEstoque(Integer estoque) {
		this.estoque = estoque;
	}
	
	
	

}
