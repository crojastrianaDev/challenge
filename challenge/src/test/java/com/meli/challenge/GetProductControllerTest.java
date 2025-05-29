package com.meli.challenge;

import com.meli.challenge.adapters.controllers.impl.GetProductController;
import com.meli.challenge.adapters.controllers.mappers.ProductMapper;
import com.meli.challenge.adapters.dto.ProductDto;
import com.meli.challenge.adapters.dto.ProductSimpleDto;
import com.meli.challenge.application.IGetProductUseCase;
import com.meli.challenge.domain.Product;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.HttpStatus;
import org.springframework.web.server.ResponseStatusException;

import java.io.IOException;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class GetProductControllerTest {

    @Mock
    private IGetProductUseCase getProductUseCase;

    @Mock
    private ProductMapper productMapper;

    @InjectMocks
    private GetProductController getProductController;

    private Product dummyProduct;
    private ProductDto dummyProductDto;
    private ProductSimpleDto dummyProductSimpleDto;

    @BeforeEach
    void setUp() {

        dummyProduct = new Product();
        dummyProduct.setId("123");
        dummyProduct.setTitle("Test Product");


        dummyProductDto = new ProductDto();
        dummyProductDto.setId("123");
        dummyProductDto.setTitle("Test Product DTO");


        dummyProductSimpleDto = new ProductSimpleDto();
        dummyProductSimpleDto.setId("123");
        dummyProductSimpleDto.setTitle("Simple Test Product DTO");

    }



    @Test
    void getDetailProduct_shouldReturnProductDto_whenProductExists() throws IOException {

        when(getProductUseCase.getProduct("123")).thenReturn(dummyProduct);
        when(productMapper.toDTO(dummyProduct)).thenReturn(dummyProductDto);


        ProductDto result = getProductController.getDetailProduct("123");


        assertNotNull(result);
        assertEquals("123", result.getId());
        assertEquals("Test Product DTO", result.getTitle());

        // Verifica que los métodos de los mocks fueron llamados una vez
        verify(getProductUseCase, times(1)).getProduct("123");
        verify(productMapper, times(1)).toDTO(dummyProduct);
    }

    @Test
    void getDetailProduct_shouldThrowNotFoundException_whenProductDoesNotExistInUseCase() throws IOException {

        when(getProductUseCase.getProduct("nonExistentId")).thenReturn(null);

        when(productMapper.toDTO(null)).thenReturn(null);


        ResponseStatusException exception = assertThrows(ResponseStatusException.class, () -> {
            getProductController.getDetailProduct("nonExistentId");
        });

        assertEquals(HttpStatus.NOT_FOUND, exception.getStatusCode());
        assertTrue(exception.getReason().contains("Product not found"));

        verify(getProductUseCase, times(1)).getProduct("nonExistentId");
        verify(productMapper, times(1)).toDTO(null);
    }

    @Test
    void getDetailProduct_shouldThrowBadRequestException_whenIdIsNull() {

        ResponseStatusException exception = assertThrows(ResponseStatusException.class, () -> {
            getProductController.getDetailProduct(null); // Pasa null como ID
        });

        assertEquals(HttpStatus.BAD_REQUEST, exception.getStatusCode());
        assertTrue(exception.getReason().contains("Id path variable is required"));

        verifyNoInteractions(getProductUseCase);
        verifyNoInteractions(productMapper);
    }

    // --- Tests para getProducts() ---

    @Test
    void getProducts_shouldReturnListOfProductSimpleDto_whenProductsExist() throws IOException {

        List<Product> products = Arrays.asList(dummyProduct, new Product()); // Lista de productos de dominio
        List<ProductSimpleDto> simpleDtos = Arrays.asList(dummyProductSimpleDto, new ProductSimpleDto()); // Lista de DTOs simples

        when(getProductUseCase.getProducts()).thenReturn(products);
        when(productMapper.toDTOS(products)).thenReturn(simpleDtos);

        // WHEN: Llama al método a probar
        List<ProductSimpleDto> result = getProductController.getProducts();

        // THEN: Verifica los resultados
        assertNotNull(result);
        assertFalse(result.isEmpty());
        assertEquals(2, result.size());
        assertEquals("Simple Test Product DTO", result.get(0).getTitle());

        // Verifica que los mocks fueron llamados
        verify(getProductUseCase, times(1)).getProducts();
        verify(productMapper, times(1)).toDTOS(products);
    }

    @Test
    void getProducts_shouldThrowNotFoundException_whenNoProductsExistInUseCase() throws IOException {
        when(getProductUseCase.getProducts()).thenReturn(Collections.emptyList());
        when(productMapper.toDTOS(anyList())).thenReturn(null);

        // WHEN & THEN: Verifica que se lance la excepción esperada
        ResponseStatusException exception = assertThrows(ResponseStatusException.class, () -> {
            getProductController.getProducts();
        });

        assertEquals(HttpStatus.NOT_FOUND, exception.getStatusCode());
        assertTrue(exception.getReason().contains("Not exists products"));

        verify(getProductUseCase, times(1)).getProducts();
        verify(productMapper, times(1)).toDTOS(anyList());
    }

    @Test
    void getProducts_shouldThrowNotFoundException_whenUseCaseReturnsNull() throws IOException {

        when(getProductUseCase.getProducts()).thenReturn(null);
        when(productMapper.toDTOS(null)).thenReturn(null);


        ResponseStatusException exception = assertThrows(ResponseStatusException.class, () -> {
            getProductController.getProducts();
        });

        assertEquals(HttpStatus.NOT_FOUND, exception.getStatusCode());
        assertTrue(exception.getReason().contains("Not exists products"));

        verify(getProductUseCase, times(1)).getProducts();
        verify(productMapper, times(1)).toDTOS(null);
    }
}