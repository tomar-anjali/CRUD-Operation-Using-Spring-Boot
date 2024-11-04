package com.spring.demo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.spring.demo.entity.Product;

@Repository
public interface ProductRepo extends JpaRepository<Product, Integer>{

	Product save(Product prd);
	List<Product> findAll();

}
