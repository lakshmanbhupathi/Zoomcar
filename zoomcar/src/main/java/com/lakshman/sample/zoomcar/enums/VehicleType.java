package com.lakshman.sample.zoomcar.enums;

import com.fasterxml.jackson.annotation.JsonValue;

public enum VehicleType {
    SEDAN("SEDAN"),
    HATCHBACK("HATCHBACK"),
    SUV("SUV"),
    MPV("MPV"),
    CROSSOVER("CROSSOVER"),
    COUPE("COUPE"),
    CONVERTIBLE("CONVERTIBLE");

    private String valueInJson;

    VehicleType(String valueInJson) {
        this.valueInJson = valueInJson;
    }

    @JsonValue
    public String getValueInJson() {
        return valueInJson;
    }
}