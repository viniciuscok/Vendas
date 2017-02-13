package br.com.vendas.dao;

import java.io.Serializable;

import javax.inject.Inject;
import javax.persistence.EntityManager;

import br.com.vendas.model.Marca;
import br.com.vendas.util.jpa.Transactional;

public class CadastroMarcaDAO implements Serializable
{
	private static final long serialVersionUID = 1L;
	
	@Inject
	private EntityManager manager;
	
	@Transactional
	public void salvar(Marca marca)
	{
		manager.merge(marca);
	}

}
