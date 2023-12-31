package com.prath.springweb.repos;

import org.springframework.data.jpa.repository.JpaRepository;

import com.prath.springweb.entities.Product;

public interface ProductRepository extends JpaRepository<Product, Integer> {

}