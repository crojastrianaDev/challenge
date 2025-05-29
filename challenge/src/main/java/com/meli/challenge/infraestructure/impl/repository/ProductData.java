package com.meli.challenge.infraestructure.impl.repository;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.meli.challenge.domain.Product;
import com.meli.challenge.infraestructure.IProductData;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.io.File;
import java.io.IOException;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

@Service
@RequiredArgsConstructor
public class ProductData implements IProductData {
    @Override
    public List<Product> getProducts() throws IOException {
        ObjectMapper mapper = new ObjectMapper();
        try (var inputStream = getClass().getClassLoader().getResourceAsStream("static/products.json")) {
            if (inputStream == null) {
                throw new IOException("No se encontró el archivo products.json en classpath");
            }
            Product[] products = mapper.readValue(inputStream, Product[].class);
            return Arrays.asList(products);
        }
    }
}
