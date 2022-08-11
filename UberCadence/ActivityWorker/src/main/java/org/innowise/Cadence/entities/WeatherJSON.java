package org.innowise.Cadence.entities;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonSubTypes;

public class WeatherJSON {

//    @JsonProperty(value = "cod")
//    private int answerCode;
    @JsonProperty(value="cod")
    private String answerCode;
    @JsonProperty(value = "main")
    private MainJSON mainJSON;
    @JsonProperty(value = "name")
    private String cityName;

    public String getErrorCode() {
        return answerCode;
    }

    public void setErrorCode(String answerCode) {
        this.answerCode = answerCode;
    }

    public double getTemperature() {
        return mainJSON.getTemperature();
    }

    public void setMainJSON(MainJSON mainJSON) {
        this.mainJSON = mainJSON;
    }

    public String getCityName() {
        return cityName;
    }

    public void setCityName(String cityName) {
        this.cityName = cityName;
    }
}
