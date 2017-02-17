package br.com.vendas.model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Transient;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.NotBlank;

import br.com.vendas.validation.CPFCNPJ;

@Entity
@Table(name="cliente")
public class Cliente implements Serializable
{

	private static final long serialVersionUID = 1L;
	
	private Long codigo;
	private String nome;
	private String documento;
	private Date dataCadastro;
	private String observacao;
	private TipoPessoa tipoPessoa;
	private Contato contato;
	private Endereco endereco;
	//private List<Endereco> enderecos;
	//private List<Contato> contatos;
	
												//Método construtor 
//------------------------------------------------------------------------------------------------------------------------
		
//Construtor atribuindo o tipo de pessoa como física
	public Cliente() 
	{
		this.tipoPessoa = TipoPessoa.FISICA;
		//this.enderecos = new ArrayList<>();
		//this.contatos = new ArrayList<>();
	}

												//Método getters e Setters 
//------------------------------------------------------------------------------------------------------------------------
				
//
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="cod_cliente", nullable=false, unique=true)
	public Long getCodigo() {
		return codigo;
	}

	public void setCodigo(Long codigo) {
		this.codigo = codigo;
	}

	@NotBlank 
	@Column(name="nm_cliente", nullable=false, length=100)
	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	@CPFCNPJ @Size(max=30)
	@Column(name="nr_documento", nullable=false, unique=true, length=30)
	public String getDocumento() {
									
		return documento;
	}

	public void setDocumento(String documento) 
	{
		
		this.documento = documento;
	}
	
	//Anotações de data pegando a data e as horas
	@NotNull
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="data_cadastro", nullable=false)
	public Date getDataCadastro() {
		return dataCadastro;
	}

	public void setDataCadastro(Date dataCadastro) {
		this.dataCadastro = dataCadastro;
	}
	
	@Column(name="nm_observacao", nullable=true, columnDefinition="text")
	public String getObservacao() {
		return observacao;
	}

	public void setObservacao(String observacao) {
		this.observacao = observacao;
	}
	
	@NotNull
	@Enumerated(EnumType.STRING)
	@Column(name="tipo_pessoa", nullable=false, length=30)
	public TipoPessoa getTipoPessoa() {
		return tipoPessoa;
	}

	public void setTipoPessoa(TipoPessoa tipoPessoa) {
		this.tipoPessoa = tipoPessoa;
	}
	
	//@NotNull
	//@OneToMany(mappedBy="cliente", cascade= CascadeType.ALL)
	//@OneToMany(cascade = CascadeType.ALL)
	//public List<Endereco> getEnderecos() {
	//	return enderecos;
	//}

	//public void setEnderecos(List<Endereco> enderecos) {
	//	this.enderecos = enderecos;
	//}
	
	//@NotNull
	//@OneToMany(mappedBy="cliente", cascade= CascadeType.ALL)
	//@OneToMany(cascade = CascadeType.ALL)
	//public List<Contato> getContatos() {
	//	return contatos;
	//}

	//public void setContatos(List<Contato> contatos) {
	//	this.contatos = contatos;
	//}
	
	//Mapeamento um para um com cascadetype.all
	@NotNull
	@OneToOne(cascade=CascadeType.ALL)
	@JoinColumn(name="cod_contato")
	public Contato getContato() {
		return contato;
	}
	
	public void setContato(Contato contato) {
		this.contato = contato;
	}

	//Mapeamento um para um com cascadetype.all
	@NotNull
	@OneToOne(cascade=CascadeType.ALL)
	@JoinColumn(name="cod_endereco")
	public Endereco getEndereco() {
		return endereco;
	}

	public void setEndereco(Endereco endereco) {
		this.endereco = endereco;
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
		Cliente other = (Cliente) obj;
		if (codigo == null) {
			if (other.codigo != null)
				return false;
		} else if (!codigo.equals(other.codigo))
			return false;
		return true;
	}
	
	@Transient
	public boolean isPessoaFisica()
	{
		return TipoPessoa.FISICA !=null && tipoPessoa.equals(TipoPessoa.FISICA);
	}								
	

}
