package com.dev.bisa.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.dev.bisa.model.Product;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long>{

}