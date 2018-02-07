package org.holtnet.officialimperialbusiness;

import android.content.Intent;
import android.provider.MediaStore;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Switch;
import android.widget.Toast;

public class ExamActivity extends AppCompatActivity {

    EditText userName;

    RadioButton q1Answer, q2Answer, q3Answer, q4Answer, q5Answer, q6Answer, q7Answer, q8Answer, q9Answer, q10Answer,
            q1Destiny, q2Destiny, q3Destiny, q4Destiny, q5Destiny, q6Destiny, q7Destiny, q8Destiny, q9Destiny, q10Destiny;

    CheckBox q11Answer1, q11Answer2, q11Wrong, q12Answer1, q12Answer2, q12Answer3, q13Answer1, q13Answer2,
            q13Answer3, q14Answer1, q14Answer2, q14Wrong, q11Destiny, q12Destiny, q13Destiny, q14Destiny;

    Button endButton;

    boolean q1, q2, q3, q4, q5, q6, q7, q8, q9, q10, q11, q12, q13, q14, destinyRadio, destiny11, destiny12, destiny13, destiny14;

    Intent submitIntent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_exam);

        // Get all relevant views for correct answers, EditText, and the Destiny answers
        userName = findViewById(R.id.EnterNameID);

        // Standard answer ids -- responses will take you to results activity.
        q1Answer = findViewById(R.id.q1answer);
        q2Answer = findViewById(R.id.q2answer);
        q3Answer = findViewById(R.id.q3answer);
        q4Answer = findViewById(R.id.q4answer);
        q5Answer = findViewById(R.id.q5answer);
        q6Answer = findViewById(R.id.q6answer);
        q7Answer = findViewById(R.id.q7answer);
        q8Answer = findViewById(R.id.q8answer);
        q9Answer = findViewById(R.id.q9answer);
        q10Answer = findViewById(R.id.q10answer);

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

        // Destiny response ids -- responses will tak you to destiny activity.
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
                submitIntent = new Intent(ExamActivity.this, ResultsActivity.class);
                DestinyChecker();
                changeIntent();
                startActivity(submitIntent);
            }
        });
    }

    public void onQuestionsRadioButtonClicked(View view) {
        //Verify if the correct radio button answer is checked. If it is, set the corresponding variable to true.
        // Otherwise set it to false.
        DestinyChecker();
        if (q1Answer.isChecked()) {
            q1 = true;
        }
        if (q2Answer.isChecked()) {
            q2 = true;
        }
        if (q3Answer.isChecked()) {
            q3 = true;
        }
        if (q4Answer.isChecked()) {
            q4 = true;
        }
        if (q5Answer.isChecked()) {
            q5 = true;
        }
        if (q6Answer.isChecked()) {
            q6 = true;
        }
        if (q7Answer.isChecked()) {
            q7 = true;
        }
        if (q8Answer.isChecked()) {
            q8 = true;
        }
        if (q9Answer.isChecked()) {
            q9 = true;
        }
        if (q10Answer.isChecked()) {
            q10 = true;
        }

    }

    public void onQuestionsCheckboxClicked(View view) {
        // Verify which checkboxes are checked and which are not, assigning a true or false value to the correct variable based on which question is being checked.
        DestinyChecker();
        if (q11Answer1.isChecked() && q11Answer2.isChecked() && !q11Wrong.isChecked() && !q11Destiny.isChecked()) {
            q11 = true;
        } else if (q11Wrong.isChecked() || q11Destiny.isChecked()) {
            q11 = false;
        } else if (q12Answer1.isChecked() && q12Answer2.isChecked() && q12Answer3.isChecked() && !q12Destiny.isChecked()) {
            q12 = true;
        } else if (q12Destiny.isChecked()) {
            q12 = false;
        } else if (q13Answer1.isChecked() && q13Answer2.isChecked() && q13Answer3.isChecked() && !q13Destiny.isChecked()) {
            q13 = true;
        } else if (q13Destiny.isChecked()) {
            q13 = false;
        } else if (q14Answer1.isChecked() && q14Answer2.isChecked() && !q14Wrong.isChecked() && !q11Destiny.isChecked()) {
            q14 = true;
        } else if (q14Wrong.isChecked() || q14Destiny.isChecked()) {
            q14 = false;
        }
    }

    private void DestinyChecker() {
        // Check if all values are set to Destiny and set the correct variables to true.
        if (q1Destiny.isChecked() && q2Destiny.isChecked() && q3Destiny.isChecked() && q4Destiny.isChecked() && q5Destiny.isChecked() &&
                q6Destiny.isChecked() && q7Destiny.isChecked() && q8Destiny.isChecked() && q9Destiny.isChecked() && q10Destiny.isChecked()) {
            destinyRadio = true;
            //Toast.makeText(this, "" + destinyRadio, Toast.LENGTH_SHORT).show();
        }
        if(q11Destiny.isChecked() && q12Destiny.isChecked() && q13Destiny.isChecked() && q14Destiny.isChecked())
        {
            destiny11 = true;
            destiny12 = true;
            destiny13 = true;
            destiny14 = true;
            Toast.makeText(this, "q11 - q14 are True", Toast.LENGTH_SHORT).show();
        }
    }

    public void changeIntent() {

        boolean showMeTheTruth = (destinyRadio && destiny11 && destiny12 && destiny13 && destiny14);
        Toast.makeText(this, "Show me: " + showMeTheTruth, Toast.LENGTH_SHORT).show();
        if (showMeTheTruth) {
            Toast.makeText(this, "Made it.", Toast.LENGTH_SHORT).show();
            endButton.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    submitIntent = new Intent(ExamActivity.this, DestinyActivity.class);
                    startActivity(submitIntent);
                }
            });
        }
    }
}

