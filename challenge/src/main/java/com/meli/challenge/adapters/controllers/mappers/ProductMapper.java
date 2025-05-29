package com.meli.challenge.adapters.controllers.mappers;

import com.meli.challenge.adapters.dto.ProductDto;
import com.meli.challenge.adapters.dto.ProductSimpleDto;
import com.meli.challenge.domain.Product;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Named;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper(componentModel = "spring")
public interface ProductMapper {

    ProductMapper INSTANCE = Mappers.getMapper(ProductMapper.class);


    // Tomar la primera imagen
    @Mapping(source = "images", target = "image", qualifiedByName = "firstImage")
    ProductSimpleDto toDTOFirstImage(Product product);

    List<ProductSimpleDto> toDTOS(List<Product> product);

    ProductDto toDTO(Product product);

    Product toEntity(ProductDto productDTO);



    //Extraer la primera imagen de la lista
    @Named("firstImage")
    static String mapFirstImage(List<String> images) {
        return (images != null && !images.isEmpty()) ? images.get(0) : null;
    }

}
