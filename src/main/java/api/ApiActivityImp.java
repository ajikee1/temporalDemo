package api;

import java.io.BufferedReader;
import java.io.InputStreamReader;

import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.HttpClientBuilder;

/*
    ACTIVITY INTERFACE IMPLEMENTATION (ACTIVITY)

    Activities in Temporal Java SDK programming model are classes which implement the ActivityInterface Interface.
 */

public class ApiActivityImp implements ApiActivity {

    /*
        Business Logic
     */
    @Override
    public String runGetApiRequest(String input) {

        String line = null;
        StringBuffer result = new StringBuffer();

        HttpClient client = HttpClientBuilder.create().build();
        HttpGet get = new HttpGet("https://restcountries.com/v3.1/capital/" + input);

        try {
            HttpResponse response = client.execute(get);
            BufferedReader reader = new BufferedReader(new InputStreamReader(response.getEntity().getContent()));

            while ((line = reader.readLine()) != null) {
                result.append(line.toString());
            }
        } catch (Exception e) {
        }

        return result.toString();
    }


}
