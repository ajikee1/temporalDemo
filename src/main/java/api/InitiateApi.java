package api;

import io.temporal.client.WorkflowClient;
import io.temporal.client.WorkflowOptions;
import io.temporal.serviceclient.WorkflowServiceStubs;

/*
    WORKFLOW INITIATOR

    Starts a workflow.

    There are two ways to start a Workflow, via the Temporal CLI or Temporal SDK
 */
public class InitiateApi {

    public static void main(String[] args){

        /* This RPC (Remote Procedure Call) stubs wrapper talks to the local docker instance of the Temporal service */
        WorkflowServiceStubs service = WorkflowServiceStubs.newInstance();

        /* WorkflowClient can be used to start, signal, query, cancel, and terminate Workflows */
        WorkflowClient client = WorkflowClient.newInstance(service);

        /* When initiating a Workflow, a Task Queue name must be provided in the StartWorkflowOptions */
        WorkflowOptions options = WorkflowOptions.newBuilder().setTaskQueue(TaskQueue.API_TASK_QUEUE).build();

        /* WorkflowStubs enable calls to methods as if the Workflow object is local, but actually perform an RPC */
        ApiWorkFlow workflow = client.newWorkflowStub(ApiWorkFlow.class, options);

        /* Running the workflow @WorkflowMethod */
        workflow.runApiRequest("lima");

        System.exit(0);


    }
}
