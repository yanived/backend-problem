package com.example.ageera.model.configuration;

import jakarta.validation.Valid;

public class Production {
    @Valid
    private Producer pv;
    @Valid
    private Producer bio;
    @Valid
    private Producer cro;

    public Producer getPv() {
        return pv;
    }

    public void setPv(Producer pv) {
        this.pv = pv;
    }

    public Producer getBio() {
        return bio;
    }

    public void setBio(Producer bio) {
        this.bio = bio;
    }

    public Producer getCro() {
        return cro;
    }

    public void setCro(Producer cro) {
        this.cro = cro;
    }
}
