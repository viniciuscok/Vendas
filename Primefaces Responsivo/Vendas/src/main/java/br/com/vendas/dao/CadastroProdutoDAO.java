package br.com.vendas.dao;

import java.io.Serializable;
import java.util.List;

import javax.inject.Inject;
import javax.persistence.EntityManager;

import br.com.vendas.dao.filter.ProdutoFilter;
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
	
	public List<Produto> buscarProduto(ProdutoFilter produtoFilter)
	{
		
		List<Produto> produtos = null;
	
		if(!produtoFilter.getNome().equals(""))
		{
			System.out.println("entrou no if do nome");
			produtos = manager.createQuery("FROM Produto p where p.nome LIKE ?1", Produto.class)
					.setParameter(1, produtoFilter.getNome()+"%")
					.getResultList();
		}
		if(!produtoFilter.getNome().equals("") && produtoFilter.getCategoria() != null)
		{
			System.out.println("entrou no if do nome e da categoria");
			produtos = manager.createQuery("FROM Produto p where p.nome LIKE ?1 and p.categoria.codigo = ?2", Produto.class)
					.setParameter(1, produtoFilter.getNome()+"%")
					.setParameter(2, produtoFilter.getCategoria().getCodigo()).getResultList();
		}
		
		
		return produtos;
	}
}
