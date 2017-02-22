package br.com.vendas.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;

import org.hibernate.validator.constraints.NotBlank;

@Entity
@Table(name="marca")
public class Marca implements Serializable
{
	private static final long serialVersionUID = 1L;
	
	private Long codigo;
	private String nome;
	
														//Método construtor 
//------------------------------------------------------------------------------------------------------------------------

	public Marca()
	{
		
	}
	
														//Método getters e setters 
//------------------------------------------------------------------------------------------------------------------------

	@Id
	@GeneratedValue
	@Column(name="cod_marca", nullable=false, unique=true)
	public Long getCodigo() {
		return codigo;
	}

	public void setCodigo(Long codigo) {
		this.codigo = codigo;
	}
	
	@NotBlank
	@Column(name="nm_marca", nullable=false, unique=true)
	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
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
		Marca other = (Marca) obj;
		if (codigo == null) {
			if (other.codigo != null)
				return false;
		} else if (!codigo.equals(other.codigo))
			return false;
		return true;
	}
	
	@Transient
	public boolean isCodigoNull()
	{
		return this.codigo == null;
	}
	
}
