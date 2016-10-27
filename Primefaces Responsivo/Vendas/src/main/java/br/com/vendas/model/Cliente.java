package br.com.vendas.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.Entity;

@Entity
public class Cliente implements Serializable
{

	private static final long serialVersionUID = 1L;
	
	private Long codigo;
	private String nome;
	private String documento;
	private Date dataCadastro;
	private String observacao;
	private TipoPessoa tipoPessoa;
	private List<Endereco> enderecos;
	private List<Contato> contatos;
	
												//Método construtor 
//------------------------------------------------------------------------------------------------------------------------
		
//Construtor inicializando minha lista de endereços, lista de contatos e atribuindo o tipo de pessoa como fisica.
	public Cliente() 
	{
		this.tipoPessoa = TipoPessoa.FISICA;
		this.enderecos = new ArrayList<>();
		this.contatos = new ArrayList<>();
	}

												//Método getters e Setters 
//------------------------------------------------------------------------------------------------------------------------
				
//
	public Long getCodigo() {
		return codigo;
	}

	public void setCodigo(Long codigo) {
		this.codigo = codigo;
	}

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

	public Date getDataCadastro() {
		return dataCadastro;
	}

	public void setDataCadastro(Date dataCadastro) {
		this.dataCadastro = dataCadastro;
	}

	public String getObservacao() {
		return observacao;
	}

	public void setObservacao(String observacao) {
		this.observacao = observacao;
	}

	public TipoPessoa getTipoPessoa() {
		return tipoPessoa;
	}

	public void setTipoPessoa(TipoPessoa tipoPessoa) {
		this.tipoPessoa = tipoPessoa;
	}

	public List<Endereco> getEnderecos() {
		return enderecos;
	}

	public void setEnderecos(List<Endereco> enderecos) {
		this.enderecos = enderecos;
	}

	public List<Contato> getContatos() {
		return contatos;
	}

	public void setContatos(List<Contato> contatos) {
		this.contatos = contatos;
	}
	
											
	

}
