package br.com.vendas.dao;

import java.io.Serializable;
import java.util.List;

import javax.inject.Inject;
import javax.persistence.EntityManager;

import br.com.vendas.model.Marca;
import br.com.vendas.util.jpa.Transactional;

public class CadastroMarcaDAO implements Serializable
{
	private static final long serialVersionUID = 1L;
	
	@Inject
	private EntityManager manager;
	
									//MÉTODO PARA SALVA E ATUALIZAR UMA MARCA.  		
//------------------------------------------------------------------------------------------------------------------------
			
	@Transactional
	public void salvar(Marca marca)
	{
		manager.merge(marca);
	}
	
									//MÉTODO QUE RETORNA UMA LISTA DE MARCAS.	
//------------------------------------------------------------------------------------------------------------------------
				
	public List<Marca> buscarMarca()
	{
		return manager.createQuery("FROM Marca", Marca.class).getResultList();
	}

									//MÉTODO PARA BUSCAR UMA MARCA PASSANDO COMO PARÂMETRO O CÓDIGO DA MARCA. 		
//------------------------------------------------------------------------------------------------------------------------
				
	public Marca porCodigo(Long codigo) 
	{
		
		return manager.find(Marca.class, codigo);
	}

}
