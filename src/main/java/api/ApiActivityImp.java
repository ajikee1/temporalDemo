package api;

/*
    ACTIVITY INTERFACE IMPLEMENTATION (ACTIVITY)

    Activities in Temporal Java SDK programming model are classes which implement the ActivityInterface Interface.
 */

public class ApiActivityImp implements ApiActivity{

    /*
        Business Logic
     */
    @Override
    public String runGetApiRequest(String input) {
        String apiResponse = "This is the mock API response " + input;
        return apiResponse;
    }


}
