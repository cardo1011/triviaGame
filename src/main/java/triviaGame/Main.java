/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package triviaGame;

import java.io.IOException;
import java.util.Arrays;
import java.util.Locale;
import java.util.Scanner;


/**
 *
 * @author ricardomunoz
 */
public class Main {

    public static void main(String[] args) throws IOException, InterruptedException {

        //Fetching questions from API
        ApiResponse apiResponse = ApiResponse.parseResponse();
//        System.out.println("RESULTS: " + Arrays.toString(apiResponse.getResults())); //this verifies the amount of questions and category is returning as intended

        //Creating an array of questions by doing a shallow copy of the API response
        Question[] questions = apiResponse.getResults().clone();


        //Rules and instructions of the game
        System.out.println("*********************************************************************************************************************************************************************************");
        System.out.print("Welcome to the trivia game! \n\n" +
                "- You will be prompted with 1 question at a time and will answer 7 questions total. \n" +
//                "- There will be a 70 second timer going on while you play.\n" +
                "- Answer the questions as fast as you can by typing in the letter corresponding to your answer and then pressing ENTER to submit your answer.\n" +
                "- At the end of the game, you will be shown your score and the right answer to each question.\n" +
                "\n *** Press ENTER when you are ready to play! ***");

        Scanner input = new Scanner(System.in);
//        System.out.println(Arrays.toString(questions));
        System.out.println();


        if(input.nextLine().isEmpty()){     // Will check if nextLine isEmpty in order to start the game when the user presses ENTER

            int i = 0;
            int score = 0;

            while( i < questions.length){


                String[] arrayOfIncorrectAnswersFromAPI = questions[i].getIncorrect_answers();
                String correctAnswer = questions[i].getCorrect_answer();

                String activeQuestion = questions[i].getQuestion();

                String[] arrayOfshuffledAnswers = questions[i].shuffleAnswers(correctAnswer, arrayOfIncorrectAnswersFromAPI);

                String[] arrayOflabeledAndShuffledAnswers = questions[i].addLabelsToShuffledAnswers(arrayOfshuffledAnswers);


                System.out.println(activeQuestion); //prints out the active question from the questions array

                //prints out the answer choices
                for (String answer : arrayOflabeledAndShuffledAnswers) {
                    System.out.println(answer);
                }

//                System.out.println(correctAnswer);


                String userAnswer = input.nextLine();

                switch(userAnswer) {
                    case "A", "a":
                        userAnswer = "A";
                        break;
                    case "B", "b":
                        userAnswer = "B";
                        break;
                    case "C", "c":
                        userAnswer = "C";
                        break;
                    case "D", "d":
                        userAnswer = "D";
                        break;
                    default:
                        userAnswer = "X";
                }

                char alphanumericalRepresentationOfTheCorrectAnswer= questions[i].getCorrect_answer().charAt(1);

                if(userAnswer.equals(String.valueOf(alphanumericalRepresentationOfTheCorrectAnswer))){
                    score++;
                }

                if(userAnswer.equals(String.valueOf(correctAnswer))){
                    score++;
                }

                System.out.println();
                i++;

                }

            System.out.println("You got " + score + " out of " + questions.length + " question(s) correctly answered.");

            System.out.println();
            System.out.println("The questions INcorrectly  answered: ");


            }

        }

    }
