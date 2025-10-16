package com.tu.localito.app.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.tu.localito.app.model.OrdersHaveProducts;



public interface OrdersHaveProductsRepository extends JpaRepository<OrdersHaveProducts,Long>{

}
