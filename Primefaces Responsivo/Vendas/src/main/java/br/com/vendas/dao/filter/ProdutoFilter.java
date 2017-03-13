package br.com.vendas.dao.filter;

import java.io.Serializable;

import br.com.vendas.model.Categoria;
import br.com.vendas.model.Marca;
import br.com.vendas.model.ModeloVidro;
import br.com.vendas.model.SubCategoria;
import br.com.vendas.model.Tipo;

public class ProdutoFilter implements Serializable
{

	private static final long serialVersionUID = 1L;
	
	private String nome;
	private Categoria categoria;
	private SubCategoria subCategoria;
	private Tipo tipo;
	private ModeloVidro[] modeloVidros;
	private Marca marca;
	
	public String getNome() {
		return nome;
	}
	public Categoria getCategoria() {
		return categoria;
	}
	public SubCategoria getSubCategoria() {
		return subCategoria;
	}
	public Tipo getTipo() {
		return tipo;
	}
	
	public void setNome(String nome) {
		this.nome = nome;
	}
	public void setCategoria(Categoria categoria) {
		this.categoria = categoria;
	}
	public void setSubCategoria(SubCategoria subCategoria) {
		this.subCategoria = subCategoria;
	}
	public void setTipo(Tipo tipo) {
		this.tipo = tipo;
	}
	
	public Marca getMarca() {
		return marca;
	}
	public void setMarca(Marca marca) {
		this.marca = marca;
	}
	public ModeloVidro[] getModeloVidros() {
		return modeloVidros;
	}
	public void setModeloVidros(ModeloVidro[] modeloVidros) {
		this.modeloVidros = modeloVidros;
	}
	
	
	

}
