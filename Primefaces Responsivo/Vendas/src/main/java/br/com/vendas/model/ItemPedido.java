package br.com.vendas.model;

import java.io.Serializable;
import java.math.BigDecimal;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

//@Entity
//@Table(name="itemPedido")
public class ItemPedido implements Serializable
{
	private static final long serialVersionUID = 1L;
	
	private Long codigo;
	private Integer quantidade;
	private BigDecimal valorMetro;
	private Double largura;
	private Double altura;
	private Produto produto;
	private Pedido pedido;
	
	public ItemPedido()
	{
		
	}
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="cod_item", nullable=false, unique=true)
	public Long getCodigo() {
		return codigo;
	}
	public void setCodigo(Long codigo) {
		this.codigo = codigo;
	}
	
	@NotNull
	@Column(name="nr_quantidade", nullable = false, unique=false)
	public Integer getQuantidade() {
		return quantidade;
	}
	public void setQuantidade(Integer quantidade) {
		this.quantidade = quantidade;
	}
	
	@NotNull
	@Column(name="valor_metro", nullable=false)
	public BigDecimal getValorMetro() {
		return valorMetro;
	}
	public void setValorMetro(BigDecimal valorMetro) {
		this.valorMetro = valorMetro;
	}
	
	@NotNull
	@ManyToOne
	@JoinColumn(name="cod_produto", nullable=false)
	public Produto getProduto() {
		return produto;
	}
	public void setProduto(Produto produto) {
		this.produto = produto;
	}
	
	@NotNull
	@ManyToOne
	@JoinColumn(name="cod_pedido", nullable=false)
	public Pedido getPedido() {
		return pedido;
	}
	public void setPedido(Pedido pedido) {
		this.pedido = pedido;
	}

	@NotNull
	@Size(max=10)
	@Column(name="largura", nullable=false, length=10)
	public Double getLargura() {
		return largura;
	}

	public void setLargura(Double largura) {
		this.largura = largura;
	}

	@NotNull
	@Size(max=10)
	@Column(name="altura", nullable= false, length= 10)
	public Double getAltura() {
		return altura;
	}

	public void setAltura(Double altura) {
		this.altura = altura;
	}
		
}