package api;

/*
    TASK QUEUE STRING

    Task Queue is represented in code by its name as a string.

    Four places where the name of the Task Queue is supplied by the developer:
    1. When initiating a Workflow, a Task Queue name must be provided in the StartWorkflowOptions
    2. A Task Queue name must be provided as a parameter when creating a Worker.
    3. Optionally, the name of a Task Queue can be provided in the ActivityOptions when calling an Activity from a Workflow.
    4. Optionally, the name of a Task Queue can be provided in the ChildWorkflowOptions when calling a Child Workflow.
 */
public interface TaskQueue {

    String API_TASK_QUEUE = "API_TASK_QUEUE";
}
