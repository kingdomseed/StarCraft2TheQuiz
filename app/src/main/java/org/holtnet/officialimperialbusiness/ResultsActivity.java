package org.holtnet.officialimperialbusiness;

import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import org.w3c.dom.Text;

public class ResultsActivity extends AppCompatActivity {

    String scoreName = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
        setContentView(R.layout.activity_results);

        String name = "";
        int score = 0;

        Bundle extras = getIntent().getExtras();
        if (extras != null) {
            name = extras.getString("USER_NAME");
            score = extras.getInt("FINAL_SCORE");
        }

        double percentScore = (score / 14.0) * 100;
        String finalScoreText = "'s Final Score";

        TextView titleText = findViewById(R.id.TitleTextTop);
        TextView scoreView = findViewById(R.id.Score);
        titleText.setText(name + finalScoreText);
        scoreView.setText(String.valueOf((int)percentScore) + "%");

        scoreName = name + "'s Final Score: " + score + "%. Is it your Destiny to score higher? Download the app and try!";

        Button returnButton = findViewById(R.id.return_button);
        Button shareButton = findViewById(R.id.share_button);

        returnButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent beginIntent = new Intent(ResultsActivity.this, MainActivity.class);
                startActivity(beginIntent);
                finish();
            }
        });

        shareButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent shareIntent = new Intent();
                shareIntent.setAction(Intent.ACTION_SEND);
                shareIntent.putExtra(Intent.EXTRA_TEXT,  scoreName);
                shareIntent.setType("text/plain");
                startActivity(shareIntent);
            }
        });
    }
}
