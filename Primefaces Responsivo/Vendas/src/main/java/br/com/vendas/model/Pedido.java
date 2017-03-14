package br.com.vendas.model;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.CreditCardNumber;

public class Pedido implements Serializable
{

	private static final long serialVersionUID = 1L;
	
	private Long codigo;
	private Date dataCriacao;
	private Date dataEntrega;
	private String observacao;
	private BigDecimal valorFrete;
	private BigDecimal valorDesconto;
	private BigDecimal valorTotal;
	private StatusPedido statusPedido;
	private FormaPagamento formaPagamento;
	private Usuario vendedor;
	private Cliente cliente;
	private Endereco enderecoEntrega;
	private List<ItemPedido> itemPedidos;
	
	public Pedido() 
	{
		this.itemPedidos = new ArrayList<>();
	}

	@Id
	@GeneratedValue(strategy= GenerationType.IDENTITY)
	@Column(name="cod_pedido", nullable = false, unique = true)
	public Long getCodigo() {
		return codigo;
	}

	public void setCodigo(Long codigo) {
		this.codigo = codigo;
	}

	@NotNull
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="data_criacao", nullable = false)
	public Date getDataCriacao() {
		return dataCriacao;
	}

	public void setDataCriacao(Date dataCriacao) {
		this.dataCriacao = dataCriacao;
	}

	@NotNull
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="data_entrega", nullable = false)
	public Date getDataEntrega() {
		return dataEntrega;
	}

	public void setDataEntrega(Date dataEntrega) {
		this.dataEntrega = dataEntrega;
	}

	@Column(name="obs", nullable= true)
	public String getObservacao() {
		return observacao;
	}

	public void setObservacao(String observacao) {
		this.observacao = observacao;
	}

	@NotNull
	@Column(name = "valor_frete", nullable = false, precision = 10, scale = 2)
	public BigDecimal getValorFrete() {
		return valorFrete;
	}

	public void setValorFrete(BigDecimal valorFrete) {
		this.valorFrete = valorFrete;
	}

	@NotNull
	@Column(name = "valor_desconto", nullable = false, precision = 10, scale = 2)
	public BigDecimal getValorDesconto() {
		return valorDesconto;
	}

	public void setValorDesconto(BigDecimal valorDesconto) {
		this.valorDesconto = valorDesconto;
	}

	@NotNull
	@Column(name = "valor_total", nullable = false, precision = 10, scale = 2)
	public BigDecimal getValorTotal() {
		return valorTotal;
	}

	public void setValorTotal(BigDecimal valorTotal) {
		this.valorTotal = valorTotal;
	}

	@NotNull
	@Enumerated(EnumType.STRING)
	@Column(name="status_pedido", nullable = false)
	public StatusPedido getStatusPedido() 
	{
		return statusPedido;
	}

	public void setStatusPedido(StatusPedido statusPedido) {
		this.statusPedido = statusPedido;
	}

	@NotNull
	@Enumerated(EnumType.STRING)
	@Column(name="forma_pagamento", nullable=false)
	public FormaPagamento getFormaPagamento() {
		return formaPagamento;
	}

	public void setFormaPagamento(FormaPagamento formaPagamento) {
		this.formaPagamento = formaPagamento;
	}

	@NotNull
	@ManyToOne
	@JoinColumn(name="cod_vendedor", nullable = false)
	public Usuario getVendedor() {
		return vendedor;
	}

	public void setVendedor(Usuario vendedor) {
		this.vendedor = vendedor;
	}

	@NotNull
	@ManyToOne
	@JoinColumn(name = "cod_cliente", nullable = false)
	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

	@NotNull
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name="cod_endereco_entrega", nullable=false)
	public Endereco getEnderecoEntrega() {
		return enderecoEntrega;
	}

	public void setEnderecoEntrega(Endereco enderecoEntrega) {
		this.enderecoEntrega = enderecoEntrega;
	}

	
	public List<ItemPedido> getItemPedidos() {
		return itemPedidos;
	}

	public void setItemPedidos(List<ItemPedido> itemPedidos) {
		this.itemPedidos = itemPedidos;
	}
	
	
	

}
