package com.walmartapi.controller;

import com.walmartapi.model.Product;
import com.walmartapi.service.ProductService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/products")
public class ProductController {

    private final ProductService productService;

    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @PostMapping
    public ResponseEntity<Product> createProduct(@RequestBody Product product) {
        Product savedProduct = productService.saveProduct(product);
        return new ResponseEntity<>(savedProduct, HttpStatus.CREATED);
    }
    @GetMapping("{id}")
    public ResponseEntity<Product> getProductById(@PathVariable Long id) {
        Product foundProduct = productService.getProductById(id);
        return new ResponseEntity<>(foundProduct, HttpStatus.OK);

    }

}
