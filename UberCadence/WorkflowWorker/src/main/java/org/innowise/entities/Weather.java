package org.innowise.entities;

import javax.persistence.*;
import java.sql.Timestamp;

@Entity(name = "weather_reports")
@Table(name = "weather_reports")
public class Weather {

    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private Long id;
    @Column(name="time")
    private Timestamp currentTime;

    @Column(name="air_temperature")
    private double temperature;

    public Weather() {
    }

    public Weather(Timestamp currentTime, double temperature, String city) {
        this.currentTime = currentTime;
        this.temperature = temperature;
        this.city = city;
    }

    private String city;

    public Long getId() {
        return id;
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
