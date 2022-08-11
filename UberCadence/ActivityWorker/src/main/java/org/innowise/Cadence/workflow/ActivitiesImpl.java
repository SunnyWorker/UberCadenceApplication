package org.innowise.Cadence.workflow;

import org.innowise.Cadence.entities.Weather;
import org.innowise.Cadence.workers.interfaces.IActivityWorker;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("activities")
public class ActivitiesImpl implements Activities {

    @Autowired
    private IActivityWorker activityWorker;
    @Override
    public Weather firstActivity(String cityName) {
        return activityWorker.getWeather(cityName);
    }

    @Override
    public void secondActivity(Weather weather) {
        activityWorker.addWeatherToDB(weather);
    }
}
