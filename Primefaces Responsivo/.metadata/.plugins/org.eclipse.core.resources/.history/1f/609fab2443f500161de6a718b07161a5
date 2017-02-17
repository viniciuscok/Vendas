package br.com.vendas.dao;

import java.util.List;

import javax.inject.Inject;
import javax.persistence.EntityManager;

import br.com.vendas.model.Contato;

public class CadastroContatoDAO 
{
	@Inject
	EntityManager manager;
	
	public void salvar(Contato contato)
	{
		manager.merge(contato);
	}
	
	public List<Contato> contatos()
	{
		return manager.createQuery("from Contato", Contato.class).getResultList();
	}

}
