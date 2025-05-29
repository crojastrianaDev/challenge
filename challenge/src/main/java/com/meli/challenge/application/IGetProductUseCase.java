package com.meli.challenge.application;

import com.meli.challenge.domain.Product;

import java.io.IOException;
import java.util.List;

public interface IGetProductUseCase {

    List<Product> getProducts() throws IOException;
    Product getProduct(String id) throws IOException;
}
