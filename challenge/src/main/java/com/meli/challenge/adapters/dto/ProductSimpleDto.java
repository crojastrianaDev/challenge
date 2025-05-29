package com.meli.challenge.adapters.dto;


import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class ProductSimpleDto {
    private String id;
    private String title;
    private double price;
    private String currency;
    private String image;
}
