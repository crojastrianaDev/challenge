package com.meli.challenge.adapters.controllers;

import com.meli.challenge.adapters.dto.ProductDto;

import java.io.IOException;
import java.util.List;

public interface IGetProduct {
    ProductDto getDetailProduct(String id) throws IOException;
    List<ProductDto> getProducts() throws IOException;
}
