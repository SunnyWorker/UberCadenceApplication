package org.innowise.cadence.interfaces;

import com.uber.cadence.activity.ActivityMethod;
import org.innowise.entities.Weather;


public interface Activities {
    @ActivityMethod(scheduleToCloseTimeoutSeconds = 2)
    Weather firstActivity(String cityName);
    @ActivityMethod(scheduleToCloseTimeoutSeconds = 2)
    void secondActivity(Weather weather);
}
