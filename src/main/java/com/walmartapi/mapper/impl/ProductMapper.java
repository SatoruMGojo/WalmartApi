package com.walmartapi.mapper.impl;

import com.walmartapi.entity.ProductEntity;
import com.walmartapi.mapper.CustomObjectMapper;
import com.walmartapi.model.Product;
import org.springframework.stereotype.Component;

@Component
public class ProductMapper implements CustomObjectMapper<ProductEntity, Product> {
    @Override
    public ProductEntity mapToEntity(Product dto) { //data transfer object
        ProductEntity productEntity = new ProductEntity();
        productEntity.setName(dto.getName());
        productEntity.setDescription(dto.getDescription());
        productEntity.setPrice(dto.getPrice());
        return productEntity;

    }

    @Override
    public Product mapToDto(ProductEntity entity) {
        Product savedProduct = new Product();
        savedProduct.setDescription(entity.getDescription());
        savedProduct.setName(entity.getName());
        savedProduct.setPrice(entity.getPrice());

        return savedProduct;
    }
}
