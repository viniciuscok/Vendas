package br.com.vendas.converter;

import javax.enterprise.inject.spi.CDI;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;

import br.com.vendas.dao.CadastroProdutoDAO;
import br.com.vendas.model.Marca;
import br.com.vendas.model.Produto;
import br.com.vendas.util.cdi.CDIServiceLocator;

@FacesConverter(forClass= Produto.class)
public class ProdutoConverter implements Converter
{

	private CadastroProdutoDAO cadastroProdutoDAO;
	
	public ProdutoConverter() 
	{
		this.cadastroProdutoDAO = (CadastroProdutoDAO) CDIServiceLocator.getBean(CadastroProdutoDAO.class);
	}
	@Override
	public Object getAsObject(FacesContext context, UIComponent component, String value) 
	{
		Produto retorno = null;
		if(value != null)
		{
			Long codigo = new Long(value);
			retorno = this.cadastroProdutoDAO.porCodigo(codigo);
			
		}
		return retorno;
	}

	@Override
	public String getAsString(FacesContext context, UIComponent component, Object value) 
	{
		if (value != null) 
		{
			//Categoria categoria = (Categoria) value;
			//return ((Categoria) value).getCodigo().toString();
			
			Produto produto = (Produto) value;
			return produto.getCodigo() == null ? null : produto.getCodigo().toString();
		}
		
		return "";
	}

}
