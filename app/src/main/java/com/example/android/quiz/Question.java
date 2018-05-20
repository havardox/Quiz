package com.example.android.quiz;

class Question {
    public final int ImageReference;
    public final String Question;

    public Question(String Question, Integer ImageReference) {
        this.ImageReference = ImageReference;
        this.Question = Question;
    }

    // Set ImageReference to 0 if not present.
    public Question(String Question) {
        this(Question, 0);
    }
}


