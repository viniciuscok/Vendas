package br.com.vendas.dao;

import java.io.Serializable;

import javax.inject.Inject;
import javax.persistence.EntityManager;

import br.com.vendas.model.Produto;
import br.com.vendas.util.jpa.Transactional;

public class CadastroProdutoDAO implements Serializable
{
	private static final long serialVersionUID = 1L;
	
	@Inject
	private EntityManager manager;
	
	@Transactional
	public void salvar(Produto produto)
	{
		this.manager.merge(produto);
	}

}
