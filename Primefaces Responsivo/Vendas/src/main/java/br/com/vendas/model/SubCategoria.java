package br.com.vendas.model;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.NotBlank;

@Entity
@Table(name = "subcategoria")
public class SubCategoria implements Serializable
{
	private static final long serialVersionUID = 1L;
	
	private Long codigo;
	private Categoria categoria;
	private String nome;
	private String descricao;
	
												//Método construtor 
//------------------------------------------------------------------------------------------------------------------------
	//
	public SubCategoria()
	{
		
	}
	
												//Método getters e Setters 
//------------------------------------------------------------------------------------------------------------------------
	//
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="cod_subcategoria", nullable=false, unique=true)
	public Long getCodigo() {
		return codigo;
	}
	
	public void setCodigo(Long codigo) {
		this.codigo = codigo;
	}
	
	@NotNull
	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "cod_categoria", nullable = false, unique = false)
	public Categoria getCategoria() {
		return categoria;
	}
	
	public void setCategoria(Categoria categoria) {
		this.categoria = categoria;
	}
	
	@NotBlank
	@Column(name = "nm_subcategoria", nullable = false, unique = false, length = 100)
	public String getNome() {
		return nome;
	}
	
	public void setNome(String nome) {
		this.nome = nome;
	}
	
	@NotBlank
	@Column(name="nm_descricao", nullable = true, unique = false, length= 100)
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
		SubCategoria other = (SubCategoria) obj;
		if (codigo == null) {
			if (other.codigo != null)
				return false;
		} else if (!codigo.equals(other.codigo))
			return false;
		return true;
	}
	
	
	

}
