package api;

import io.temporal.activity.ActivityInterface;
import io.temporal.activity.ActivityMethod;

/*
    ACTIVITY INTERFACE
    Activity Interfaces are Java Interfaces which are annotated with the @ActivityInterface annotation
 */


/*
    Activities: Business logic.

    Activities are implementations of certain tasks which need to be performed during a Workflow execution.
    They can be used to interact with external systems, such as databases, services, etc.
    Workflows orchestrate invocations of Activities.

    Activities must be registered with a Worker.
 */

@ActivityInterface
public interface ApiActivity {

    /*
        Each method defined in the Activity interface defines a separate Activity method.
        You can annotate each method in the Activity interface with the @ActivityMethod annotation
     */
    @ActivityMethod
    String runGetApiRequest(String input);

}
