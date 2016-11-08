package br.com.vendas.service;

import java.io.Serializable;

import javax.inject.Inject;

import br.com.vendas.dao.CadastroClienteDAO;
import br.com.vendas.model.Cliente;
import br.com.vendas.util.jpa.Transactional;


public class CadastroClienteService implements Serializable
{

	private static final long serialVersionUID = 1L;
	
	@Inject
	private CadastroClienteDAO cadastroClienteDAO;
	
	@Transactional
	public void salvar(Cliente cliente) throws NegocioException
	{
		if(cliente.getNome().trim().equals(""))
		{
			new NegocioException("Favor informa o nome do usuário");
		}
		
		cadastroClienteDAO.salvar(cliente);
	}
	

}
