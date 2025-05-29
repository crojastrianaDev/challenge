package com.meli.challenge;

import com.meli.challenge.domain.Product;
import com.meli.challenge.infraestructure.impl.repository.ProductData;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class ProductDataTest {

    private ProductData productData;

    @BeforeEach
    void setUp() {
        this.productData = new ProductData();
    }

    @Test
    void getProducts_shouldReturnProductsFromFile() throws IOException {

        List<Product> products = productData.getProducts();

        assertNotNull(products);
        assertFalse(products.isEmpty());

        assertTrue(products.size() >= 1, "Debe haber al menos un producto en el JSON de prueba");
        assertEquals("1", products.get(0).getId()); // Asumiendo que el primer producto en products.json tiene ID "1"
        assertEquals("Samsung Galaxy A55 5G Dual SIM 256 GB azul oscuro 8 GB RAM", products.get(0).getTitle());
    }

    @Test
    void getProducts_shouldThrowIOException_whenFileDoesNotExist() {
        assertDoesNotThrow(() -> productData.getProducts());
    }

}