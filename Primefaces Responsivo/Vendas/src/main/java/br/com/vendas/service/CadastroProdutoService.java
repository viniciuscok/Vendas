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
			
			//MÉTODO PARA VERIFICAR SE O PRODUTO ESTÁ PREENCHIDO OU SE ELE ESTÁ NULO.
//------------------------------------------------------------------------------------------------------------------------
	public void salvar(Produto produto) throws NegocioException
	{
		if(produto.getNome().trim().equals("") || produto == null)
		{
			throw new NegocioException("Produto não foi preenchido ou está Nulo");
		}
		
		cadastroProdutoDAO.salvar(produto);
	}
	

}
