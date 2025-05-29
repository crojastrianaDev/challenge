package com.meli.challenge.adapters.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
public class SellerInfoDto {
    private String name;
    private double rating;
    private int reviews;
}
