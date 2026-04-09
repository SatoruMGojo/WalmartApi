package com.walmartapi.mapper;

import com.walmartapi.entity.ProductEntity;

public interface CustomObjectMapper <E,D> {

    E mapToEntity(D dto);

    D mapToDto(E entity);

}
