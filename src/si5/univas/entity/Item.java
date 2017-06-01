package si5.univas.entity;
// Generated 03/05/2017 20:58:23 by Hibernate Tools 5.2.1.Final

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Parameter;

/**
 * Item generated by hbm2java
 */
@Entity
@Table(name = "item", schema = "public")
public class Item implements java.io.Serializable {
	private static final long serialVersionUID = 1L;

	private Integer cod;
	private Pedido pedido;
	private Produto produto;
	private Integer quantidade;

	public Item() {
	}

	public Item(Pedido pedido, Produto produto, Integer quantidade) {
		this.pedido = pedido;
		this.produto = produto;
		this.quantidade = quantidade;
	}

	@GenericGenerator(name = "generator", strategy = "org.hibernate.id.enhanced.SequenceStyleGenerator", parameters = {
			@Parameter(name = "optimizer", value = "none"),
			@Parameter(name = "sequence_name", value = "public.seq_item"),
			@Parameter(name = "increment_size", value = "1") })
	@Id
	@GeneratedValue(generator = "generator")

	@Column(name = "cod", unique = true, nullable = false)
	public Integer getCod() {
		return this.cod;
	}

	public void setCod(Integer cod) {
		this.cod = cod;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "cod_pedido")
	public Pedido getPedido() {
		return this.pedido;
	}

	public void setPedido(Pedido pedido) {
		this.pedido = pedido;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "cod_produto")
	public Produto getProduto() {
		return this.produto;
	}

	public void setProduto(Produto produto) {
		this.produto = produto;
	}

	@Column(name = "quantidade")
	public Integer getQuantidade() {
		return this.quantidade;
	}

	public void setQuantidade(Integer quantidade) {
		this.quantidade = quantidade;
	}

}
