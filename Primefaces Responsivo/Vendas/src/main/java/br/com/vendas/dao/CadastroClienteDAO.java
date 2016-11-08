package br.com.vendas.dao;

import java.io.Serializable;

import javax.inject.Inject;
import javax.persistence.EntityManager;

import br.com.vendas.model.Cliente;

public class CadastroClienteDAO implements Serializable
{
	private static final long serialVersionUID = 1L;
	
	@Inject
	private EntityManager manager;
	
	public void salvar(Cliente cliente)
	{
		manager.merge(cliente);
	}
	
	

}
