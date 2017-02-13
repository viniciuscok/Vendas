package br.com.vendas.service;

import java.io.Serializable;

import javax.inject.Inject;

import br.com.vendas.dao.CadastroCategoriaDAO;
import br.com.vendas.model.Categoria;

public class CadastroCategoriaService implements Serializable
{
	private static final long serialVersionUID = 1L;
	
	@Inject
	private CadastroCategoriaDAO cadastroCategoriaDAO;
	
			//MÉTODO SALVAR UMA CATEGORIA COM UMA REGRA DE NÉGOCIO ONDE SE A CATEGORIA ESTIVER NULA OU NÃO ESTIVER PREENCHIDA,  
			//A CATEGORIA NÃO SERÁ CADASTRADA.
//------------------------------------------------------------------------------------------------------------------------
	public void salvar(Categoria categoria) throws NegocioException
	{
		if(categoria.getNome().isEmpty() || categoria.getNome() == null )
		{
			throw new NegocioException("FAVOR VERIFICAR A CATEGORIA");
		}
		
		cadastroCategoriaDAO.salvar(categoria);
	}

}
