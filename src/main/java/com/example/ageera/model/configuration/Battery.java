package com.example.ageera.model.configuration;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.validation.constraints.PositiveOrZero;

public class Battery {
    private Vendor vendor;
    @JsonProperty(value = "capacity_kwh")
    @PositiveOrZero
    private int capacityKwh;
    @JsonProperty(value = "max_power_kw")
    @PositiveOrZero
    private int maxPowerKw;

    public Vendor getVendor() {
        return vendor;
    }

    public void setVendor(Vendor vendor) {
        this.vendor = vendor;
    }

    public int getCapacityKwh() {
        return capacityKwh;
    }

    public void setCapacityKwh(int capacityKwh) {
        this.capacityKwh = capacityKwh;
    }

    public int getMaxPowerKw() {
        return maxPowerKw;
    }

    public void setMaxPowerKw(int maxPowerKw) {
        this.maxPowerKw = maxPowerKw;
    }
}
