package com.example.demorest.service;

import com.example.demorest.controller.model.request.UpsertProductRequest;
import com.example.demorest.model.Product;
import com.example.demorest.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;

/**
 * Created by Juan on 19/10/20.
 */
@Service
public class ProductService {
    @Autowired
    ProductRepository productRepository;

    public Product upsertProduct (UpsertProductRequest upsertProductRequest) {
        if (Objects.nonNull(upsertProductRequest.getId())) {
            return updateProduct(upsertProductRequest);
        }
        return insertProduct(upsertProductRequest);
    }

    public Product getProductByid (String id) {
        return productRepository.findById(id).orElse(null);
    }

    public List<Product> getAllProduct () {
        return productRepository.findAll();
    }

    private Product updateProduct (UpsertProductRequest upsertProductRequest) {
        Product product = productRepository.findById(upsertProductRequest.getId()).get();
        product.setPrice(upsertProductRequest.getPrice());
        product.setName(upsertProductRequest.getName());
        return productRepository.save(product);
    }

    private Product insertProduct (UpsertProductRequest upsertProductRequest) {
        Product product = Product.builder()
                .name(upsertProductRequest.getName())
                .price(upsertProductRequest.getPrice())
                .build();

        return productRepository.save(product);
    }
}
