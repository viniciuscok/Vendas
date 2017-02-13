/*package br.com.vendas.converter;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;

import br.com.vendas.dao.CadastroSubcategoriaDAO;
import br.com.vendas.model.SubCategoria;
import br.com.vendas.util.cdi.CDIServiceLocator;

@FacesConverter(forClass = SubCategoria.class)
public class SubcategoriaConverter implements Converter
{

	//@Inject
	private CadastroSubcategoriaDAO cadastroSubcategoriaDAO;

	public SubcategoriaConverter() 
	{
		this.cadastroSubcategoriaDAO = (CadastroSubcategoriaDAO) CDIServiceLocator.getBean(CadastroSubcategoriaDAO.class);
	}
	@Override
	public Object getAsObject(FacesContext context, UIComponent component, String value) 
	{
		SubCategoria retorno = null;
		if(value != null)
		{
			Long codigo = new Long(value);
			retorno = this.cadastroSubcategoriaDAO.porCodigo(codigo);
		}
		return retorno;
	}

	@Override
	public String getAsString(FacesContext context, UIComponent component, Object value)
	{
		if (value != null) 
		{
			SubCategoria subCategoria = (SubCategoria) value;
			return subCategoria.getCodigo() == null ? null:subCategoria.toString();
		}
		return "";
			
	}


}
*/