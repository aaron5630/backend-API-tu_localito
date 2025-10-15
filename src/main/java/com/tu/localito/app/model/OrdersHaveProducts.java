package com.tu.localito.app.model;

import java.math.BigDecimal;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="orders")
public class OrdersHaveProducts {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_order_details")
	private Integer idOrderDetails;
	
	@Column(name = "quantity", nullable = false)
	private Integer quantity;
	
	@Column(name = "purchase_price", nullable = false)
	private BigDecimal purchasePrice;
	@Column(name = "subtotal", nullable = false)
	private BigDecimal subtotal;
	
}
