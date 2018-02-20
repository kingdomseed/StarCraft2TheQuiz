package org.holtnet.officialimperialbusiness;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Toast;

public class ExamActivity extends AppCompatActivity {

    private EditText userName;

    private RadioButton q1Destiny, q2Destiny, q3Destiny, q4Destiny, q5Destiny, q6Destiny, q7Destiny, q8Destiny, q9Destiny, q10Destiny;

    private CheckBox q11Answer1, q11Answer2, q11Wrong, q12Answer1, q12Answer2, q12Answer3, q13Answer1, q13Answer2,
            q13Answer3, q14Answer1, q14Answer2, q14Wrong, q11Destiny, q12Destiny, q13Destiny, q14Destiny;

    private Button endButton;

    private boolean q1, q2, q3, q4, q5, q6, q7, q8, q9, q10, q11, q12, q13, q14, destinyRadio, destiny11, destiny12, destiny13, destiny14, destinyEditText;

    private Intent submitIntent;

    private int radioScore = 0;
    private int checkboxScore = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_exam);

        // Get all relevant views for correct answers, EditText, and the Destiny answers
        userName = findViewById(R.id.EnterNameID);

        q11Answer1 = findViewById(R.id.q11a1);
        q11Answer2 = findViewById(R.id.q11a2);
        q11Wrong = findViewById(R.id.q11aw1);

        q12Answer1 = findViewById(R.id.q12a1);
        q12Answer2 = findViewById(R.id.q12a2);
        q12Answer3 = findViewById(R.id.q12a3);

        q13Answer1 = findViewById(R.id.q13a1);
        q13Answer2 = findViewById(R.id.q13a2);
        q13Answer3 = findViewById(R.id.q13a3);

        q14Answer1 = findViewById(R.id.q14a1);
        q14Answer2 = findViewById(R.id.q14a2);
        q14Wrong = findViewById(R.id.q14aw1);

        // Destiny response ids -- responses will take you to destiny activity.
        q1Destiny = findViewById(R.id.q1destiny);
        q2Destiny = findViewById(R.id.q2destiny);
        q3Destiny = findViewById(R.id.q3destiny);
        q4Destiny = findViewById(R.id.q4destiny);
        q5Destiny = findViewById(R.id.q5destiny);
        q6Destiny = findViewById(R.id.q6destiny);
        q7Destiny = findViewById(R.id.q7destiny);
        q8Destiny = findViewById(R.id.q8destiny);
        q9Destiny = findViewById(R.id.q9destiny);
        q10Destiny = findViewById(R.id.q10destiny);

        q11Destiny = findViewById(R.id.q11destiny);
        q12Destiny = findViewById(R.id.q12destiny);
        q13Destiny = findViewById(R.id.q13destiny);
        q14Destiny = findViewById(R.id.q14destiny);

        // Submit button
        endButton = findViewById(R.id.end_button);

        endButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                chooseIntent();
            }
        });
    }

    public void onQuestionsRadioButtonClicked(View view) {
        //Verify if the correct radio button answer is checked. If it is, set the corresponding variable to true.
        // Otherwise set it to false.

        boolean checked = ((RadioButton) view).isChecked();
        switch (view.getId()) {
            case R.id.q1answer:
                q1 = checked;
                break;
            case R.id.q2answer:
                q2 = checked;
                break;
            case R.id.q3answer:
                q3 = checked;
                break;
            case R.id.q4answer:
                q4 = checked;
                break;
            case R.id.q5answer:
                q5 = checked;
                break;
            case R.id.q6answer:
                q6 = checked;
                break;
            case R.id.q7answer:
                q7 = checked;
                break;
            case R.id.q8answer:
                q8 = checked;
                break;
            case R.id.q9answer:
                q9 = checked;
                break;
            case R.id.q10answer:
                q10 = checked;
                break;
            default:
                break;
        }
    }

    public void onQuestionsCheckboxClicked(View view) {
        // Verify which checkboxes are checked and which are not, assigning a true or false value to the correct variable based on which question is being checked.

        switch (view.getId()) {
            case R.id.q11a1:
            case R.id.q11a2:
            case R.id.q11aw1:
            case R.id.q11destiny:
                q11 = q11Answer1.isChecked() && q11Answer2.isChecked() && !q11Wrong.isChecked() && !q11Destiny.isChecked();
            case R.id.q12a1:
            case R.id.q12a2:
            case R.id.q12a3:
            case R.id.q12destiny:
                q12 = q12Answer1.isChecked() && q12Answer2.isChecked() && q12Answer3.isChecked() && !q12Destiny.isChecked();
            case R.id.q13a1:
            case R.id.q13a2:
            case R.id.q13a3:
            case R.id.q13destiny:
                q13 = q13Answer1.isChecked() && q13Answer2.isChecked() && q13Answer3.isChecked() && !q13Destiny.isChecked();
            case R.id.q14a1:
            case R.id.q14a2:
            case R.id.q14aw1:
            case R.id.q14destiny:
                q14 = q14Answer1.isChecked() && q14Answer2.isChecked() && !q14Wrong.isChecked() && !q14Destiny.isChecked();
            default:
                break;
        }
    }

    private void DestinyChecker() {

        // Check if all values are set to Destiny and set the correct variables to true.
        if (q1Destiny.isChecked() && q2Destiny.isChecked() && q3Destiny.isChecked() && q4Destiny.isChecked() && q5Destiny.isChecked() &&
                q6Destiny.isChecked() && q7Destiny.isChecked() && q8Destiny.isChecked() && q9Destiny.isChecked() && q10Destiny.isChecked()) {
            destinyRadio = true;
        }

        if (q11Destiny.isChecked() && q12Destiny.isChecked() && q13Destiny.isChecked() && q14Destiny.isChecked()) {
            destiny11 = true;
            destiny12 = true;
            destiny13 = true;
            destiny14 = true;

            // Check if the EditText has the word "Destiny"

            String lowerCaseUserName = userName.getText().toString();
            if (lowerCaseUserName.toLowerCase().equals("destiny")) {
                destinyEditText = true;
            }
        }
    }

    private int ScoreCheck() {

        //Check appropriate variables and score the exam just before passing it to the next activity.
        if (q1) {
            radioScore++;
        }
        if (q2) {
            radioScore++;
        }
        if (q3) {
            radioScore++;
        }
        if (q4) {
            radioScore++;
        }
        if (q5) {
            radioScore++;
        }
        if (q6) {
            radioScore++;
        }
        if (q7) {
            radioScore++;
        }
        if (q8) {
            radioScore++;
        }
        if (q9) {
            radioScore++;
        }
        if (q10) {
            radioScore++;
        }
        if (q11) {
            checkboxScore++;
        }
        if (q12) {
            checkboxScore++;
        }
        if (q13) {
            checkboxScore++;
        }
        if (q14) {
            checkboxScore++;
        }

        return checkboxScore + radioScore;

    }

    public void chooseIntent() {

        DestinyChecker();
        int score = ScoreCheck();
        boolean destinyTruthCheck = (destinyRadio && destiny11 && destiny12 && destiny13 && destiny14 && destinyEditText);

        if (destinyTruthCheck) {
            submitIntent = new Intent(ExamActivity.this, DestinyActivity.class);
            startActivity(submitIntent);
        } else {
            submitIntent = new Intent(ExamActivity.this, ResultsActivity.class);
            submitIntent.putExtra("FINAL_SCORE", score);
            startActivity(submitIntent);
        }
    }
}

