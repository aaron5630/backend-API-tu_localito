package com.tu.localito.app.model;

import java.util.Objects;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table (name="orderStatus")
public class OrderStatus {
    @Id
    private Long id;
    @Column(name="status_name", length=100, nullable=false)
    private String statusName;
  
    
    //===============================
    public OrderStatus() {}

    public OrderStatus(String statusName) {
        this.statusName = statusName;
    }


    //==============================================
    //get y set
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getStatusName() {
		return statusName;
	}

	public void setStatusName(String statusName) {
		this.statusName = statusName;
	}

	
    
    //============================================
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("OrderStatus [id=");
		builder.append(id);
		builder.append(", statusName=");
		builder.append(statusName);
		builder.append("]");
		return builder.toString();
	}

	//========================================

	@Override
	public int hashCode() {
		return Objects.hash(id, statusName);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		OrderStatus other = (OrderStatus) obj;
		return Objects.equals(id, other.id) && Objects.equals(statusName, other.statusName);
	}

}

	
	
