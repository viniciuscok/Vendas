package br.com.vendas.converter;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;
import javax.inject.Inject;

import br.com.vendas.dao.CadastroClienteDAO;
import br.com.vendas.model.Cliente;
import br.com.vendas.util.cdi.CDIServiceLocator;

@FacesConverter(forClass=Cliente.class)
public class ClienteConverter implements Converter
{
	
	//@Inject
	private CadastroClienteDAO CadastroClienteDAO;

	public ClienteConverter() 
	{
		this.CadastroClienteDAO = (CadastroClienteDAO) CDIServiceLocator.getBean(CadastroClienteDAO.class);
	}
	@Override
	public Object getAsObject(FacesContext context, UIComponent component, String value) 
	{
		Cliente retorno = null;
		if(value != null)
		{
			Long codigo = new Long(value);
			retorno = this.CadastroClienteDAO.porCodigo(codigo);
		}
		return retorno;
	}

	@Override
	public String getAsString(FacesContext context, UIComponent component, Object value)
	{
		if (value != null) 
		{
			Cliente cliente = (Cliente) value;
			return cliente.getCodigo() == null ? null:cliente.toString();
		}
		return "";
		
	}

}
