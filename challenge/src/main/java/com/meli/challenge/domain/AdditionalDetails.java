package com.meli.challenge.domain;


import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
public class AdditionalDetails {
    private String brand;
    private String model;
    private String storage;
    private String ram;
    private String color;
}
