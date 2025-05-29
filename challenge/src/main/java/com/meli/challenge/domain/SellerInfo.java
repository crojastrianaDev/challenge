package com.meli.challenge.domain;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
public class SellerInfo {
    private String name;
    private double rating;
    private int reviews;
}
