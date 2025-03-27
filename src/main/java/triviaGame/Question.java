/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package triviaGame;

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

    public void setCorrect_answer(String correct_answer) {
        this.correct_answer = correct_answer;
    }

    public String[] getIncorrect_answers() {
        return incorrect_answers;
    }

    public void setIncorrect_answers(String[] incorrect_answers) {
        this.incorrect_answers = incorrect_answers;
    }

    @Override
    public String toString(){

        return String.format("Type: %s \n" +
                        "Difficulty: %s \n" +
                        "Category: %s \n" +
                        "Question: %s \n" +
                        "Correct Answer: %s ",
                this.type, this.difficulty, this.category, this.question, this.correct_answer);
    }
}



