package com.tu.localito.app.model;

import java.util.Objects;

import jakarta.persistence.*;

@Entity
@Table(name = "categories")
public class Category {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_category")
    private Integer idCategory;

    @Column(name = "category_name", length = 30, nullable = false)
    private String categoryName;

    // 🔹 Constructor vacío (requerido por JPA)
    public Category() {
    }

    // 🔹 Constructor con atributos (sin id porque es autogenerado)
    public Category(String categoryName) {
        this.categoryName = categoryName;
    }

    // 🔹 Getters y Setters
    public Integer getIdCategory() {
        return idCategory;
    }

    public void setIdCategory(Integer idCategory) {
        this.idCategory = idCategory;
    }

    public String getCategoryName() {
        return categoryName;
    }

    public void setCategoryName(String categoryName) {
        this.categoryName = categoryName;
    }

    // 🔹 Override toString()
    @Override
    public String toString() {
        return "Category{" +
                "idCategory=" + idCategory +
                ", categoryName='" + categoryName + '\'' +
                '}';
    }

    // 🔹 Override hashCode() y equals()
	@Override
	public int hashCode() {
		return Objects.hash(categoryName, idCategory);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Category other = (Category) obj;
		return Objects.equals(categoryName, other.categoryName) && Objects.equals(idCategory, other.idCategory);
	}
    
}
