package triviaGame;


import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.IOException;
import java.util.Arrays;

public class ApiResponse {
    private int response_code;
    private Question[] results;

    public ApiResponse() {
    }


    @Override
    public String toString() {
        return "ApiResponse{" +
                "response_code = " + response_code +
                ", results = " + Arrays.toString(results) +
                '}';
    }

    public ApiResponse(int response_code,Question[] results) {
        this.response_code = response_code;
        this.results = results.clone();
    }

    public int getResponse_code() {
        return response_code;
    }

    public void setResponse_code(int response_code) {
        this.response_code = response_code;
    }

    public Question[] getResults() {
        return results;
    }

    public void setResults(Question[] results) {
        this.results = results ;
    }

    public static ApiResponse parseResponse() throws IOException, InterruptedException {

        ApiGet newGetRequestString = new ApiGet();

        //receiving the JSON information in the form of a raw string
        String jsonData = newGetRequestString.fetchQuestions().body();


        //Create a Gson instance to parse the raw JSON response into an ApiResponse object.
        GsonBuilder gsonBuilder = new GsonBuilder();
        Gson gson = gsonBuilder.create();
        ApiResponse resObject = gson.fromJson(jsonData, ApiResponse.class);

        return resObject;
    }
}
