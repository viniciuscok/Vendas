package br.com.vendas.controller;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

import br.com.vendas.dao.CadastroProdutoDAO;
import br.com.vendas.model.Produto;
import br.com.vendas.service.NegocioException;
import br.com.vendas.util.jsf.FacesUtil;

@Named
@ViewScoped
public class PesquisaProdutoBean implements Serializable 
{
	private static final long serialVersionUID = 1L;
	
	@Inject
	private CadastroProdutoDAO cadastroProdutoDAO;
	
	private Produto produtoSelecionado;
	private Produto produto;
	private List<Produto> produtos;

	public void inicializar()
	{
		limpar();
	}
	
	public void limpar()
	{
		this.produto = new Produto();
		this.produtos = new ArrayList<>();
	}
	
	public void removerProdutoSelecionado()
	{
		try
		{
			cadastroProdutoDAO.remover(produtoSelecionado);
			produtos.remove(produtoSelecionado);
			FacesUtil.addInfoMessage("Produto "+this.produtoSelecionado.getNome()+"removido com Sucesso!");
		}catch(NegocioException e)
		{
			FacesUtil.addErrorMessage(e.getMessage());
		}
		
	}
}
