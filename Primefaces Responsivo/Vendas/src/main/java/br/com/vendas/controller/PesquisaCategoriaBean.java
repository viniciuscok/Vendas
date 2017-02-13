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
import br.com.vendas.service.NegocioException;
import br.com.vendas.util.jsf.FacesUtil;

@Named
@ViewScoped
public class PesquisaCategoriaBean implements Serializable
{
	private static final long serialVersionUID = 1L;
	
	@Inject
	private CadastroCategoriaDAO cadastroCategoriaDAO;
	private List<Categoria> categorias;
	private Categoria categoriaSelecionada;
	private Categoria categoria;
	
						//Método PARA INICIAR A LISTA DE CATEGORIAS
						//@PostConstruct = É CARREGADO ANTES DE ABRIR A PÁGINA
//------------------------------------------------------------------------------------------------------------------------

	@PostConstruct
	public void inicializar()
	{
		categorias = new ArrayList<>();
		categoria = new Categoria();
	}
	
						//MÉTODO PARA REMOVER UMA CATEGORIA SELECIONADA PELO USUÁRIO NA TABELA
//------------------------------------------------------------------------------------------------------------------------
	
	public void remover()
	{
		try
		{
			cadastroCategoriaDAO.remover(categoriaSelecionada);
			categorias.remove(categoriaSelecionada);
		}catch(NegocioException e)
		{
			FacesUtil.addErrorMessage(e.getMessage());
		}
	}
	
						//MÉTODO PARA BUSCAR TODAS AS CATEGORIAS
//------------------------------------------------------------------------------------------------------------------------
			
	public void buscarTodos()
	{
		try
		{
			this.categorias = cadastroCategoriaDAO.buscarTodos();
		}catch(NegocioException e)
		{
			FacesUtil.addErrorMessage(e.getMessage());
		}
	}
	
						//MÉTODO PARA BUSCAR A CATEGORIA PELO NOME
//------------------------------------------------------------------------------------------------------------------------
				
		public void buscarPorNome()
		{
			try
			{
				this.categorias = cadastroCategoriaDAO.buscarCategoria(categoria.getNome());
			}catch(NegocioException e)
			{
				FacesUtil.addErrorMessage(e.getMessage());
			}
		}

									//MÉTODOS GETTERS E SETTERS	
//------------------------------------------------------------------------------------------------------------------------
				
	public List<Categoria> getCategorias() {
		return categorias;
	}

	public void setCategorias(List<Categoria> categorias) {
		this.categorias = categorias;
	}

	public Categoria getCategoriaSelecionada() {
		return categoriaSelecionada;
	}

	public void setCategoriaSelecionada(Categoria categoriaSelecionada) {
		this.categoriaSelecionada = categoriaSelecionada;
	}

	public Categoria getCategoria() {
		return categoria;
	}

	public void setCategoria(Categoria categoria) {
		this.categoria = categoria;
	}
	

	
	
}
