package com.meli.challenge.adapters.controllers.impl;

import com.meli.challenge.adapters.controllers.IGetProduct;
import com.meli.challenge.adapters.controllers.mappers.ProductMapper;
import com.meli.challenge.adapters.dto.ProductDto;
import com.meli.challenge.adapters.dto.ProductSimpleDto;
import com.meli.challenge.application.IGetProductUseCase;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.io.IOException;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

@CrossOrigin("*")
@RestController
@RequestMapping("/api/v1/products")
@RequiredArgsConstructor
public class GetProductController implements IGetProduct {

    private final IGetProductUseCase getProductUseCase;
    private final ProductMapper productMapper;
    @Override
    @GetMapping("/{id}")
    public ProductDto getDetailProduct(@PathVariable String id) throws IOException {
        if (Objects.nonNull(id)){
            ProductDto productDto = productMapper.toDTO(getProductUseCase.getProduct(id));
            return Optional.ofNullable(productDto)
                    .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Product not found"));
        }else {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Id path variable is required");
        }
    }
    @Override
    @GetMapping()
    public List<ProductSimpleDto> getProducts() throws IOException {
            List<ProductSimpleDto> productDtos = productMapper.toDTOS(getProductUseCase.getProducts());
            if (productDtos == null){
                throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Not exists products");
            }
        return productDtos;
    }
}
