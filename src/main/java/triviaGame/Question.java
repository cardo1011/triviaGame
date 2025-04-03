/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package triviaGame;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 *
 * @author ricardomunoz
 */
public class Question {

        private String type;
        private String difficulty;
        private String category;
        private String question;
        private String correct_answer;
        private String[] incorrect_answers;
        private String[] shuffledAnswers;

        public Question(String type,
                        String difficulty,
                        String category,
                        String question,
                        String correct_answer,
                        String[] incorrect_answers){
            this.type= type;
            this.difficulty= difficulty;
            this.category = category;
            this.question = question;
            this.correct_answer = correct_answer;
            this.incorrect_answers =  incorrect_answers.clone();
            }

    public String[] getShuffledAnswers() {
        return shuffledAnswers;
    }

    public void setShuffledAnswers(String[] shuffledAnswers) {
        this.shuffledAnswers = shuffledAnswers;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getDifficulty() {
        return difficulty;
    }

    public void setDifficulty(String difficulty) {
        this.difficulty = difficulty;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getQuestion() {
        return question;
    }

    public void setQuestion(String question) {
        this.question = question;
    }

    public String getCorrect_answer() {
        return correct_answer;
    }

    public void setCorrect_answer(String answer) {
        this.correct_answer = answer;
    }

    public String[] getIncorrect_answers() {
        return incorrect_answers;
    }

    public void setIncorrect_answers(String[] incorrect_answers) {
        this.incorrect_answers = incorrect_answers;
    }

    public String[] shuffleAnswers(String correctAnswer, String[] arrayOfIncorrectAnswers){
        //Creating a list array to merge the correct answer and the incorrect answers together
        List<String> answers = new ArrayList<>(Arrays.asList(arrayOfIncorrectAnswers));

        //Appending the correct answer to the incorrect answers
        answers.add(correctAnswer);

        //Shuffling the order of the answers so the correct answer is not always at the same index
        Collections.shuffle(answers);

        //updating shuffledAnswers array in order to update the correct answer
        setShuffledAnswers(answers.toArray(new String[0]));

        return answers.toArray(new String[0]);
    }

    public String[] addLabelsToShuffledAnswers(String[] arrayOfShuffledAnswers) {

        //Assigning the traditional A,B,C,D answer choices to each answer to be able to answer quicker while in game
        char alphabeticalAnswerChoice = 'A';
        for(int i = 0; i < arrayOfShuffledAnswers.length; i++){
            arrayOfShuffledAnswers[i] = "(" +  alphabeticalAnswerChoice + ") " + arrayOfShuffledAnswers[i];
            alphabeticalAnswerChoice++; //incrementing a char actually increments the unicode and therefore allows us to loop simultaneously through the alphabet
        }

        //updating shuffledAnswers with the new array that prepended labels to each element in the array
        setShuffledAnswers(arrayOfShuffledAnswers);


        //***The correct_answer needs to be updated to the correct answer with the prepended label.

        //Creating a regex that will match the correct answer with its corresponding label
        String regex = "\\(" + "[A-Z]" + "\\)" + "\\s" + correct_answer;
        Pattern pattern = Pattern.compile(regex, Pattern.CASE_INSENSITIVE); //making sure the regex match is case insensitive

        //iterate through the shuffledAnswers array until we find a match for the regex and then update the correct_answer with the corresponding prepended label
        for (String shuffledAnswer : shuffledAnswers) {

            Matcher matcher = pattern.matcher(shuffledAnswer); //using .matcher() because we want an exact match of the correct answer
            boolean found = matcher.matches();

            if (found) {
//                System.out.println("********" + correct_answer + "*********");
                setCorrect_answer(shuffledAnswer);
//                System.out.println("Updated correct answer: " + correct_answer + "*********");
            }
        }
        return arrayOfShuffledAnswers;
    }


    @Override
    public String toString(){

        return String.format("\nType: %s \n" +
                        "Difficulty: %s \n" +
                        "Category: %s \n" +
                        "Question: %s \n" +
                        "Correct Answer: %s ",
                this.type, this.difficulty, this.category, this.question, this.correct_answer);
    }
}



