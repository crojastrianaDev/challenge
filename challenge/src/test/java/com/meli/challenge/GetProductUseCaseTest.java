package com.meli.challenge;

import com.meli.challenge.domain.Product;
import com.meli.challenge.infraestructure.IProductData;
import com.meli.challenge.infraestructure.impl.useCase.GetProductUseCase;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.io.IOException;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class GetProductUseCaseTest {

    @Mock
    private IProductData productData;

    @InjectMocks
    private GetProductUseCase getProductUseCase;

    private Product product1;
    private Product product2;

    @BeforeEach
    void setUp() {
        product1 = new Product();
        product1.setId("1");
        product1.setTitle("Product One");


        product2 = new Product();
        product2.setId("2");
        product2.setTitle("Product Two");

    }

    // --- Tests para getProducts() ---

    @Test
    void getProducts_shouldReturnAllProducts() throws IOException {

        List<Product> expectedProducts = Arrays.asList(product1, product2);
        when(productData.getProducts()).thenReturn(expectedProducts);


        List<Product> actualProducts = getProductUseCase.getProducts();


        assertNotNull(actualProducts);
        assertEquals(expectedProducts.size(), actualProducts.size());
        assertEquals(expectedProducts, actualProducts);


        verify(productData, times(1)).getProducts();
    }

    @Test
    void getProducts_shouldReturnEmptyList_whenNoProductsExist() throws IOException {

        when(productData.getProducts()).thenReturn(Collections.emptyList());


        List<Product> actualProducts = getProductUseCase.getProducts();


        assertNotNull(actualProducts);
        assertTrue(actualProducts.isEmpty());

        verify(productData, times(1)).getProducts();
    }

    @Test
    void getProducts_shouldThrowIOException_whenProductDataThrowsIOException() throws IOException {

        when(productData.getProducts()).thenThrow(new IOException("Error reading products"));


        IOException thrown = assertThrows(IOException.class, () -> {
            getProductUseCase.getProducts();
        });

        assertTrue(thrown.getMessage().contains("Error reading products"));
        verify(productData, times(1)).getProducts();
    }

    // --- Tests para getProduct(String id) ---

    @Test
    void getProduct_shouldReturnProduct_whenProductExists() throws IOException {

        List<Product> allProducts = Arrays.asList(product1, product2);
        when(productData.getProducts()).thenReturn(allProducts);

        Product foundProduct = getProductUseCase.getProduct("1");

        assertNotNull(foundProduct);
        assertEquals("1", foundProduct.getId());
        assertEquals("Product One", foundProduct.getTitle());

        verify(productData, times(1)).getProducts();
    }

    @Test
    void getProduct_shouldReturnNull_whenProductDoesNotExist() throws IOException {

        List<Product> allProducts = Collections.singletonList(product2); // Solo product2 existe
        when(productData.getProducts()).thenReturn(allProducts);


        Product foundProduct = getProductUseCase.getProduct("999"); // ID que no existe


        assertNull(foundProduct);

        verify(productData, times(1)).getProducts();
    }

    @Test
    void getProduct_shouldReturnNull_whenProductDataReturnsEmptyList() throws IOException {

        when(productData.getProducts()).thenReturn(Collections.emptyList());


        Product foundProduct = getProductUseCase.getProduct("1");


        assertNull(foundProduct);

        verify(productData, times(1)).getProducts();
    }

    @Test
    void getProduct_shouldThrowIOException_whenProductDataThrowsIOException() throws IOException {

        when(productData.getProducts()).thenThrow(new IOException("Error fetching all products for search"));

        IOException thrown = assertThrows(IOException.class, () -> {
            getProductUseCase.getProduct("1");
        });

        assertTrue(thrown.getMessage().contains("Error fetching all products for search"));
        verify(productData, times(1)).getProducts();
    }
}