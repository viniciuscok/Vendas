package br.com.vendas.model;

import java.io.Serializable;

public class Endereco implements Serializable
{
	private static final long serialVersionUID = 1L;
	
	private Long codigo;
	private String logradouro;
	private String numero;
	private String complemento;
	private String cidade;
	private String cep;
	private String uf;
	private Cliente cliente;


											//Método construtor 
//------------------------------------------------------------------------------------------------------------------------

//Construtor padrão
	public Endereco()
	{
		
	}

											//Método getters e setters 
//------------------------------------------------------------------------------------------------------------------------

//
	public Long getCodigo() {
		return codigo;
	}


	public void setCodigo(Long codigo) {
		this.codigo = codigo;
	}


	public String getLogradouro() {
		return logradouro;
	}


	public void setLogradouro(String logradouro) {
		this.logradouro = logradouro;
	}


	public String getNumero() {
		return numero;
	}


	public void setNumero(String numero) {
		this.numero = numero;
	}


	public String getComplemento() {
		return complemento;
	}


	public void setComplemento(String complemento) {
		this.complemento = complemento;
	}


	public String getCidade() {
		return cidade;
	}


	public void setCidade(String cidade) {
		this.cidade = cidade;
	}


	public String getCep() {
		return cep;
	}


	public void setCep(String cep) {
		this.cep = cep;
	}


	public String getUf() {
		return uf;
	}


	public void setUf(String uf) {
		this.uf = uf;
	}


	public Cliente getCliente() {
		return cliente;
	}


	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}
	
	
}
