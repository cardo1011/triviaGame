package triviaGame;

import java.util.ArrayList;
import java.util.List;

public class IncorrectAnswerTracker {
    private final List<String> incorrectlyAnsweredQuestions = new ArrayList<String>();
    private final List<String> correctAnswersForIncorrectQuestions = new ArrayList<String>();


    //The default constructor is sufficient because the questions and correctAnswers list are created dynamically in game. This constructor isn't even necessary because Java provides it by default but i wanted to leave my reasoning here to future proof this project. You will probably never read this absurdly long comment anyways. I like turtles...
    public IncorrectAnswerTracker() {}

    public List<String> getIncorrectlyAnsweredQuestions() {
        return incorrectlyAnsweredQuestions;
    }

    // Adds a question to the list of incorrectly answered questions.
    public void addIncorrectlyAnsweredQuestion(String question) {
        this.incorrectlyAnsweredQuestions.add(question);
    }

    public List<String> getCorrectAnswersForIncorrectQuestions() {
        return correctAnswersForIncorrectQuestions;
    }

    // Adds the correct answer corresponding to an incorrectly answered question to the list of correct answers.
    public void addCorrectAnswerToIncorrectlyAnsweredQuestion(String correctAnswer) {
        this.correctAnswersForIncorrectQuestions.add(correctAnswer);
    }



}
