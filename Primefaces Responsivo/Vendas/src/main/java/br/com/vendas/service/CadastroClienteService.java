package br.com.vendas.service;

import java.io.Serializable;

import javax.inject.Inject;
import javax.persistence.NoResultException;

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
	public void salvar(Cliente cliente) throws NegocioException, NoResultException
	{
		if(cliente.getNome().trim().equals("") || cliente.getContato()== null || cliente.getEndereco()==null)
		{
			throw new NegocioException("Usuário não pode ser cadastrado");
		}
		
		//VERIFICANDO SE O CODIGO DO CLIENTE É NULO E SE O CPF JÁ FOI CADASTRADO, CASO SEJA VERDADEIRO ELE NÃO DEIXA,
		//CADASTRAR DOIS CPF IGUAIS.
		if(cliente.getCodigo() == null && cadastroClienteDAO.buscarCPF(cliente.getDocumento()).equals(cliente.getDocumento()))
		{
			throw new NegocioException("CPF já Cadastrado");	
		}
		
		cadastroClienteDAO.salvar(cliente);
			
	}
}
