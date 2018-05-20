package com.example.android.quiz;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;

public class HighestScoreActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_highest_score);

        TextView txtScore = findViewById(R.id.textScore);
        TextView txtHighScore = findViewById(R.id.textHighScore);

        // Receive score from last activity by Intent.
        Intent intent = getIntent();
        int score = intent.getIntExtra("score", 0);

        // Display current score.
        txtScore.setText("Your score: " + score);

        // Use shared preferences to save highest score.
        SharedPreferences mypref = getPreferences(MODE_PRIVATE); // Retrieve shared preferences file and open it in private mode.
        int highscore = mypref.getInt("highscore", 0); // Retrieve high score. If not present, set value to 0.
        if (highscore >= score) {
            txtHighScore.setText("High score: " + highscore);
        }
        else {
            txtHighScore.setText("New highscore: " + score);
            SharedPreferences.Editor editor = mypref.edit(); // Open shared preferences editor.
            editor.putInt("highscore", score); // Write new high score to file.
            editor.apply(); // Apply changes.
        }
    }

    public void onClick(View v) {
        Intent intent = new Intent(HighestScoreActivity.this, MainActivity.class);
        startActivity(intent);
    }
}
