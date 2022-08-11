package org.innowise.workflowlauncher;

import com.uber.cadence.client.WorkflowClient;
import com.uber.cadence.client.WorkflowClientOptions;
import com.uber.cadence.serviceclient.ClientOptions;
import com.uber.cadence.serviceclient.WorkflowServiceTChannel;
import org.innowise.workflowlauncher.workflows.IWorkflow;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class WorkflowLauncherApplication {

    public static void main(String[] args) {
        SpringApplication.run(WorkflowLauncherApplication.class, args);
    }

}
