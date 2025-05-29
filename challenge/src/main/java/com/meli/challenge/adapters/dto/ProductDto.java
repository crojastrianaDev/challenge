package com.meli.challenge.adapters.dto;

import com.meli.challenge.domain.AdditionalDetails;
import com.meli.challenge.domain.SellerInfo;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@Builder
public class ProductDto {
    private String id;
    private String title;
    private String description;
    private double price;
    private String currency;
    private List<String> images;
    private SellerInfo sellerInfo;
    private List<String> paymentMethods;
    private int stock;
    private AdditionalDetails additionalDetails;
}
