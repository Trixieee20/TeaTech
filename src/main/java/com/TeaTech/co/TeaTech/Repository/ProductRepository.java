package com.TeaTech.co.TeaTech.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.TeaTech.co.TeaTech.Model.Product;

public interface ProductRepository extends JpaRepository<Product, Long> {

}

