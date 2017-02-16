package br.com.vendas.controller;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

import br.com.vendas.dao.CadastroMarcaDAO;
import br.com.vendas.model.Espessura;
import br.com.vendas.model.Marca;
import br.com.vendas.model.ModeloVidro;
import br.com.vendas.model.Produto;
import br.com.vendas.model.Tipo;
import br.com.vendas.service.CadastroProdutoService;
import br.com.vendas.service.NegocioException;
import br.com.vendas.util.jsf.FacesUtil;

@Named
@ViewScoped
public class CadastroProdutoBean implements Serializable
{
	private static final long serialVersionUID = 1L;
	
	@Inject
	private CadastroProdutoService cadastroProdutoService;
	private CadastroMarcaDAO cadastroMarcaDAO;
	
	private Produto produto;
	private List<Marca> marcas;
	
	@PostConstruct
	public void inicializar()
	{
		//if(this.produto == null)
		//{
			limpar();
		//}
			buscarTodasMarcas();
		
	}
	
	public void limpar()
	{
		this.produto = new Produto();
		this.marcas = new ArrayList<>();
		
	}
	
	
	public void salvar()
	{
		try
		{
			cadastroProdutoService.salvar(produto);
			limpar();
			FacesUtil.addInfoMessage("Produto cadastrado com sucesso!");
		}catch(NegocioException e)
		{
			FacesUtil.addErrorMessage(e.getMessage());
		}
	}
	
	public void buscarTodasMarcas()
	{
		this.marcas = cadastroMarcaDAO.buscarMarca();
		System.out.println("foi tudo certo\n\n\n\n");
	}
	
	public Tipo[] getTipo()
	{
		return Tipo.values();
	}
	
	public Espessura[] getEspessura()
	{
		return Espessura.values();
	}
	
	public ModeloVidro[] getModeloVidro()
	{
		return ModeloVidro.values();
	}

	public Produto getProduto() {
		return produto;
	}

	public void setProduto(Produto produto) {
		this.produto = produto;
	}

	public List<Marca> getMarcas() {
		return marcas;
	}

	public void setMarcas(List<Marca> marcas) {
		this.marcas = marcas;
	}
	
	
}
