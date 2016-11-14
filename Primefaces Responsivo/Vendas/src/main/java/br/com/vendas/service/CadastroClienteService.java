package br.com.vendas.service;

import java.io.Serializable;

import javax.inject.Inject;

import br.com.vendas.dao.CadastroClienteDAO;
import br.com.vendas.model.Cliente;
import br.com.vendas.util.jpa.Transactional;


public class CadastroClienteService implements Serializable
{

	private static final long serialVersionUID = 1L;
	
	@Inject
	private CadastroClienteDAO cadastroClienteDAO;
	
					//MÉTODO SALVAR UM CLIENTE COM UMA REGRA DE NÉGOCIO ONDE SE O CLIENTE, ENDEREÇO E CONTATO 
					//ESTIVEREM NULOS O CLIENTE NÃO SERÁ CADASTRADO.
//------------------------------------------------------------------------------------------------------------------------
		
	@Transactional
	public void salvar(Cliente cliente) throws NegocioException
	{
		if(cliente.getNome().trim().equals("") || cliente.getContatos()== null || cliente.getEnderecos()==null)
		{
			new NegocioException("Usuário não pode ser cadastrado");
		}
		
		cadastroClienteDAO.salvar(cliente);
	}
	

}
