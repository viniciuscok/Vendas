package br.com.vendas.service;

import java.io.Serializable;

import javax.inject.Inject;

import br.com.vendas.dao.CadastroProdutoDAO;
import br.com.vendas.model.Produto;

public class CadastroProdutoService implements Serializable
{
	private static final long serialVersionUID = 1L;
	
	@Inject
	private CadastroProdutoDAO cadastroProdutoDAO;
	
	public void salvar(Produto produto) throws NegocioException
	{
		if(produto.getNome().isEmpty() || produto.equals(""))
		{
			throw new NegocioException("Favor verificar o usuário");
		}
		
		cadastroProdutoDAO.salvar(produto);
	}
	

}
