package com.example.demorest.controller;

import com.example.demorest.controller.model.request.UpsertProductRequest;
import com.example.demorest.controller.model.response.BaseListResponse;
import com.example.demorest.controller.model.response.BaseSingleResponse;
import com.example.demorest.controller.model.response.ProductResponse;
import com.example.demorest.model.Product;
import com.example.demorest.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

/**
 * Created by Juan on 19/10/20.
 */
@RestController
public class ProductController {
    @Autowired
    private ProductService productService;


    @GetMapping(value = "/products")
    public BaseListResponse<ProductResponse> getAllProduct () {
        List<Product> productList = productService.getAllProduct();
        List<ProductResponse> productResponseList = productList
                .stream()
                .map(product -> toProductResponse(product))
                .collect(Collectors.toList());
        return new BaseListResponse<>(productResponseList);
    }

    @GetMapping(value = "/product/{id}")
    public BaseSingleResponse<ProductResponse> getProductById (@PathVariable("id") String id) {
        Product product = productService.getProductByid(id);
        if (Objects.isNull(product)) {
            return new BaseSingleResponse<>("Not Found", 404, false, null);
        }
        return new BaseSingleResponse<>(toProductResponse(product));
    }

    @PostMapping(value = "/product")
    public BaseSingleResponse<ProductResponse> upsertProduct (@RequestBody UpsertProductRequest upsertProductRequest) {
        Product product = productService.upsertProduct(upsertProductRequest);
        if (Objects.isNull(product)) {
            return new BaseSingleResponse<>("Failed", 503, false, null);
        }
        return new BaseSingleResponse<>(toProductResponse(product));
    }



    private ProductResponse toProductResponse (Product product) {
        return ProductResponse
                .builder()
                .name(product.getName())
                .id(product.getId())
                .price(product.getPrice())
                .build();
    }

}
