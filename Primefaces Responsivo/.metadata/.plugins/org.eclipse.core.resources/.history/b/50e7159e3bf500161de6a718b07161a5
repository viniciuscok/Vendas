package br.com.vendas.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.validator.constraints.NotBlank;

@Entity
@Table(name="categoria")
public class Categoria implements Serializable
{

	private static final long serialVersionUID = 1L;
	
	private Long codigo;
	private String nome;
	private String descricao;
	
												//Método construtor 
//------------------------------------------------------------------------------------------------------------------------
	//
	public Categoria() 
	{
		
	}
	
												//Método getters e Setters 
//------------------------------------------------------------------------------------------------------------------------
	//
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="cod_categoria", nullable=false, unique=true)
	public Long getCodigo() {
		return codigo;
	}
	
	public void setCodigo(Long codigo) {
		this.codigo = codigo;
	}
	
	@NotBlank
	@Column(name="nm_categoria", nullable=false, unique=true, length=100)
	public String getNome() {
		return nome;
	}
	
	public void setNome(String nome) {
		this.nome = nome;
	}
	
	@Column(name="nm_descricao", nullable=true, unique=false)
	public String getDescricao() {
		return descricao;
	}
	
	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	
											//Método Equals() e Hashcode() 
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
		Categoria other = (Categoria) obj;
		if (codigo == null) {
			if (other.codigo != null)
				return false;
		} else if (!codigo.equals(other.codigo))
			return false;
		return true;
	}
	
	
	
	

}
