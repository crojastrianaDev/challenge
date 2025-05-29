package com.meli.challenge.adapters.controllers.mappers;

import com.meli.challenge.adapters.dto.ProductDto;
import com.meli.challenge.domain.Product;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper(componentModel = "spring")
public interface ProductMapper {

    ProductMapper INSTANCE = Mappers.getMapper(ProductMapper.class);

    List<ProductDto> toDTOS(List<Product> product);
    ProductDto toDTO(Product product);

    Product toEntity(ProductDto productDTO);

}
