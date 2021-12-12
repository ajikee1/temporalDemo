package api;

import io.temporal.workflow.WorkflowInterface;
import io.temporal.workflow.WorkflowMethod;

/*
    WORKFLOW INTERFACE

    A Workflow: Workflows are functions that organize Activity method calls.
 */

@WorkflowInterface
public interface ApiWorkFlow {

    /*
        @WorkflowMethod denotes the starting point of Workflow execution. Workflow execution completes when this methods returns.
     */
    @WorkflowMethod
    String runApiRequest(String input);

}


/*
    Other possible workFlow interface annotations:

    @SignalMethod indicates that this method is a signal handler method and that it can react to external signals.
    It can have parameters which can contain the signal payload. It does not return a value, so it must have a void return type.

    @QueryMethod indicates that this method can be used to query the Workflow's state at any time during its execution.
    It can have parameters which can be used to filter a subset of the Workflow's state that it returns.
    Since it does return a value it must have a non void return type.
 */