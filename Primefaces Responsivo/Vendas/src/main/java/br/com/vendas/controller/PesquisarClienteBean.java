package br.com.vendas.controller;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

import br.com.vendas.dao.CadastroClienteDAO;
import br.com.vendas.dao.filter.ClienteFilter;
import br.com.vendas.model.Cliente;
import br.com.vendas.service.NegocioException;
import br.com.vendas.util.jsf.FacesUtil;

@Named
@ViewScoped
public class PesquisarClienteBean implements Serializable
{

	private static final long serialVersionUID = 1L;
	
	@Inject
	private CadastroClienteDAO cadastroClienteDAO;
	
	private List<Cliente> clientes;
	
	private Cliente cliente;
	
	private ClienteFilter clienteFiltro;
	
	@PostConstruct
	public void init()
	{
		clienteFiltro = new ClienteFilter();
		clientes = new ArrayList<>();
	}
	
	public void buscarTodos()
	{
		try
		{
			this.clientes = cadastroClienteDAO.buscarTodos(clienteFiltro);
			
		}catch (NegocioException e) 
		{
			FacesUtil.addErrorMessage(e.getMessage());
		}
	}

	
	public List<Cliente> getClientes() {
		return clientes;
	}

	public void setClientes(List<Cliente> clientes) {
		this.clientes = clientes;
	}

	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

	public ClienteFilter getClienteFiltro() {
		return clienteFiltro;
	}

	public void setClienteFiltro(ClienteFilter clienteFiltro) {
		this.clienteFiltro = clienteFiltro;
	}
	
	
	

}