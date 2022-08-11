package org.innowise.Cadence.workers.interfaces;

import org.innowise.Cadence.entities.Weather;

public interface IActivityWorker {
    Weather getWeather(String cityName);
    void addWeatherToDB(Weather weather);
}
