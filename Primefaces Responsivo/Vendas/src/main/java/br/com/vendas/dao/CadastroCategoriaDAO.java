package br.com.vendas.dao;

import java.io.Serializable;
import java.util.List;

import javax.inject.Inject;
import javax.persistence.EntityManager;

import br.com.vendas.model.Categoria;
import br.com.vendas.util.jpa.Transactional;

public class CadastroCategoriaDAO implements Serializable
{

	private static final long serialVersionUID = 1L;
	
	@Inject
	private EntityManager manager;
	
							//MÉTODO PARA SALVA E ATUALIZAR UMA CATEGORIA. 		
//------------------------------------------------------------------------------------------------------------------------
		
	@Transactional
	public void salvar(Categoria categoria)
	{
		manager.merge(categoria);
	}
	
								//MÉTODO PARA REMOVER UMA CATEGORIA.	
//------------------------------------------------------------------------------------------------------------------------

	@Transactional
	public void remover(Categoria categoria)
	{
		categoria = porCodigo(categoria.getCodigo());
		manager.remove(categoria);
		manager.flush();
	}
							//MÉTODO PARA BUSCAR UMA CATEGORIA PELO CÓDIGO		
//------------------------------------------------------------------------------------------------------------------------
			
	public Categoria porCodigo(Long codigo) 
	{
		return manager.find(Categoria.class, codigo);
		
	}

							//MÉTODO PARA BUSCAR TODAS AS CATEGORIAS	
//------------------------------------------------------------------------------------------------------------------------
				
	public List<Categoria> buscarTodos()
	{
		return manager.createQuery("FROM Categoria", Categoria.class).getResultList();
	}
	
							//MÉTODO PARA BUSCAR PELO NOME DA CATEGORIA
//------------------------------------------------------------------------------------------------------------------------
					
	public List<Categoria> buscarCategoria(String nome)
	{
		return manager.createQuery("FROM Categoria c where c.nome like ?1", Categoria.class)
				.setParameter(1, "%"+nome+"%").getResultList();
	}
	
								//MÉTODO QUE RETORNA UMA LISTA DE CATEGORIA.
//------------------------------------------------------------------------------------------------------------------------
							
	public List<Categoria> buscarCategoria()
	{
		return manager.createQuery("FROM Categoria", Categoria.class).getResultList();
	}
}
