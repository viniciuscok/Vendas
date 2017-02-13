package br.com.vendas.service;

import java.io.Serializable;

import javax.inject.Inject;

import br.com.vendas.dao.CadastroSubcategoriaDAO;
import br.com.vendas.model.SubCategoria;

public class CadastroSubcategoriaService implements Serializable
{

	private static final long serialVersionUID = 1L;

	@Inject
	private CadastroSubcategoriaDAO cadastroSubcategoriaDAO;
	
	public void salvar(SubCategoria subCategoria)
	{
		if(subCategoria.getNome().isEmpty() || subCategoria.getNome() == null)
		{
			throw new NegocioException("O nome não pode está vazio");
		}
		
		this.cadastroSubcategoriaDAO.salvar(subCategoria);
	}
}
