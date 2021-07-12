package com.bazar.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.bazar.model.Product;

public interface ProductRepository extends CrudRepository<Product, Integer> {

	List<Product> findByDescriptionContainingIgnoreCase(String keyphrase);

}
