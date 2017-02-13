package br.com.vendas.dao;

import java.io.Serializable;
import java.util.List;

import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;

import br.com.vendas.dao.filter.ClienteFilter;
import br.com.vendas.model.Cliente;
import br.com.vendas.util.jpa.Transactional;

public class CadastroClienteDAO implements Serializable
{
	private static final long serialVersionUID = 1L;
	
	@Inject
	private EntityManager manager;
	
							//MÉTODO PARA SALVA O CLIENTE PASSANDO O PRÓPRIO CLIENTE COMO PARÂMETRO 		
//------------------------------------------------------------------------------------------------------------------------
	
	public void salvar(Cliente cliente)
	{
		System.out.println("entrou no salvar cadastroclientedao");
		manager.merge(cliente);
	}
	
							//MÉTODO PARA BUSCAR TODOS OS CLIENTES RETORNANDO UMA LISTA DE CLIENTES 		
//------------------------------------------------------------------------------------------------------------------------
	
	public List<Cliente> buscarTodos()
	{
		return manager.createQuery("from Cliente", Cliente.class).getResultList();
	}
	
					//MÉTODO PARA BUSCAR UM CLIENTE PELO NOME OU CPF PASSANDO COMO PARÂMETRO UM CLIENTEFILTER 		
//------------------------------------------------------------------------------------------------------------------------
		
	public List<Cliente> porNomeCPF(ClienteFilter clienteFilter)
	{
		List<Cliente> testes = null;
		if(!clienteFilter.getNome().trim().equals(""))
		{
			testes= manager.createQuery("from Cliente c where c.nome = ?1", Cliente.class)
					.setParameter(1, clienteFilter.getNome())
					.getResultList();
		}
		else if(!clienteFilter.getCpf().trim().equals(""))
		{
			testes= manager.createQuery("from Cliente c where c.documento = ?1", Cliente.class)
					.setParameter(1, clienteFilter.getCpf())
					.getResultList();
		}
		else if(!clienteFilter.getCnpj().trim().equals(""))
		{
			testes = manager.createQuery("from Cliente c where c.documento = ?1", Cliente.class)
					.setParameter(1, clienteFilter.getCnpj())
					.getResultList();
		}
		 return testes;
	}

	public Cliente porCodigo(Long codigo) 
	{
		
		return manager.find(Cliente.class, codigo);
	}
	
	@Transactional
	public void remover(Cliente cliente)
	{
		cliente = porCodigo(cliente.getCodigo());
		manager.remove(cliente);
		manager.flush();
	}
	
	public String buscarCPF(String documento)
	{
		try
		{
			return (String) manager.createQuery("select c.documento from Cliente c where c.documento = ?1 ", String.class)
					.setParameter(1, documento).getSingleResult();
		}catch(NoResultException e)
		{
			return "";
			
		}
		
		
		
	}

}
