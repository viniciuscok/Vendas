package br.com.vendas.dao;

import java.io.Serializable;
import java.util.List;

import javax.inject.Inject;
import javax.persistence.EntityManager;

import br.com.vendas.dao.filter.ClienteFilter;
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
	
	
	public List<Cliente> buscarTodos(ClienteFilter clienteFilter)
	{
		List<Cliente> testes = null;
		if(!clienteFilter.getNome().trim().equals(""))
		{
			testes= manager.createQuery("from Cliente c where c.nome = ?1", Cliente.class)
					.setParameter(1, clienteFilter.getNome())
					.getResultList();
		}
		else if(!clienteFilter.getDocumento().trim().equals(""))
		{
			testes= manager.createQuery("from Cliente c where c.documento = ?1", Cliente.class)
					.setParameter(1, clienteFilter.getDocumento())
					.getResultList();
		}
		 return testes;
	}

}
