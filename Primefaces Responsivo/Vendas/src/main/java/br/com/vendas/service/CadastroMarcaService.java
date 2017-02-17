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
	
							//MÉTODO PARA VERIFICAR SE A MARCA ESTÁ NULA E VERIFICAR SE O CAMPO ESTÁ EM BRANCO.  		
	//------------------------------------------------------------------------------------------------------------------------
				
	public void salvar(Marca marca) throws NegocioException
	{
		if(marca.getNome().trim().equals("") || marca.getNome() == null)
		{
			throw new NegocioException("A Marca está nula ou Você deve informa uma Marca");
		}
		
		cadastroMarcaDAO.salvar(marca);
	}
	

}
