package com.walmartapi.service;

import com.walmartapi.entity.ProductEntity;
import com.walmartapi.exception.NotFound;
import com.walmartapi.mapper.CustomObjectMapper;
import com.walmartapi.model.Product;
import com.walmartapi.repository.ProductRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ProductService {

    private final ProductRepository productRepository;
    private final CustomObjectMapper<ProductEntity, Product> productMapper;

    public ProductService(ProductRepository productRepository,
                          CustomObjectMapper<ProductEntity, Product> productMapper) {
        this.productRepository = productRepository;
        this.productMapper = productMapper;
    }


    public Product saveProduct(Product product) {
        ProductEntity newProduct = productMapper.mapToEntity(product);
        ProductEntity savedEntity = productRepository.save(new ProductEntity());
        // map Plane O Java Object to entity
        // Call DB
        // map entity to POJO

        return product;
    }

    public Product getProductById(Long id) {
        Optional<ProductEntity> product = productRepository.findById(id);
        if(product.isEmpty()) {
            throw new NotFound("Product Not Found");
        }
    return productMapper.mapToDto(product.get());
    }

    public Product updateProduct(Long id, Product product) {
        // Verificar que el producto existe
        if (productRepository.findById(id).isEmpty()) {
            throw new NotFound("Product Not Found");
        }
        // Convertir el POJO a entidad y asignarle el id
        ProductEntity entityToUpdate = productMapper.mapToEntity(product);
        entityToUpdate.setId(id);
        // .save() detecta que tiene id y hace UPDATE
        ProductEntity savedEntity = productRepository.save(entityToUpdate);
        // Retornar el entity mapeado a POJO
        return productMapper.mapToDto(savedEntity);
    }

    public void deleteProduct(Long id) {
        // Verificar que el producto existe
        if (productRepository.findById(id).isEmpty()) {
            throw new NotFound("Product Not Found");
        }
        productRepository.deleteById(id);
    }

}
