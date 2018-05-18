package org.holtnet.StarCraftUnitQuiz;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;

public class ExamActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_exam);

        // Get the view for the button at the end of the activity.
        Button endButton = findViewById(R.id.end_button);

        // When this button is tapped, choose an intent in the chooseIntent() method based on the checked status of all the corresponding variables.
        endButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                chooseIntent();
            }
        });
    }

    private int ScoreCheck() {

        return 0;

    }

    public void chooseIntent() {

        int score = ScoreCheck();

        Intent submitIntent;

            submitIntent = new Intent(ExamActivity.this, ResultsActivity.class);
            //submitIntent.putExtra("USER_NAME", userName.getText().toString());
            submitIntent.putExtra("FINAL_SCORE", score);
            startActivity(submitIntent);
            finish();
    }
}

