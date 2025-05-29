package com.meli.challenge.adapters.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
public class AdditionalDetailsDto {
    private String brand;
    private String model;
    private String storage;
    private String ram;
    private String color;
}
