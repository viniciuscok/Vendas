package br.com.vendas.controller;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

import br.com.vendas.dao.CadastroMarcaDAO;
import br.com.vendas.dao.filter.MarcaFilter;
import br.com.vendas.model.Marca;
import br.com.vendas.service.NegocioException;
import br.com.vendas.util.jsf.FacesUtil;

@Named
@ViewScoped
public class PesquisaMarcaBean implements Serializable
{

	private static final long serialVersionUID = 1L;
	
	@Inject
	private CadastroMarcaDAO cadastroMarcaDAO;
	
	private List<Marca> marcas;
	private Marca marcaSelecionada;
	private MarcaFilter marcaFilter;
	
	@PostConstruct
	public void inicializar()
	{
		limpar();
	}
	
	public void limpar()
	{
		this.marcaFilter = new MarcaFilter();
		this.marcas = new ArrayList<>();
	}
	
	public void remover()
	{
		try
		{
			cadastroMarcaDAO.remover(marcaSelecionada);
			marcas.remove(marcaSelecionada);
			FacesUtil.addInfoMessage("Marca '"+marcaSelecionada.getNome()+"' excluída com Sucesso");
		}catch(NegocioException e)
		{
			FacesUtil.addErrorMessage(e.getMessage());
		}
		
	}
	
	public void buscarPorNome()
	{
		this.marcas = cadastroMarcaDAO.bucarPorNome(this.marcaFilter.getNome());
	}
	
											//MÉTODOS GETTERS E SETTERS	
//------------------------------------------------------------------------------------------------------------------------
					
	public MarcaFilter getMarcaFilter() {
		return marcaFilter;
	}

	public void setMarcaFilter(MarcaFilter marcaFilter) {
		this.marcaFilter = marcaFilter;
	}

	public List<Marca> getMarcas() {
		return marcas;
	}

	public void setMarcas(List<Marca> marcas) {
		this.marcas = marcas;
	}

	public Marca getMarcaSelecionada() {
		return marcaSelecionada;
	}

	public void setMarcaSelecionada(Marca marcaSelecionada) {
		this.marcaSelecionada = marcaSelecionada;
	}

	
	
}
