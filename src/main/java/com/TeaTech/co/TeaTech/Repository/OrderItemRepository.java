package com.TeaTech.co.TeaTech.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.TeaTech.co.TeaTech.Model.OrderItem;

public interface OrderItemRepository extends JpaRepository<OrderItem, Long>{

}
