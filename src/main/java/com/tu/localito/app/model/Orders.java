package com.tu.localito.app.model;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.Objects;

import org.hibernate.annotations.CreationTimestamp;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name="orders")
public class Orders {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer idOrder;
	
	@Column(name = "total")
	private BigDecimal total;
	
	@CreationTimestamp
	@Column(name = "order_date")
	private LocalDateTime orderDate;
	
	@ManyToOne
	private Users user;
	
	@ManyToOne 
	private OrderStatus orderStatus;

	public Orders(BigDecimal total, LocalDateTime orderDate, Users user, OrderStatus orderStatus) {
		super();
		this.total = total;
		this.orderDate = orderDate;
		this.user = user;
		this.orderStatus = orderStatus;
	}

	public Integer getIdOrder() {
		return idOrder;
	}

	public void setIdOrder(Integer idOrder) {
		this.idOrder = idOrder;
	}

	public BigDecimal getTotal() {
		return total;
	}

	public void setTotal(BigDecimal total) {
		this.total = total;
	}

	public LocalDateTime getOrderDate() {
		return orderDate;
	}

	public void setOrderDate(LocalDateTime orderDate) {
		this.orderDate = orderDate;
	}

	public Users getUser() {
		return user;
	}

	public void setUser(Users user) {
		this.user = user;
	}

	public OrderStatus getOrderStatus() {
		return orderStatus;
	}

	public void setOrderStatus(OrderStatus orderStatus) {
		this.orderStatus = orderStatus;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Orders [idOrder=");
		builder.append(idOrder);
		builder.append(", total=");
		builder.append(total);
		builder.append(", orderDate=");
		builder.append(orderDate);
		builder.append(", user=");
		builder.append(user);
		builder.append(", orderStatus=");
		builder.append(orderStatus);
		builder.append("]");
		return builder.toString();
	}

	@Override
	public int hashCode() {
		return Objects.hash(idOrder, orderDate, orderStatus, total, user);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Orders other = (Orders) obj;
		return Objects.equals(idOrder, other.idOrder) && Objects.equals(orderDate, other.orderDate)
				&& Objects.equals(orderStatus, other.orderStatus) && Objects.equals(total, other.total)
				&& Objects.equals(user, other.user);
	}
	
	//====Constructores====
	
	
	
	
	
	
	
}
