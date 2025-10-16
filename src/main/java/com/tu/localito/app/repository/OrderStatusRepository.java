package com.tu.localito.app.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.tu.localito.app.model.OrderStatus;



public interface OrderStatusRepository extends JpaRepository<OrderStatus,Long>{

}
