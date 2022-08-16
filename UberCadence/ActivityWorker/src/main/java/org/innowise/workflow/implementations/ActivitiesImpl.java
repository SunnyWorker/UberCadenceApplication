package org.innowise.workflow.implementations;

import org.innowise.cadence.interfaces.Activities;
import org.innowise.entities.Weather;
import org.innowise.workers.interfaces.IActivityWorker;
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
