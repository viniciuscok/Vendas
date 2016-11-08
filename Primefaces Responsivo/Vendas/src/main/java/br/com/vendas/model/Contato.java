package br.com.vendas.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.NotBlank;

@Entity
@Table(name="contato")
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
	private Cliente cliente;

												//Método construtor 
//------------------------------------------------------------------------------------------------------------------------

//Construtor padrão
	public Contato()
	{
		
	}

												//Método getters e setters 
//------------------------------------------------------------------------------------------------------------------------

//
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="cod_contato", unique=true, nullable=false)
	public Long getCodigo() {
		return codigo;
	}

	public void setCodigo(Long codigo) {
		this.codigo = codigo;
	}
	
	@NotNull @NotBlank @Size(max=20)
	@Column(name="nr_telefone", nullable=true, length=20)
	public String getTelefone() {
		return telefone;
	}

	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}

	@Email @Size(max=100)
	@Column(name="nm_email", nullable=true, length=100)
	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	@Size(max=20)
	@Column(name="nr_celular", nullable=false, length=20)
	public String getCelular() {
		return celular;
	}

	public void setCelular(String celular) {
		this.celular = celular;
	}

	@Size(max=20)
	@Column(name="nr_whatsapp", nullable=true, length=20)
	public String getWhatsapp() {
		return whatsapp;
	}

	public void setWhatsapp(String whatsapp) {
		this.whatsapp = whatsapp;
	}

	@Column(name="nm_site", nullable=true, length=100)
	public String getSite() {
		return site;
	}

	public void setSite(String site) {
		this.site = site;
	}

	@ManyToOne
	@JoinColumn(name="cod_cliente")
	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

							//Métodos Equals() e Hashcode()  
//------------------------------------------------------------------------------------------------------------------------

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((codigo == null) ? 0 : codigo.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Contato other = (Contato) obj;
		if (codigo == null) {
			if (other.codigo != null)
				return false;
		} else if (!codigo.equals(other.codigo))
			return false;
		return true;
	}
	
	
	
}
