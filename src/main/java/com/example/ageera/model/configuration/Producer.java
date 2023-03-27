package com.example.ageera.model.configuration;

import jakarta.validation.constraints.PositiveOrZero;

public class Producer {
    @PositiveOrZero
    private int units;
    private int kwp;

    public int getUnits() {
        return units;
    }

    public void setUnits(int units) {
        this.units = units;
    }

    public int getKwp() {
        return kwp;
    }

    public void setKwp(int kwp) {
        this.kwp = kwp;
    }
}
