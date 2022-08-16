package org.innowise.workers.implementations;

import org.innowise.entities.Weather;
import org.innowise.entities.WeatherJSON;
import org.innowise.exceptions.NoSuchCityException;
import org.innowise.persistance.dao.repositories.MyRepository;
import org.innowise.workers.interfaces.IActivityWorker;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.client.RestTemplateBuilder;
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
