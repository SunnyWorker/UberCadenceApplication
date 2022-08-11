package org.innowise.Cadence.workers.implementations;

import com.fasterxml.jackson.databind.util.JSONPObject;
import org.innowise.Cadence.entities.Weather;
import org.innowise.Cadence.entities.WeatherJSON;
import org.innowise.Cadence.exceptions.NoSuchCityException;
import org.innowise.Cadence.persistance.dao.repositories.MyRepository;
import org.innowise.Cadence.workers.interfaces.IActivityWorker;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Lazy;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.RestTemplate;

import java.sql.Timestamp;
import java.time.LocalDateTime;

@Service("activity-worker")
public class ActivityWorkerImpl implements IActivityWorker {

    RestTemplate restTemplate = new RestTemplateBuilder().build();

    @Autowired
    MyRepository repository;

    @Override
    public Weather getWeather(String cityName) {
        try {

            ResponseEntity<WeatherJSON> responseEntity =
                    restTemplate.getForEntity("http://api.openweathermap.org/data/2.5/weather?q=" +
                            cityName + "&APPID=8206cecc490295cbe6ca9d2a66684c34", WeatherJSON.class);
            Weather weather = new Weather();
            weather.setCity(responseEntity.getBody().getCityName());
            weather.setCurrentTime(Timestamp.valueOf(LocalDateTime.now()));
            weather.setTemperature(responseEntity.getBody().getTemperature());
            return weather;
        }
        catch (HttpClientErrorException exception) {
            throw new NoSuchCityException("No city with that name found");
        }
    }
    @Override
    public void addWeatherToDB(Weather weather) {
        repository.save(weather);
    }
}
