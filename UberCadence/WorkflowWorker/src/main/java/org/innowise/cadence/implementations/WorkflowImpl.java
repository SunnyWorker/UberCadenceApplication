package org.innowise.cadence.implementations;

import com.uber.cadence.workflow.Workflow;

import org.innowise.cadence.interfaces.Activities;
import org.innowise.cadence.interfaces.IWorkflow;
import org.innowise.entities.Weather;

public class WorkflowImpl implements IWorkflow {

    private final Activities activities;

    public WorkflowImpl() {
        this.activities = Workflow.newActivityStub(Activities.class);
    }

    @Override
    public void execute(String cityName) {
        Weather weather = activities.firstActivity(cityName);
        activities.secondActivity(weather);
    }
}
