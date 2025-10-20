package com.tu.localito.app.model;

import java.math.BigDecimal;
import java.util.Objects;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name="orders_have_products")
public class OrdersHaveProducts {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(name = "quantity", nullable = false)
	private Integer quantity;
	
	@Column(name = "purchase_price", nullable = false)
	private BigDecimal purchasePrice;
	@Column(name = "subtotal", nullable = false)
	private BigDecimal subtotal;
	
	@ManyToOne
	@JoinColumn(name = "order_id", referencedColumnName = "id")
	private Orders order;
	
	@ManyToOne
	@JoinColumn(name = "product_id", referencedColumnName = "id")
	private Product product;
	
	public OrdersHaveProducts() {};

	public OrdersHaveProducts(Integer quantity, BigDecimal purchasePrice, BigDecimal subtotal, Orders order,
			Product product) {
		this.quantity = quantity;
		this.purchasePrice = purchasePrice;
		this.subtotal = subtotal;
		this.order = order;
		this.product = product;
	}

	public Long getIdOrderDetails() {
		return id;
	}

	public void setIdOrderDetails(Long idOrderDetails) {
		this.id = idOrderDetails;
	}

	public Integer getQuantity() {
		return quantity;
	}

	public void setQuantity(Integer quantity) {
		this.quantity = quantity;
	}

	public BigDecimal getPurchasePrice() {
		return purchasePrice;
	}

	public void setPurchasePrice(BigDecimal purchasePrice) {
		this.purchasePrice = purchasePrice;
	}

	public BigDecimal getSubtotal() {
		return subtotal;
	}

	public void setSubtotal(BigDecimal subtotal) {
		this.subtotal = subtotal;
	}

	public Orders getOrder() {
		return order;
	}

	public void setOrder(Orders order) {
		this.order = order;
	}

	public Product getProduct() {
		return product;
	}

	public void setProduct(Product product) {
		this.product = product;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("OrdersHaveProducts [idOrderDetails=");
		builder.append(id);
		builder.append(", quantity=");
		builder.append(quantity);
		builder.append(", purchasePrice=");
		builder.append(purchasePrice);
		builder.append(", subtotal=");
		builder.append(subtotal);
		builder.append(", order=");
		builder.append(order);
		builder.append(", product=");
		builder.append(product);
		builder.append("]");
		return builder.toString();
	}

	@Override
	public int hashCode() {
		return Objects.hash(id, order, product, purchasePrice, quantity, subtotal);
	}

	
	//Revisar mañana con Serch
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		OrdersHaveProducts other = (OrdersHaveProducts) obj;
		return Objects.equals(id, other.id) && Objects.equals(order, other.order)
				&& Objects.equals(product, other.product) && Objects.equals(purchasePrice, other.purchasePrice)
				&& Objects.equals(quantity, other.quantity) && Objects.equals(subtotal, other.subtotal);
	}
	
	
	
}
