package com.tu.localito.app.model;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.Objects;

import jakarta.persistence.*;

@Entity
@Table(name = "products")
public class Product {

	// ============================== 🔹 Atributos 🔹 ==============================
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer idProduct;

	@Column(length = 10)
	private String sku;

	@Column(name = "product_name", length = 100, nullable = false)
	private String productName;

	@Column(precision = 7, scale = 2)
	private BigDecimal price;

	private Integer quantity;

	@Column(name = "unit_of_measure", length = 3)
	private String unitOfMeasure;

	@Column(length = 250)
	private String imagen;

	@Column(name = "created_at", columnDefinition = "DATETIME DEFAULT CURRENT_TIMESTAMP")
	private LocalDateTime createdAt;

	@Column(name = "updated_at", columnDefinition = "DATETIME DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP")
	private LocalDateTime updatedAt;

	@Column(name = "is_active", columnDefinition = "TINYINT DEFAULT 1")
	private Boolean isActive;

	
	@ManyToOne
	//private Product product; 
	private Category category;
	

	// ============================== 🔹 Constructores 🔹 ==============================
	// 🔹 Constructor vacío
	public Product() {
	}

	// 🔹 Constructor con atributos (sin id porque es autogenerado)
	public Product(String sku, String productName, BigDecimal price, Integer quantity, String unitOfMeasure,
			String imagen, LocalDateTime createdAt, LocalDateTime updatedAt, Boolean isActive, Category category) {
		this.sku = sku;
		this.productName = productName;
		this.price = price;
		this.quantity = quantity;
		this.unitOfMeasure = unitOfMeasure;
		this.imagen = imagen;
		this.createdAt = createdAt;
		this.updatedAt = updatedAt;
		this.isActive = isActive;
		this.category = category;
	}

	// ============================== 🔹 Getters y Setters 🔹 ==============================
	public Integer getIdProduct() {
		return idProduct;
	}

	public void setIdProduct(Integer idProduct) {
		this.idProduct = idProduct;
	}

	public String getSku() {
		return sku;
	}

	public void setSku(String sku) {
		this.sku = sku;
	}

	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	public BigDecimal getPrice() {
		return price;
	}

	public void setPrice(BigDecimal price) {
		this.price = price;
	}

	public Integer getQuantity() {
		return quantity;
	}

	public void setQuantity(Integer quantity) {
		this.quantity = quantity;
	}

	public String getUnitOfMeasure() {
		return unitOfMeasure;
	}

	public void setUnitOfMeasure(String unitOfMeasure) {
		this.unitOfMeasure = unitOfMeasure;
	}

	public String getImagen() {
		return imagen;
	}

	public void setImagen(String imagen) {
		this.imagen = imagen;
	}

	public LocalDateTime getCreatedAt() {
		return createdAt;
	}

	public void setCreatedAt(LocalDateTime createdAt) {
		this.createdAt = createdAt;
	}

	public LocalDateTime getUpdatedAt() {
		return updatedAt;
	}

	public void setUpdatedAt(LocalDateTime updatedAt) {
		this.updatedAt = updatedAt;
	}

	public Boolean getIsActive() {
		return isActive;
	}

	public void setIsActive(Boolean isActive) {
		this.isActive = isActive;
	}

	// ============================== 🔹 Overrided methods 🔹 ==============================
	// 🔹 Override toString()
	@Override
	public String toString() {
		return "Product{" + "idProduct=" + idProduct + ", sku='" + sku + '\'' + ", productName='" + productName + '\''
				+ ", price=" + price + ", quantity=" + quantity + ", unitOfMeasure='" + unitOfMeasure + '\''
				+ ", imagen='" + imagen + '\'' + ", createdAt=" + createdAt + ", updatedAt=" + updatedAt + ", isActive="
				+ isActive + '}';
	}

	// 🔹 Override hashCode() y equals()
	@Override
	public int hashCode() {
		return Objects.hash(createdAt, idProduct, imagen, isActive, price, productName, quantity, sku, unitOfMeasure,
				updatedAt);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Product other = (Product) obj;
		return Objects.equals(createdAt, other.createdAt) && Objects.equals(idProduct, other.idProduct)
				&& Objects.equals(imagen, other.imagen) && Objects.equals(isActive, other.isActive)
				&& Objects.equals(price, other.price) && Objects.equals(productName, other.productName)
				&& Objects.equals(quantity, other.quantity) && Objects.equals(sku, other.sku)
				&& Objects.equals(unitOfMeasure, other.unitOfMeasure) && Objects.equals(updatedAt, other.updatedAt);
	}

}
