package br.com.vendas.controller;

import java.io.Serializable;

import javax.annotation.PostConstruct;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

import br.com.vendas.model.Categoria;
import br.com.vendas.service.CadastroCategoriaService;
import br.com.vendas.service.NegocioException;
import br.com.vendas.util.jsf.FacesUtil;

@Named
@ViewScoped
public class CadastroCategoriaBean implements Serializable
{

	private static final long serialVersionUID = 1L;
	
	@Inject
	private CadastroCategoriaService cadastroCategoriaService;
	
	private Categoria categoria;
	
							//Método PARA INSTÂNCIAR A CATEGORIA CASO SEJA NULL
							//@PostConstruct = É CARREGADO ANTES DE ABRIR A PÁGINA
//------------------------------------------------------------------------------------------------------------------------
		
	@PostConstruct
	public void inicializar()
	{
		if(this.categoria == null)
		{
			limpar();
		}
		
	}
	
							//MÉTODO PARA CRIAR UM NOVO OBJETO CATEGORIA
//------------------------------------------------------------------------------------------------------------------------
	
	public void limpar()
	{
		this.categoria = new Categoria();
		
	}
	
							//MÉTODO PARA SALVAR UMA CATEGORIA
//------------------------------------------------------------------------------------------------------------------------
		
	public void salvar()
	{
		try
		{
			cadastroCategoriaService.salvar(categoria);
			//Verifica se a categoria é diferente ou igual a null, e mostra as seguintes msg para o usuário.
			if(this.categoria.getCodigo() == null)
			{
				FacesUtil.addInfoMessage("Categoria '"+this.categoria.getNome()+"' inserida com sucesso!");
			}else
			{
				FacesUtil.addInfoMessage("Categoria '"+this.categoria.getNome()+"' atualizada com sucesso!");
			}
			
		}catch(NegocioException e)
		{
			FacesUtil.addErrorMessage(e.getMessage());
		}
	}
	
										//MÉTODOS GETTERS E SETTERS
//------------------------------------------------------------------------------------------------------------------------

	public Categoria getCategoria() {
		return categoria;
	}

	public void setCategoria(Categoria categoria) {
		this.categoria = categoria;
	}
	
	

}
