package br.com.vendas.controller;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

import br.com.vendas.dao.CadastroCategoriaDAO;
import br.com.vendas.dao.CadastroMarcaDAO;
import br.com.vendas.model.Categoria;
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
	@Inject
	private CadastroMarcaDAO cadastroMarcaDAO;
	@Inject
	private CadastroCategoriaDAO cadastroCategoriaDAO;
	
	private Produto produto;
	private List<Marca> marcas;
	private List<Categoria> categorias;
	
	@PostConstruct
	public void inicializar()
	{
		if(this.produto == null)
		{
			limpar();
		}
			
		
	}
	
	public void limpar()
	{
		this.produto = new Produto();
		this.categorias = new ArrayList<>();
		this.marcas = new ArrayList<>();
		buscarTodasMarcas();
		buscarTodasCategorias();
		
	}
	
	public void buscarTodasCategorias()
	{
		
		this.categorias = cadastroCategoriaDAO.buscarCategoria();
		
		//System.out.println("entrou na categoria");
		//for (String string : categorias) 
		//{
		//	System.out.println("nome: "+string);
		//	
		//}
		
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

	public List<Categoria> getCategorias() {
		return categorias;
	}

	public void setCategorias(List<Categoria> categorias) {
		this.categorias = categorias;
	}
	
	
	
}
