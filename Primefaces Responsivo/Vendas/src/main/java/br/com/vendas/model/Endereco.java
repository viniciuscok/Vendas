package br.com.vendas.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.NotBlank;

@Entity
@Table(name="endereco")
public class Endereco implements Serializable
{
	private static final long serialVersionUID = 1L;
	
	private Long codigo;
	private String logradouro;
	private String bairro;
	private String numero;
	private String complemento;
	private String cidade;
	private String cep;
	private String uf;
	//private Cliente cliente;


											//Método construtor 
//------------------------------------------------------------------------------------------------------------------------

//Construtor padrão
	public Endereco() {
		// TODO Auto-generated constructor stub
	}
	
											//Método getters e setters 
//------------------------------------------------------------------------------------------------------------------------

//
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="cod_endereco", nullable=false, unique=true)
	public Long getCodigo() {
		return codigo;
	}


	public void setCodigo(Long codigo) {
		this.codigo = codigo;
	}
	

	@NotBlank @Size(max=100)
	@Column(name="nm_logradourao", nullable=false, length=100)
	public String getLogradouro() {
		return logradouro;
	}


	public void setLogradouro(String logradouro) {
		this.logradouro = logradouro;
	}

	@NotBlank @Size(max=100)
	@Column(name="nr_casa", nullable=false, length=100)
	public String getNumero() {
		return numero;
	}

	public void setNumero(String numero) {
		this.numero = numero;
	}

	@Size(max=100)
	@Column(name="nm_complemento", nullable=true, length=100)
	public String getComplemento() {
		return complemento;
	}

	public void setComplemento(String complemento) {
		this.complemento = complemento;
	}
	
	@NotBlank @Size(max=100)
	@Column(name="nm_cidade", nullable=false, length=100)
	public String getCidade() {
		return cidade;
	}


	public void setCidade(String cidade) {
		this.cidade = cidade;
	}

	@Size(max=20)
	@Column(name="nr_cep", length=20)
	public String getCep() {
		return cep;
	}


	public void setCep(String cep) {
		this.cep = cep;
	}

	@NotBlank @Size(max=20)
	@Column(name="nm_uf", nullable=false, length=20)
	public String getUf() {
		return uf;
	}


	public void setUf(String uf) {
		this.uf = uf;
	}

	//@ManyToOne
	//@JoinColumn(name="cod_cliente")
	//public Cliente getCliente() {
	//	return cliente;
	//}


	//public void setCliente(Cliente cliente) {
	//	this.cliente = cliente;
	//}
	
	@NotBlank @Size(max=100)
	@Column(name="nm_bairro", nullable=false, length=100)
	public String getBairro() {
		return bairro;
	}

	public void setBairro(String bairro) {
		this.bairro = bairro;
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
		Endereco other = (Endereco) obj;
		if (codigo == null) {
			if (other.codigo != null)
				return false;
		} else if (!codigo.equals(other.codigo))
			return false;
		return true;
	}

}
