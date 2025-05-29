package com.meli.challenge.domain;


import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@Builder
public class Product {
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
