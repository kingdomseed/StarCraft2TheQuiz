package org.holtnet.StarCraftUnitQuiz;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;

public class ExamActivity extends AppCompatActivity {

    EditText editTextQuestion;
    RadioButton radioButtonQuestion2;
    RadioButton radioButtonQuestion3;

    CheckBox question4answer1;
    CheckBox question4answer2;
    CheckBox question4answer3;
    CheckBox question4answer4;

    CheckBox question5answer1;
    CheckBox question5answer2;
    CheckBox question5answer3;
    CheckBox question5answer4;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_exam);

        Button endButton = findViewById(R.id.end_button);

        editTextQuestion = findViewById(R.id.questionOneEditText);

        radioButtonQuestion2 = findViewById(R.id.question2answer);
        radioButtonQuestion3 = findViewById(R.id.question3answer);

        question4answer1 = findViewById(R.id.question4answer1);
        question4answer2 = findViewById(R.id.question4answer2);
        question4answer3 = findViewById(R.id.question4answer3);
        question4answer4 = findViewById(R.id.question4answer4);

        question5answer1 = findViewById(R.id.question5answer1);
        question5answer2 = findViewById(R.id.question5answer2);
        question5answer3 = findViewById(R.id.question5answer3);
        question5answer4 = findViewById(R.id.question5answer4);

        endButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int score = ScoreCheck();

                Intent submitIntent = new Intent(ExamActivity.this, ResultsActivity.class);
                submitIntent.putExtra("FINAL_SCORE", score);
                startActivity(submitIntent);
                finish();
            }
        });
    }

    private int ScoreCheck() {

        int points = 0;

        String question1 = editTextQuestion.getText().toString();

        if(question1.equals("200"))
        {
            points++;
        }
        if(radioButtonQuestion2.isChecked())
        {
            points++;
        }
        if(radioButtonQuestion3.isChecked())
        {
            points++;
        }
        if(question4answer1.isChecked() && question4answer3.isChecked() && question4answer4.isChecked() && !question4answer2.isChecked())
        {
            points++;
        }
        if(question5answer2.isChecked() && question5answer3.isChecked() && question5answer4.isChecked() && !question5answer1.isChecked())
        {
            points++;
        }

        return points;
    }

}

