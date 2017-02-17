package br.com.vendas.dao;

import java.util.List;

import javax.inject.Inject;
import javax.persistence.EntityManager;

import br.com.vendas.model.Contato;

public class CadastroContatoDAO 
{
	@Inject
	EntityManager manager;
	
									//MÉTODO PARA SALVA E ATUALIZAR UM CONTATO.  		
//------------------------------------------------------------------------------------------------------------------------
		
	public void salvar(Contato contato)
	{
		manager.merge(contato);
	}
	
									//MÉTODO QUE RETORNA UMA LISTA DE CONTATOS.  		
//------------------------------------------------------------------------------------------------------------------------
			
	public List<Contato> contatos()
	{
		return manager.createQuery("from Contato", Contato.class).getResultList();
	}

}
