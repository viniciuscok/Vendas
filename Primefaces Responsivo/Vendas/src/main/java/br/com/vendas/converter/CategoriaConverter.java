package br.com.vendas.converter;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;

import br.com.vendas.dao.CadastroCategoriaDAO;
import br.com.vendas.model.Categoria;
import br.com.vendas.util.cdi.CDIServiceLocator;

@FacesConverter(forClass=Categoria.class)
public class CategoriaConverter implements Converter{

	//@Inject
	private CadastroCategoriaDAO cadastroCategoriaDAO;

	public CategoriaConverter() 
	{
		this.cadastroCategoriaDAO = CDIServiceLocator.getBean(CadastroCategoriaDAO.class);
	}
	@Override
	public Object getAsObject(FacesContext context, UIComponent component, String value) 
	{
		Categoria retorno = null;
		if(value != null)
		{
			Long codigo = new Long(value);
			retorno = this.cadastroCategoriaDAO.porCodigo(codigo);
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
			
			Categoria categoria = (Categoria) value;
			return categoria.getCodigo() == null ? null : categoria.getCodigo().toString();
		}
		
		return "";
		
	}

}
