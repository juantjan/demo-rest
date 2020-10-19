package com.example.demorest.repository;

import com.example.demorest.model.Product;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

/**
 * Created by Juan on 19/10/20.
 */
@Repository
public interface ProductRepository extends MongoRepository<Product, String> {

}
