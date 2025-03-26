package triviaGame;


import java.util.Arrays;

public class ApiResponse {
    private int response_code;
    private Question[] results;


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
}
