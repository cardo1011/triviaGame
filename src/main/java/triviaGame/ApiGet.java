/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package triviaGame;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

/**
 *
 * @author ricardomunoz
 */
     public class ApiGet {


         //*******all this code is commented out for now because this will likely be used to make the URL_STRING dynamic in the future with user input
//         private int category;
//         private String difficulty;
//
//    public ApiGet(int category, String difficulty){
//        this.category = category;
//        this. difficulty = difficulty;
//    }

//    public ApiGet(){};
//
//    public int getCategory() {
//        return category;
//    }
//
//    public void setCategory(int category) {
//        this.category = category;
//    }
//
//    public String getDifficulty() {
//        return difficulty;
//    }
//
//    public void setDifficulty(String difficulty) {
//        this.difficulty = difficulty;
//    }

         public HttpResponse<String> fetchQuestions() throws IOException, InterruptedException {

             //non-dynamic URL of the api used to get trivia questions from
             String API_URL = "https://opentdb.com/api.php?amount=7&category=9&difficulty=easy&type=multiple";

             // Building a "GET" request.
             HttpRequest request = HttpRequest.newBuilder()
                     .GET() //This line is technically unnecessary because the default HttpRequest is a GET request but leaving for readability of code purposes.
                     .uri(URI.create(API_URL))
                     .build();

             //**HttpClient objects are created to be able to send requests and receive responses
             //Here the client object is being created
             HttpClient client = HttpClient.newBuilder().build();

             //We can now create a response using the response we get after sending the client object with the GET request to the API
            return client.send(request, HttpResponse.BodyHandlers.ofString());
         }
    }
