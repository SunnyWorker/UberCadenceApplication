package org.innowise.entities;

import com.fasterxml.jackson.annotation.JsonProperty;

public class MainJSON {
    @JsonProperty("temp")
    private double temperature;

    public double getTemperature() {
        return temperature;
    }

    public void setTemperature(double temperature) {
        this.temperature = temperature;
    }
}
