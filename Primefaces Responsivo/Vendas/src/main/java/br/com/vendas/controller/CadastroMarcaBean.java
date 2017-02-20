package br.com.vendas.controller;

import java.io.Serializable;

import javax.annotation.PostConstruct;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

import br.com.vendas.model.Marca;
import br.com.vendas.service.CadastroMarcaService;
import br.com.vendas.service.NegocioException;
import br.com.vendas.util.jsf.FacesUtil;

@Named
@ViewScoped
public class CadastroMarcaBean implements Serializable
{
	private static final long serialVersionUID = 1L;

	@Inject
	private CadastroMarcaService cadastroMarcaService;
	private Marca marca;
	
						//Método PARA INICIAR UMA MARCA CASO SEJA NULA
						//@PostConstruct = É CARREGADO ANTES DE ABRIR A PÁGINA
//------------------------------------------------------------------------------------------------------------------------

	@PostConstruct
	public void inicializar()
	{
		if(marca == null)
		{
			limpar();
		}
	}
	
							//Método CHAMADO PARA LIMPAR A TELA QUANDO A MARCA FOR CADASTRADA.
							//MÉTODO INICIA UMA NOVA MARCA.
//------------------------------------------------------------------------------------------------------------------------

	public void limpar()
	{
		this.marca = new Marca();
	}
	
					//MÉTODO PARA SALVA E ATUALIZAR A MARCA, VERIFICANDO SE O CÓDIGO DA MARCA E NULO OU NÃO.
					//CASO SEEJA NULO A MARCA É CRIADA, SE NÃO A MARCA É ATUALIZADA
//------------------------------------------------------------------------------------------------------------------------
	
	public void salvar()
	{
		try
		{
			cadastroMarcaService.salvar(marca);
			if(this.marca.getCodigo() == null)
			{
				FacesUtil.addInfoMessage("Marca '"+this.marca.getNome()+"' salva com Sucesso!");
			}else
			{
				FacesUtil.addInfoMessage("Marca '"+this.marca.getNome()+"' atualizada com Sucesso!");
			}
			limpar();
		}catch(NegocioException e)
		{
			FacesUtil.addErrorMessage(e.getMessage());
		}
	}

	
	public Marca getMarca() {
		return marca;
	}

	public void setMarca(Marca marca) {
		this.marca = marca;
	}
	
	
}
