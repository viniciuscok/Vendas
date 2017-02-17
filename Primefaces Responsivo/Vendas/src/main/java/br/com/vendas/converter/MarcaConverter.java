package br.com.vendas.converter;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;

import br.com.vendas.dao.CadastroMarcaDAO;
import br.com.vendas.model.Marca;
import br.com.vendas.util.cdi.CDIServiceLocator;

@FacesConverter(forClass = Marca.class)
public class MarcaConverter implements Converter 
{

	//@Inject
		private CadastroMarcaDAO cadastroMarcaDAO;

		public MarcaConverter() 
		{
			this.cadastroMarcaDAO = (CadastroMarcaDAO) CDIServiceLocator.getBean(CadastroMarcaDAO.class);
		}
		@Override
		public Object getAsObject(FacesContext context, UIComponent component, String value) 
		{
			Marca retorno = null;
			if(value != null)
			{
				Long codigo = new Long(value);
				retorno = this.cadastroMarcaDAO.porCodigo(codigo);
				
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
				
				Marca marca = (Marca) value;
				return marca.getCodigo() == null ? null : marca.getCodigo().toString();
			}
			
			return "";
			
		}

}
