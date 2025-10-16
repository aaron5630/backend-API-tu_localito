package com.tu.localito.app.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.tu.localito.app.model.Orders;



public interface OrdersRepository extends JpaRepository<Orders, Long>{

}
