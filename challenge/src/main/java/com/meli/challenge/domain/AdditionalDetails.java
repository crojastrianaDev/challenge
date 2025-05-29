package com.meli.challenge.domain;


import lombok.*;

@Getter
@Setter
@NoArgsConstructor(access = AccessLevel.PUBLIC)
@AllArgsConstructor(access = AccessLevel.PUBLIC)
public class AdditionalDetails {
    private String brand;
    private String model;
    private String storage;
    private String ram;
    private String color;
}
