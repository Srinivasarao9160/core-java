package com.produccts.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.produccts.model.Product;

public interface ProductDao extends JpaRepository<Product, Integer> {

	Product findByName(String name);

}
