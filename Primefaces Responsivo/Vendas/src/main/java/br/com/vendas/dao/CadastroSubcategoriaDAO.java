package br.com.vendas.dao;

import java.io.Serializable;

import javax.inject.Inject;
import javax.persistence.EntityManager;

import br.com.vendas.model.SubCategoria;
import br.com.vendas.util.jpa.Transactional;

public class CadastroSubcategoriaDAO implements Serializable
{

	private static final long serialVersionUID = 1L;
	
	@Inject
	private EntityManager manager;
	
	@Transactional
	public void salvar(SubCategoria subCategoria)
	{
		manager.merge(subCategoria);
	}

	public SubCategoria porCodigo(Long codigo) 
	{
		return manager.find(SubCategoria.class, codigo);
	}
	

}
