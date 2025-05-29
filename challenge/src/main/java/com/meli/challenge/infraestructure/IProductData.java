package com.meli.challenge.infraestructure;

import com.meli.challenge.domain.Product;

import java.io.IOException;
import java.util.List;

public interface IProductData {
    List<Product> getProducts() throws IOException;
}
