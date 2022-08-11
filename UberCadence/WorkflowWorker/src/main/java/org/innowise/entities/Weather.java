package org.innowise.entities;

import java.sql.Timestamp;
import java.time.LocalDate;
import java.time.LocalTime;

public class Weather {
    private Long id;

    private Timestamp currentTime;

    private double temperature;

    private String city;

    public Long getId() {
        return id;
    }

    public Weather(Timestamp currentTime, double temperature, String city) {
        this.currentTime = currentTime;
        this.temperature = temperature;
        this.city = city;
    }

    public Weather() {
    }

    public Timestamp getCurrentTime() {
        return currentTime;
    }

    public void setCurrentTime(Timestamp currentTime) {
        this.currentTime = currentTime;
    }

    public double getTemperature() {
        return temperature;
    }

    public void setTemperature(double temperature) {
        this.temperature = temperature;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    @Override
    public String toString() {
        return "Weather{" +
                "id=" + id +
                ", currentTime=" + currentTime +
                ", temperature=" + temperature +
                ", city='" + city + '\'' +
                '}';
    }
}