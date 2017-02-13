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
	
	private Cliente clienteSelecionado;
	
								//MÉTODO PARA INICIAR O CLIENTE AO CARREGAR A PÁGINA 		
//------------------------------------------------------------------------------------------------------------------------

	@PostConstruct
	public void init()
	{
		limpar();
	}
	
								//MÉTODO PARA BUSCAR TODOS OS CLIENTES 		
//------------------------------------------------------------------------------------------------------------------------

	public void buscarTodos()
	{
		try
		{
			this.clientes = cadastroClienteDAO.buscarTodos();
			
		}catch (NegocioException e) 
		{
			FacesUtil.addErrorMessage(e.getMessage());
		}
	}
	
							//MÉTODO PARA BUSCAR O CLIENTE PASSANDO NOME OU UM CPF COMO PARAMETRO 		
//------------------------------------------------------------------------------------------------------------------------

	public void porNomeCPF()
	{
		try
		{
			this.clientes = cadastroClienteDAO.porNomeCPF(clienteFiltro);
			
		}catch (NegocioException e) 
		{
			FacesUtil.addErrorMessage(e.getMessage());
		}
	}
	
	public void remover()
	{
		try
		{
			cadastroClienteDAO.remover(clienteSelecionado);
			clientes.remove(clienteSelecionado);
			FacesUtil.addInfoMessage("O cliente '"+clienteSelecionado.getNome()+"' foi removido com sucesso!");
		}catch(NegocioException cause)
		{
			FacesUtil.addErrorMessage("Cliente não pode ser removido");
		}
	}
	
											//MÉTODO PARA LIMPAR OS CAMPOS NA TELA 		
//------------------------------------------------------------------------------------------------------------------------

	public void limpar()
	{
		clienteFiltro = new ClienteFilter();
		clientes = new ArrayList<>();
	}

											//MÉTODO GETTERS E SETTERS 		
//------------------------------------------------------------------------------------------------------------------------

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

	public Cliente getClienteSelecionado() {
		return clienteSelecionado;
	}

	public void setClienteSelecionado(Cliente clienteSelecionado) {
		this.clienteSelecionado = clienteSelecionado;
	}
	
	
	

}
