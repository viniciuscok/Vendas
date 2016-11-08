package br.com.vendas.controller;

import java.io.Serializable;

import javax.annotation.PostConstruct;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

import br.com.vendas.model.Cliente;
import br.com.vendas.model.Contato;
import br.com.vendas.model.TipoPessoa;
import br.com.vendas.service.CadastroClienteService;
import br.com.vendas.service.NegocioException;
import br.com.vendas.util.jsf.FacesUtil;

@Named
@ViewScoped
public class CadastroClienteBean implements Serializable
{
	private static final long serialVersionUID = 1L;
	
	@Inject
	private CadastroClienteService cadastroClienteService;
	
	private Cliente cliente;
	
	private Contato contato;
	
	public CadastroClienteBean()
	{
		this.cliente = new Cliente();
		this.contato = new Contato();
	}
	
	public void salvar()
	{
		try 
		{
			this.cadastroClienteService.salvar(cliente);
			FacesUtil.addInfoMessage("cliente salvo com sucesso");
		} catch (NegocioException e) 
		{
			FacesUtil.addErrorMessage(e.getMessage());
		}
	}
	
	public void novoContato()
	{
		if(contato == null)
		{
			this.contato = new Contato();
		}else
		{
			this.cliente.getContatos();
		}
	}

	public void adicionarContato()
	{
		this.cliente.getContatos().add(contato);
		this.contato.setCliente(cliente);
		
	}
	public TipoPessoa[] getTipoPessoas()
	{
		return TipoPessoa.values();
	}
	
	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

	public Contato getContato() {
		return contato;
	}

	public void setContato(Contato contato) {
		this.contato = contato;
	}
	
	
	

}
