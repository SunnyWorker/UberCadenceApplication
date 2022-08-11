package org.innowise.workflowlauncher.workflows;

import com.uber.cadence.workflow.WorkflowMethod;

public interface IWorkflow {
    @WorkflowMethod(executionStartToCloseTimeoutSeconds = 10, taskList = "db_access")
    void execute(String cityName);
}