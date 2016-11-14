package br.com.vendas.dao.filter;

import java.io.Serializable;

public class ClienteFilter implements Serializable
{
	private static final long serialVersionUID = 1L;
	
	private String nome;
	private String documento;
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getDocumento() {
		return documento;
	}
	public void setDocumento(String documento) {
		this.documento = documento;
	}
	
	
		
		
	

}
