package br.com.vendas.model;

import java.io.Serializable;

public class Contato implements Serializable
{
	private static final long serialVersionUID = 1L;
	
	//atributos da classe contato
	private Long codigo;
	private String telefone;
	private String email;
	private String celular;
	private String whatsapp;
	private String site;

												//Método construtor 
//------------------------------------------------------------------------------------------------------------------------

//Construtor padrão
	public Contato()
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

	public String getTelefone() {
		return telefone;
	}

	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getCelular() {
		return celular;
	}

	public void setCelular(String celular) {
		this.celular = celular;
	}

	public String getWhatsapp() {
		return whatsapp;
	}

	public void setWhatsapp(String whatsapp) {
		this.whatsapp = whatsapp;
	}

	public String getSite() {
		return site;
	}

	public void setSite(String site) {
		this.site = site;
	}
	
	
}
