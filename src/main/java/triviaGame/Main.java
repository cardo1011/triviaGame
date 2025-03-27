/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package triviaGame;

import java.io.IOException;
import java.util.Arrays;


/**
 *
 * @author ricardomunoz
 */
public class Main {

    public static void main(String[] args) throws IOException, InterruptedException {



//        //non-dynamic URL of the api used to get trivia questions from
//        String API_URL = "https://opentdb.com/api.php?amount=2&category=9&type=multiple";
//
//        // Building a "GET" request.
//        HttpRequest request = HttpRequest.newBuilder()
//                .GET() //This line is technically unnecessary because the default HttpRequest is a GET request but leaving for readability of code purposes.
//                .uri(URI.create(API_URL))
//                .build();
//
//        //**HttpClient objects are created to be able to send requests and receive responses
//        //Here the client object is being created
//        HttpClient client = HttpClient.newBuilder().build();
//
//        //We can now create a response using the response we get after sending the client object with the GET request to the API
//        HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
//
//        //Printing out the response body to confirm we are receiving the JSON information in the form of a raw string
//        String jsonData = response.body();
//        System.out.println(jsonData);
//
//
//        //Create a Gson instance to parse the raw JSON response into an ApiResponse object.
//        GsonBuilder gsonBuilder = new GsonBuilder();
//        Gson gson = gsonBuilder.create();
//        ApiResponse resObject = gson.fromJson(jsonData, ApiResponse.class);





        //Testing the output of the response using dot notation with the ApiResponse class and the Question class created to handle the results array of objects
//        int responseCode = resObject.getResponse_code();
//        System.out.println(responseCode);
//
//        Question[] results = resObject.getResults();
//        System.out.println(Arrays.toString(results));

        ApiResponse apiResponse = ApiResponse.parseResponse();
        System.out.println("RESULTS: " + Arrays.toString(apiResponse.getResults()));


    }
}
