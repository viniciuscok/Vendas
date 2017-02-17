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
	
									//Método PARA INICIAR UM CLIENTE CASO SEJA NULL
									//@PostConstruct = É CARREGADO ANTES DE ABRIR A PÁGINA
//------------------------------------------------------------------------------------------------------------------------

	@PostConstruct
	public void init()
	{
		if(this.cliente == null)
		{
			limpar();
		}
		
	}
	
									//Método CHAMADO PARA LIMPAR A TELA QUANDO O USUÁRIO FOR CADASTRADO
									//MÉTODO INICIA UM NOVO CLIENTE, CONTATO E ENDERECO QUANDO E CHAMADO.
//------------------------------------------------------------------------------------------------------------------------
						
	public void limpar()
	{
		this.cliente = new Cliente();
		this.contato = new Contato();
		this.endereco = new Endereco();
	}
							//MÉTODO PARA SALVA E ATUALIZAR O CLIENTE, VERIFICANDO SE O CÓDIGO DO CLIENTE E NULO OU NÃO.	
//------------------------------------------------------------------------------------------------------------------------

	public void salvar()
	{
		try 
		{
			
			this.cadastroClienteService.salvar(cliente);
			
			if(this.cliente.getCodigo() == null)
			{
				FacesUtil.addInfoMessage("Cliente '"+cliente.getNome()+"' salvo com sucesso");
				limpar();
			}else
			{
				FacesUtil.addInfoMessage("Cliente '"+cliente.getNome()+"' atualizado com sucesso");
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
		}else
		{
			this.cliente.getContato();
		}
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

							//MÉTODO PARA ADICIONAR UM CONTATO DO CLIENTE 	
//------------------------------------------------------------------------------------------------------------------------
		
	
	public void adicionarContato()
	{
		//this.cliente.getContatos().add(contato); certo
		this.cliente.setContato(contato);
		//this.cliente.setContatos(contatos);
		
	}
	
							//MÉTODO PARA ADICIONAR UM ENDEREÇO DO CLIENTE.	
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
