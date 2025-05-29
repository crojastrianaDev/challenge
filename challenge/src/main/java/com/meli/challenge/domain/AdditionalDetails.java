package com.meli.challenge.domain;


import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class AdditionalDetails {
    private String brand;
    private String model;
    private String storage;
    private String ram;
    private String color;
}
