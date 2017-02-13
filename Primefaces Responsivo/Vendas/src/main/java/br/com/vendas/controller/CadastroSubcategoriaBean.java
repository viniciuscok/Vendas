package br.com.vendas.controller;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

import br.com.vendas.dao.CadastroCategoriaDAO;
import br.com.vendas.model.Categoria;
import br.com.vendas.model.SubCategoria;
import br.com.vendas.service.CadastroSubcategoriaService;
import br.com.vendas.service.NegocioException;
import br.com.vendas.util.jsf.FacesUtil;

@Named
@ViewScoped
public class CadastroSubcategoriaBean implements Serializable
{

	private static final long serialVersionUID = 1L;
	
	@Inject
	private CadastroSubcategoriaService cadastroSubcategoriaService;
	@Inject
	private CadastroCategoriaDAO cadastroCategoriaDAO;
	
	private SubCategoria subCategoria;
	private List<Categoria> categorias;
	
	@PostConstruct
	public void inicializar()
	{
		if(this.subCategoria == null)
		{
			limpar();
		}
	}
	
	public void salvar()
	{
		try
		{
			cadastroSubcategoriaService.salvar(subCategoria);
			FacesUtil.addInfoMessage("subcategoria inserida com sucesso");
		}catch(NegocioException e)
		{
			FacesUtil.addErrorMessage(e.getMessage());
		}
	}
	
	//public List<Categoria> getBuscarTodasCategorias()
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
	
	public void limpar()
	{
		this.subCategoria = new SubCategoria();
		this.categorias = new ArrayList<>();
		buscarTodasCategorias();
	}

	public SubCategoria getSubCategoria() {
		return subCategoria;
	}

	public List<Categoria> getCategorias() {
		return categorias;
	}

	public void setSubCategoria(SubCategoria subCategoria) {
		this.subCategoria = subCategoria;
	}

	public void setCategorias(List<Categoria> categorias) {
		this.categorias = categorias;
	}
	
	

}
