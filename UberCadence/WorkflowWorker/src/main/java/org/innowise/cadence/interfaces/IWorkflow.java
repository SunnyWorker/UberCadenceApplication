package org.innowise.cadence.interfaces;

import com.uber.cadence.workflow.WorkflowMethod;

public interface IWorkflow {
    @WorkflowMethod(executionStartToCloseTimeoutSeconds = 10, taskList = "db_access")
    void execute(String cityName);
}
