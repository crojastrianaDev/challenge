package com.meli.challenge.domain;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor(access = AccessLevel.PUBLIC)
@AllArgsConstructor(access = AccessLevel.PUBLIC)
public class SellerInfo {
    private String name;
    private double rating;
    private int reviews;
}
