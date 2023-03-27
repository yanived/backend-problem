package com.example.ageera.model.configuration;

import jakarta.validation.Valid;

public class Configuration {
    @Valid
    private Battery battery;
    @Valid
    private Production production;

    public Battery getBattery() {
        return battery;
    }

    public void setBattery(Battery battery) {
        this.battery = battery;
    }

    public Production getProduction() {
        return production;
    }

    public void setProduction(Production production) {
        this.production = production;
    }
}
