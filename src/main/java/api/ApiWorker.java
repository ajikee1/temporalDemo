package api;

/*
    WORKER
    A Worker is a service that executes Workflows and Activities.

    Workers poll Task Queues for Tasks, execute chunks of code in response to those Tasks, and then communicate the results back to the Temporal Server.
 */

import io.temporal.client.WorkflowClient;
import io.temporal.serviceclient.WorkflowServiceStubs;
import io.temporal.worker.Worker;
import io.temporal.worker.WorkerFactory;


public class ApiWorker {

    /* When running the workflow, the worker should be started separately */

    /*
        To start a Worker you need to:
            1. Create a WorkflowClient instance
            2. Optionally create WorkerOptions
            3. Create a WorkerFactory instance
            4. Create a Worker using the created WorkerFactory's newWorker method
            5. Register Workflows and Activities this Worker should execute
     */

    public static void main(String[] args){

        WorkflowServiceStubs service = WorkflowServiceStubs.newInstance();

        /* Create a WorkflowClient instance */
        WorkflowClient client = WorkflowClient.newInstance(service);

        /* Create a WorkerFactory instance */
        WorkerFactory factory = WorkerFactory.newInstance(client);

        /*
            Create a Worker using the created WorkerFactory's newWorker method
            A Task Queue name must be provided as a parameter when creating a Worker.
         */
        Worker worker = factory.newWorker(TaskQueue.API_TASK_QUEUE);

        /* Registering the WORKFLOW implementation with the worker */
        worker.registerWorkflowImplementationTypes(ApiWorkFlowImp.class);

        /* Registering the ACTIVITY implementation with the worker */
        worker.registerActivitiesImplementations(new ApiActivityImp());

        /* Start polling the Task Queue */
        factory.start();


    }
}
