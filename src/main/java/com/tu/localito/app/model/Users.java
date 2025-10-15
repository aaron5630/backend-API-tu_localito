package com.tu.localito.app.model;
import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;


import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "users")
public class Users {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_user")
	private Long idUser;
	@Column(name = "first_name", length = 30, nullable = false)
	private String firstName;
	@Column(name = "last_name", length = 30, nullable = false)
	private String lastName;
	@Column(name = "password", length = 70, nullable = false)
	private String password;
	@Column(name = "email", length = 45, nullable = false)
	private String email;
	@Column(name = "phone", length = 10, nullable = false)
	private String phone;
	@CreationTimestamp
	@Column(name = "created_at", nullable = false)
	private LocalDateTime createdAt;
	@UpdateTimestamp
	@Column(name = "updated_at", nullable = false)
	private LocalDateTime updatedAt;
	@Column(name = "is_active", nullable = false)
	private boolean isActive;
	
	@ManyToMany()
	@JoinTable(
		name="user_has_roles",
		joinColumns = @JoinColumn(name = "user_id"),
		inverseJoinColumns = @JoinColumn(name = "role_id")
		)
		Set<Roles> roles = new HashSet<>();
	
	public Users() {};
	
	public Users(Long id_user, String first_name, String last_name, String password, String email, String phone,
			LocalDateTime createdAt, LocalDateTime updatedAt, boolean isActive) {
		this.idUser = id_user;
		this.firstName = first_name;
		this.lastName = last_name;
		this.password = password;
		this.email = email;
		this.phone = phone;
		this.createdAt = createdAt;
		this.updatedAt = updatedAt;
		this.isActive = isActive;
	}
	public Long getIdUser() {
		return idUser;
	}
	public void setIdUser(Long id_user) {
		this.idUser = id_user;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String first_name) {
		this.firstName = first_name;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String last_name) {
		this.lastName = last_name;
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
		builder.append(idUser);
		builder.append(", first_name=");
		builder.append(firstName);
		builder.append(", last_name=");
		builder.append(lastName);
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
		return Objects.hash(createdAt, email, firstName, idUser, isActive, lastName, password, phone, updatedAt);
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
				&& Objects.equals(firstName, other.firstName) && Objects.equals(idUser, other.idUser)
				&& isActive == other.isActive && Objects.equals(lastName, other.lastName)
				&& Objects.equals(password, other.password) && Objects.equals(phone, other.phone)
				&& Objects.equals(updatedAt, other.updatedAt);
	}
	
	
	
}