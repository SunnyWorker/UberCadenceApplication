package org.innowise.workflowlauncher.controllers;

import com.uber.cadence.client.WorkflowClient;
import com.uber.cadence.client.WorkflowClientOptions;
import com.uber.cadence.serviceclient.ClientOptions;
import com.uber.cadence.serviceclient.WorkflowServiceTChannel;
import org.innowise.workflowlauncher.workflows.IWorkflow;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CityController {

    @GetMapping("/{cityName}")
    public String executeWorkflow(@PathVariable String cityName) {
        WorkflowClient workflowClient =
                WorkflowClient.newInstance(
                        new WorkflowServiceTChannel(ClientOptions.defaultInstance()),
                        WorkflowClientOptions.newBuilder().setDomain("samples-domain").build());
        IWorkflow workflow = workflowClient.newWorkflowStub(IWorkflow.class);
        workflow.execute(cityName);
        return cityName+"'s weather was added to your database successfully!";
    }
}
