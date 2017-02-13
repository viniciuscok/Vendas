package br.com.vendas.service;

import java.io.Serializable;

import javax.inject.Inject;

import br.com.vendas.dao.CadastroMarcaDAO;
import br.com.vendas.model.Marca;

public class CadastroMarcaService implements Serializable
{
	private static final long serialVersionUID = 1L;
	
	@Inject
	private CadastroMarcaDAO cadastroMarcaDAO;
	
	public void salvar(Marca marca) throws NegocioException
	{
		if(marca.equals("") || marca.getNome() == null)
		{
			throw new NegocioException("Favor informar uma Marca");
		}
		
		cadastroMarcaDAO.salvar(marca);
	}
	

}
