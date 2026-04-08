package com.walmartapi.service;

import com.walmartapi.entity.ProductEntity;
import com.walmartapi.model.Product;
import com.walmartapi.repository.ProductRepository;
import org.springframework.stereotype.Service;

@Service
public class ProductService {

    private final ProductRepository productRepository;

    public ProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }


    public Product saveProduct(Product product) {
        ProductEntity productEntity = new ProductEntity();
        productEntity.setDescription(product.getDescription());
        productEntity.setName(product.getName());
        productEntity.setPrice(product.getPrice());

        ProductEntity savedProduct = productRepository.save(productEntity);

        product.setName(savedProduct.getName());
        product.setDescription(savedProduct.getDescription());
        product.setPrice(savedProduct.getPrice());
        
        // map Plane O Java Object to entity
        // Call DB
        // map entity to POJO

        return product;
    }

}
