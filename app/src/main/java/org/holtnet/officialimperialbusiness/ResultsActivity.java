package org.holtnet.officialimperialbusiness;

import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class ResultsActivity extends AppCompatActivity {

    private int score;
    private double percentScore;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
        setContentView(R.layout.activity_results);

        score = 0;

        Bundle extras = getIntent().getExtras();
        if (extras != null) {
            score = extras.getInt("FINAL_SCORE");
        }

        percentScore = (score / 14.0) * 100;

        TextView scoreView = findViewById(R.id.Score);
        scoreView.setText(String.valueOf((int)percentScore) + "%");

        Button returnButton = findViewById(R.id.return_button);

        returnButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent beginIntent = new Intent(ResultsActivity.this, MainActivity.class);
                startActivity(beginIntent);
            }
        });
    }
}
