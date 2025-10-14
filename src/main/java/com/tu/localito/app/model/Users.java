package com.tu.localito.app.model;

import java.time.LocalDateTime;
import java.util.Objects;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "users")
public class Users {
	@Id
	@Column(name = "id_user")
	private Long id_user;
	@Column(name = "first_name", length = 30, nullable = false)
	private String first_name;
	@Column(name = "last_name", length = 30, nullable = false)
	private String last_name;
	@Column(name = "password", length = 70, nullable = false)
	private String password;
	@Column(name = "email", length = 45, nullable = false)
	private String email;
	@Column(name = "phone", length = 10, nullable = false)
	private String phone;
	@Column(name = "created_at", nullable = false)
	private LocalDateTime createdAt;
	@Column(name = "updated_at", nullable = false)
	private LocalDateTime updatedAt;
	@Column(name = "is_active", nullable = false)
	private boolean isActive;
	public Users(Long id_user, String first_name, String last_name, String password, String email, String phone,
			LocalDateTime createdAt, LocalDateTime updatedAt, boolean isActive) {
		super();
		this.id_user = id_user;
		this.first_name = first_name;
		this.last_name = last_name;
		this.password = password;
		this.email = email;
		this.phone = phone;
		this.createdAt = createdAt;
		this.updatedAt = updatedAt;
		this.isActive = isActive;
	}
	public Long getId_user() {
		return id_user;
	}
	public void setId_user(Long id_user) {
		this.id_user = id_user;
	}
	public String getFirst_name() {
		return first_name;
	}
	public void setFirst_name(String first_name) {
		this.first_name = first_name;
	}
	public String getLast_name() {
		return last_name;
	}
	public void setLast_name(String last_name) {
		this.last_name = last_name;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
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
	public boolean isActive() {
		return isActive;
	}
	public void setActive(boolean isActive) {
		this.isActive = isActive;
	}
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Users [id_user=");
		builder.append(id_user);
		builder.append(", first_name=");
		builder.append(first_name);
		builder.append(", last_name=");
		builder.append(last_name);
		builder.append(", password=");
		builder.append(password);
		builder.append(", email=");
		builder.append(email);
		builder.append(", phone=");
		builder.append(phone);
		builder.append(", createdAt=");
		builder.append(createdAt);
		builder.append(", updatedAt=");
		builder.append(updatedAt);
		builder.append(", isActive=");
		builder.append(isActive);
		builder.append("]");
		return builder.toString();
	}
	@Override
	public int hashCode() {
		return Objects.hash(createdAt, email, first_name, id_user, isActive, last_name, password, phone, updatedAt);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Users other = (Users) obj;
		return Objects.equals(createdAt, other.createdAt) && Objects.equals(email, other.email)
				&& Objects.equals(first_name, other.first_name) && Objects.equals(id_user, other.id_user)
				&& isActive == other.isActive && Objects.equals(last_name, other.last_name)
				&& Objects.equals(password, other.password) && Objects.equals(phone, other.phone)
				&& Objects.equals(updatedAt, other.updatedAt);
	}
	
	
	
}