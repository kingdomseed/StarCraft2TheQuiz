package org.holtnet.StarCraftUnitQuiz;

import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class ResultsActivity extends AppCompatActivity {

    // PIVs for the score itself and the String that has the score
    private int score = 0;
    private String scoreString = "";

    // declare views
    TextView scoreText;
    Button mainMenuButton;
    Button shareButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
        setContentView(R.layout.activity_results);

        // initialize views
        scoreText = findViewById(R.id.Score);
        mainMenuButton = findViewById(R.id.return_button);
        shareButton = findViewById(R.id.share_button);

        // retrieve the score passed into the bundle from ExamActivity as long as it's not null.
        Bundle extras = getIntent().getExtras();
        if (extras != null) {
            score = extras.getInt("FINAL_SCORE");
        }

        // Calculate the score as a percentage value
        double scorePercent = ( (double) score / 5.0) * 100.0;

        // Update the scoreString to contain the final score as a percentage along with relevant text
        scoreString = "Your final score is: " + (int)scorePercent + "%";

        // Update the TextView with the scoreString
        scoreText.setText(scoreString);

        // Display a toast of the score String
        Toast.makeText(getApplicationContext(), scoreString,Toast.LENGTH_SHORT).show();

        // This button allows the user to return to the main menu and start again.
        mainMenuButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent submitIntent = new Intent(ResultsActivity.this, MainActivity.class);
                startActivity(submitIntent);
                finish();
            }
        });

        // This button allows the user to share their score with their friends.
        shareButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent shareIntent = new Intent();
                shareIntent.setAction(Intent.ACTION_SEND);
                shareIntent.putExtra(Intent.EXTRA_TEXT,  scoreString);
                shareIntent.setType("text/plain");
                startActivity(shareIntent);
                finish();
            }
        });

    }
}
