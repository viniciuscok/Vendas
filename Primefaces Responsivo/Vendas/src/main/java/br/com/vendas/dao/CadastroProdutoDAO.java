package br.com.vendas.dao;

import java.io.Serializable;
import java.util.List;

import javax.inject.Inject;
import javax.persistence.EntityManager;

import br.com.vendas.model.Produto;
import br.com.vendas.util.jpa.Transactional;

public class CadastroProdutoDAO implements Serializable
{
	private static final long serialVersionUID = 1L;
	
	@Inject
	private EntityManager manager;
	
										//MÉTODO PARA SALVA E ATUALIZAR UM PRODUTO.  		
//------------------------------------------------------------------------------------------------------------------------
				
	@Transactional
	public void salvar(Produto produto)
	{
		this.manager.merge(produto);
	}

	@Transactional
	public void remover(Produto produto) 
	{
		produto = porCodigo(produto.getCodigo());
		manager.remove(produto);
		manager.flush();
	}

	public Produto porCodigo(Long codigo)
	{
		return manager.find(Produto.class, codigo);
	}
	
	public List<Produto> buscarTodos()
	{
		return manager.createQuery("FROM Produto",Produto.class).getResultList();
	}
}
