package api;

import io.temporal.activity.ActivityOptions;
import io.temporal.workflow.Workflow;
import java.time.Duration;

/*
    WORKFLOW INTERFACE IMPLEMENTATION (WORKFLOW)

    In the Temporal Java SDK programming model, a Workflow is a class which implements a Workflow Interface.
    Workflow runs the activity methods a.k.a business logic
 */

public class ApiWorkFlowImp implements ApiWorkFlow{


    /* Activity options allow you to specify different Activity timeout and retry options*/
    ActivityOptions options = ActivityOptions.newBuilder().setScheduleToCloseTimeout(Duration.ofSeconds(2)).build();

    /*
        Activities should only be instantiated via stubs.
        Workflow.newActivityStub returns a client-side stub that implements an Activity interface. It takes Activity type and Activity options as arguments.
        ActivityStubs enable calls to Activities as if they are local methods, but actually perform an RPC.
     */
    private final ApiActivity apiActivity = Workflow.newActivityStub(ApiActivity.class, options);


    @Override
    public String runApiRequest(String input){
        /*
            This is the entry point to the Workflow.
            If there were other Activity methods they would be orchestrated here or from within other Activities.
         */

        /* Calling the implemented activity method using the stub */
        String  resp = apiActivity.runGetApiRequest(input);
        return resp;
    }

}
