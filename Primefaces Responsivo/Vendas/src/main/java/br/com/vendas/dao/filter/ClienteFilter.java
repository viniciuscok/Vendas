package br.com.vendas.dao.filter;

import java.io.Serializable;

public class ClienteFilter implements Serializable
{
	private static final long serialVersionUID = 1L;
	
	private String nome;
	//private String documento;
	private String cpf;
	private String cnpj;
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	//public String getDocumento() {
		//return documento;
	//}
	//public void setDocumento(String documento) {
	///	this.documento = documento;
	//}
	public String getCpf() {
		return cpf;
	}
	public void setCpf(String cpf) {
		this.cpf = cpf;
	}
	public String getCnpj() {
		return cnpj;
	}
	public void setCnpj(String cnpj) {
		this.cnpj = cnpj;
	}
	
	
		
		
	

}
