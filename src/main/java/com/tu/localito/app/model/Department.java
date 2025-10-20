package com.tu.localito.app.model;


import java.util.Objects;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table (name="departments")
public class Department {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name="department_name", length=100, nullable=false)
    private String departmentName;
    
    
    
    //===============================
    public Department() {}

    public Department(Long id, String departmentName) {
        this.id = id;
        this.departmentName = departmentName;
    }


    //==============================================
    //get y set
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getDepartmentName() {
		return departmentName;
	}

	public void setDepartmentName(String departmentName) {
		this.departmentName = departmentName;
	}
    
    //============================================
 
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Department [id=");
		builder.append(id);
		builder.append(", departmentName=");
		builder.append(departmentName);
		builder.append("]");
		return builder.toString();
	}

	//========================================

	@Override
	public int hashCode() {
		return Objects.hash(departmentName, id);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Department other = (Department) obj;
		return Objects.equals(departmentName, other.departmentName) && Objects.equals(id, other.id);
	}
}

	
	