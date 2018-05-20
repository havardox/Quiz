package com.example.android.quiz;

import java.util.Arrays;

class Questions {

    private final Question[] questions = createQuestions();

    // array of multiple choices for each question
    private final String[][] choices = {
            {"2003", "2008", "2001", "2005"},
            {"Android Operating System Project", "Android Open Source Project", "Android Open Stack Programming", "Android Open Source Protocol"},
            {"4.2", "4.3", "4.1", "4.4"},
            {"Eclair", "Froyo", "Gingerbread", "Honeycomb"},
            {"Nexus 4", "Nexus S", "Galaxy Nexus", "Nexus 10"},
            {"Kandy Korn", "Key Lime Pie", "Kaiser roll", "Kiwi"},
            {"4.0", "4.3", "1.0", "4.2"},
            {"MIMO", "Google", "Android", "Malmo"},
            {"4.1", "4.2", "4.3", "All of the above"},
            {"Galaxy Nexus", "Nexus 2", "Nexus 3", "Nexus S"}

    };

    // array of correct answers - in the same order as array of questions
    private final String[] correctAnswers = {"2003", "Android Open Source Project", "4.1", "Honeycomb", "Galaxy Nexus", "Key Lime Pie", "4.2", "Malmo", "All of the above", "Nexus S"};

    // Returns the number of questions.
    public int getLength() {
        return questions.length;
    }

    // Returns a question.
    public String getQuestion(int questionNumber) {
        return questions[questionNumber].Question;
    }

    // Returns a image reference.
    public int getImageReference(int questionNumber) {
        return questions[questionNumber].ImageReference;
    }

    // Creates questions.
    private Question[] createQuestions() {
        Question[] questions = new Question[10];
        questions[0] = new Question("What year was Android founded?");
        questions[1] = new Question("What does AOSP stand for?");
        questions[2] = new Question("What version of Android is this?", R.drawable.question3);
        questions[3] = new Question("What version of Android never came to phones?");
        questions[4] = new Question("Before its release, what device was known as the \"Nexus Prime\"?");
        questions[5] = new Question("Before Google and Nestle teamed up to call Android 4.4 \"KitKat,\" what was it referred to as internally?");
        questions[6] = new Question("What version of Android is this camera app from?", R.drawable.question6);
        questions[7] = new Question("What is the \"brand\" of the clock widget in Android 1.0?");
        questions[8] = new Question("What version of Android is codenamed \"Jelly Bean\"?");
        questions[9] = new Question("What phone is this?", R.drawable.question10);
        return questions;
    }

    // Returns a choice for the question.
    public String getChoice(int questionNumber, int choice) {
        return choices[questionNumber][choice - 1];
    }

    // Returns a correct answer.
    public String getCorrectAnswer(int questionNumber) {
        return correctAnswers[questionNumber];
    }

    // Returns index for correct answer in choices array.
    public int getCorrectAnswerIndex(int questionNumber) {
        return Arrays.asList(choices[questionNumber]).indexOf(getCorrectAnswer(questionNumber));
    }
}
