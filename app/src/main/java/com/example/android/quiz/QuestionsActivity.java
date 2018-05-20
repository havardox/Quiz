package com.example.android.quiz;

import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

public class QuestionsActivity extends AppCompatActivity {

    private final Questions questions = new Questions();

    private Button choice1; // button for choice 1
    private Button choice2; // button for choice 2
    private Button choice3; // button for choice 3
    private Button choice4; // button for choice 4
    private TextView scoreTextView;  // view for current total score
    private ImageView imageView; // view for image
    private TextView questionTextView; // view for current question
    private Button correctAnswerButton; // view for correct answer button
    private String correctAnswer; // correct answer for question
    private int score = 0; // current score
    private int questionNumber = 0; // current question number
    private Drawable defaultButtonTheme; // default button theme

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_question);

        // Set up screen for first question.
        choice1 = findViewById(R.id.choice1);
        choice2 = findViewById(R.id.choice2);
        choice3 = findViewById(R.id.choice3);
        choice4 = findViewById(R.id.choice4);
        scoreTextView = findViewById(R.id.score);
        questionTextView = findViewById(R.id.question);
        imageView = findViewById(R.id.image);
        defaultButtonTheme = choice1.getBackground(); // Get background of default Android button.
        updateQuestion();
        updateScore();
    }

    // Updates screen to current score.
    private void updateScore() {
        scoreTextView.setText("" + score + "/" + questions.getLength());
    }

    // Updates screen to current question.
    private void updateQuestion() {
        if (questionNumber < questions.getLength()) {
            int imageReference = questions.getImageReference(questionNumber);
            if (imageReference == 0) {
                if (imageView.getVisibility() == View.VISIBLE) {

                    // Hide ImageView.
                    imageView.setVisibility(View.GONE);
                }
            } else {
                if (imageView.getVisibility() == View.GONE) {

                    // Show ImageView.
                    imageView.setVisibility(View.VISIBLE);
                }
                imageView.setImageResource(imageReference);
            }
            questionTextView.setText(questions.getQuestion(questionNumber));
            choice1.setText(questions.getChoice(questionNumber, 1));
            choice2.setText(questions.getChoice(questionNumber, 2));
            choice3.setText(questions.getChoice(questionNumber, 3));
            choice4.setText(questions.getChoice(questionNumber, 4));
            correctAnswer = questions.getCorrectAnswer(questionNumber);
            int resID = getResources().getIdentifier("choice" + (questions.getCorrectAnswerIndex(questionNumber) + 1), // Get resource ID for correct answer button.
                    "id", getPackageName());
            correctAnswerButton = findViewById(resID);
            questionNumber++;
        } else {
            Intent intent = new Intent(QuestionsActivity.this, HighestScoreActivity.class);
            intent.putExtra("score", score);
            startActivity(intent);
        }
    }

    public void onClick(View v) {
        final Button answer = (Button) v;

        if (answer.getText() == correctAnswer) {

            // Increase score by 1 and change clicked button to green.
            score = score + 1;
            answer.setBackgroundColor(Color.parseColor("#3BC14A"));

        } else {

            // Change clicked button to red and answer button to green.
            answer.setBackgroundColor(Color.parseColor("#F06543"));
            correctAnswerButton.setBackgroundColor(Color.parseColor("#3BC14A"));
        }

        // Make buttons not clickable.
        choice1.setClickable(false);
        choice2.setClickable(false);
        choice3.setClickable(false);
        choice4.setClickable(false);

        // Set 1 second delay.
        new Handler().postDelayed(new Runnable() {

            @Override
            public void run() {

                // Change button colors back to original.
                answer.setBackgroundDrawable(defaultButtonTheme);
                correctAnswerButton.setBackgroundDrawable(defaultButtonTheme);

                // Make buttons clickable.
                choice1.setClickable(true);
                choice2.setClickable(true);
                choice3.setClickable(true);
                choice4.setClickable(true);

                // Update score and question.
                updateScore();
                updateQuestion();
            }
        }, 1000);
    }
}
