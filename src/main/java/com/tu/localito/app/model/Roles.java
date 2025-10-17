package com.tu.localito.app.model;

import java.util.HashSet;
import java.util.Objects;
import java.util.Set;


import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "roles")
public class Roles {
	@Id 
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long idRole;
	@Column(name = "rol_name", length = 30, nullable = false)
	private String rolName;
	
	@ManyToMany(mappedBy = "roles")
	private Set<Users> users = new HashSet<>();
	
	public Roles() {};
	
	public Roles( String rolName) {
		this.rolName = rolName;
	}
	public Long getIdRole() {
		return idRole;
	}
	public void setIdRole(Long idRole) {
		this.idRole = idRole;
	}
	public String getRolName() {
		return rolName;
	}
	public void setRolName(String rolName) {
		this.rolName = rolName;
	}
	
	
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Roles [idRole=");
		builder.append(idRole);
		builder.append(", rolName=");
		builder.append(rolName);
		builder.append("]");
		return builder.toString();
	}
	@Override
	public int hashCode() {
		return Objects.hash(idRole, rolName);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Roles other = (Roles) obj;
		return Objects.equals(idRole, other.idRole) && Objects.equals(rolName, other.rolName);
	}
	
	
}
