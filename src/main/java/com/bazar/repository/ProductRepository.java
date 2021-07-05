package com.bazar.repository;

import org.springframework.data.repository.CrudRepository;

import com.bazar.model.Product;

public interface ProductRepository extends CrudRepository<Product, Integer> {

}
