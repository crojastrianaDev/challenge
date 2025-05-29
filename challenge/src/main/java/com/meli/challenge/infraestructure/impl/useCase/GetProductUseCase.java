package com.meli.challenge.infraestructure.impl.useCase;

import com.meli.challenge.application.IGetProductUseCase;
import com.meli.challenge.domain.Product;
import com.meli.challenge.infraestructure.IProductData;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;


import java.io.IOException;
import java.util.List;


@Service
@RequiredArgsConstructor
public class GetProductUseCase implements IGetProductUseCase {

    private final IProductData productData;

    @Override
    public List<Product> getProducts() throws IOException {
        return productData.getProducts();
    }

    @Override
    public Product getProduct(String id) throws IOException {
        List<Product> products = getProducts();
        return products.stream().filter(x -> x.getId().equals(id)).findFirst().orElseThrow(null);
    }
}
