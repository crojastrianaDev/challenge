package com.meli.challenge.infraestructure.impl.repository;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.meli.challenge.domain.Product;
import com.meli.challenge.infraestructure.IProductData;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.io.File;
import java.io.IOException;
import java.util.Collections;
import java.util.List;

@Service
@RequiredArgsConstructor
public class ProductData implements IProductData {
    @Override
    public List<Product> getProducts() throws IOException {
        ObjectMapper mapper = new ObjectMapper();
        return Collections.singletonList(mapper.readValue(new File("../resources/static/products.json"), Product.class));
    }
}
