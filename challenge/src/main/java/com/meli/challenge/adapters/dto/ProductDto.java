package com.meli.challenge.adapters.dto;

import com.meli.challenge.domain.AdditionalDetails;
import com.meli.challenge.domain.SellerInfo;
import lombok.*;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor(access = AccessLevel.PUBLIC)
@AllArgsConstructor(access = AccessLevel.PUBLIC)
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
