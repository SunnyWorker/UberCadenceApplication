package org.innowise.workers.interfaces;

import org.innowise.entities.Weather;

public interface IActivityWorker {
    Weather getWeather(String cityName);
    void addWeatherToDB(Weather weather);
}
