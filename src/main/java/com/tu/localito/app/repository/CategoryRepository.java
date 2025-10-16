package com.tu.localito.app.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.tu.localito.app.model.Category;

public interface CategoryRepository extends JpaRepository<Category,Long>{

}
