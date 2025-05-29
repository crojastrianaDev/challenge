package com.meli.challenge.domain;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class SellerInfo {
    private String name;
    private double rating;
    private int reviews;
}
