package br.com.vendas.controller;

import java.io.Serializable;

import javax.annotation.PostConstruct;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

import br.com.vendas.model.Cliente;
import br.com.vendas.model.Contato;
import br.com.vendas.model.Endereco;
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
	
	private Endereco endereco;
	
									//MÉTODO PARA INICIALIZAR O CLIENTE AO CARREGAR A PÁGINA		
//------------------------------------------------------------------------------------------------------------------------
	
	@PostConstruct
	public void init()
	{
		if(this.cliente == null)
		{
			limpar();
		}
		
	}
	
	
									//MÉTODO PARA SALVA O CLIENTE		
//------------------------------------------------------------------------------------------------------------------------

	public void salvar()
	{
		try 
		{
			
			this.cadastroClienteService.salvar(cliente);
			
			if(this.cliente.getCodigo() == null)
			{
				FacesUtil.addInfoMessage("cliente salvo com sucesso");
				limpar();
			}else
			{
				FacesUtil.addInfoMessage("cliente editado com sucesso");
				limpar();
			}
		
			
		} catch (NegocioException e) 
		{
			FacesUtil.addErrorMessage(e.getMessage());
		}
	}
	
				//MÉTODO PARA IDENTIFICAR SE O CONTATO ESTÁ NULO,SE TIVER NULO ELE CRIA UM NOVO CONTATO
				//CASO CONTRARIO ELE ABRE O CONTATO QUE JÁ FOI DIGITADO.
//------------------------------------------------------------------------------------------------------------------------

	public void novoContato()
	{
		if(contato == null)
		{
			this.contato = new Contato();
		}//else
		//{
		//	this.cliente.getContatos();
		//}
	}

					//MÉTODO PARA IDENTIFICAR SE O ENDEREÇO ESTÁ NULO,SE TIVER NULO ELE CRIA UM NOVO ENDEREÇO
					//CASO CONTRARIO ELE ABRE O ENDEREÇO QUE JÁ FOI DIGITADO.
//------------------------------------------------------------------------------------------------------------------------
			
	public void novoEndereco()
	{
		if(endereco == null)
		{
			this.endereco = new Endereco();
			
		}else
		{
			this.endereco = getEndereco();
		}
	}

							//MÉTODO PARA ADICIONAR UMA LISTA DE CONTATOS NO CLIENTE 	
//------------------------------------------------------------------------------------------------------------------------
		
	
	public void adicionarContato()
	{
		//this.cliente.getContatos().add(contato); certo
		this.cliente.setContato(contato);
		//this.cliente.setContatos(contatos);
		
	}
	
							//MÉTODO PARA ADICIONAR UMA LISTA DE ENDEREÇOS NO CLIENTE 	
//------------------------------------------------------------------------------------------------------------------------
	
	
	public void adicionarEndereco()
	{
		//this.cliente.getEnderecos().add(endereco);
		//this.cliente.getEnderecos().add(endereco); certo
		this.cliente.setEndereco(endereco);
		//this.cliente.setEnderecos(enderecos);
		
		//this.endereco.setCliente(cliente);
	}
	
									//MÉTODO QUE RETORNO UM ARRAY DE TIPOS DE PESSOAS 	
//------------------------------------------------------------------------------------------------------------------------
	
	public TipoPessoa[] getTipoPessoas()
	{
		return TipoPessoa.values();
	}
	
	public boolean isEditando()
	{
		return this.cliente.getCodigo() != null;
	}
	
									//Método para limpa os campos do cliente 
//------------------------------------------------------------------------------------------------------------------------
					
	public void limpar()
	{
		this.cliente = new Cliente();
		this.contato = new Contato();
		this.endereco = new Endereco();
	}
	
									//Método getters e Setters 
//------------------------------------------------------------------------------------------------------------------------
						
	public Cliente getCliente() 
	{
		return cliente;
	}

	public void setCliente(Cliente cliente) 
	{
		this.cliente = cliente;
		if(cliente != null)
		{
			//this.contato = this.cliente.getContatos().get(0);
			//this.endereco = this.cliente.getEnderecos().get(0);
			this.contato = this.cliente.getContato();
			this.endereco = this.cliente.getEndereco();
		}
	}

	public Contato getContato() 
	{
		return contato;
	}

	public void setContato(Contato contato) {
		this.contato = contato;
	}

	public Endereco getEndereco() {
		return endereco;
	}

	public void setEndereco(Endereco endereco) {
		this.endereco = endereco;
	}
	
	
	

}
