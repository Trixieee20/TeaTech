package com.TeaTech.co.TeaTech.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.TeaTech.co.TeaTech.Model.Order;

public interface OrderRepository extends JpaRepository<Order, Long>{

}
