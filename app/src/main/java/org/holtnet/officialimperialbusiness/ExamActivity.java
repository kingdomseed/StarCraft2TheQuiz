package org.holtnet.officialimperialbusiness;

import android.content.Intent;
import android.content.pm.ActivityInfo;
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

    CheckBox q11Answer1, q11Answer2, q11Wrong, q12Answer1, q12Answer2, q12Answer3, q13Answer1, q13Answer2,
            q13Answer3, q14Answer1, q14Answer2, q14Wrong, q11Destiny, q12Destiny, q13Destiny, q14Destiny;

    Button endButton;

    boolean q1, q2, q3, q4, q5, q6, q7, q8, q9, q10, q11, q12, q13, q14;
    boolean q1d, q2d, q3d, q4d, q5d, q6d, q7d, q8d, q9d, q10d,  destinyRadio, destiny11, destiny12, destiny13, destiny14;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
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
            case R.id.q1answer2:
            case R.id.q1answer3:
            case R.id.q1destiny:
                q1 = !checked;
                if(view.getId() == R.id.q1destiny)
                {
                    q1d = checked;
                }
                break;
            case R.id.q2answer:
                q2 = checked;
                break;
            case R.id.q2answer2:
            case R.id.q2answer3:
            case R.id.q2destiny:
                q2 = !checked;
                if(view.getId() == R.id.q2destiny)
                {
                    q2d = checked;
                }
                break;
            case R.id.q3answer:
                q3 = checked;
                break;
            case R.id.q3answer2:
            case R.id.q3answer3:
            case R.id.q3destiny:
                q3 = !checked;
                if(view.getId() == R.id.q3destiny)
                {
                    q3d = checked;
                }
                break;
            case R.id.q4answer:
                q4 = checked;
                break;
            case R.id.q4answer2:
            case R.id.q4answer3:
            case R.id.q4destiny:
                q5 = !checked;
                if(view.getId() == R.id.q4destiny)
                {
                    q4d = checked;
                }
                break;
            case R.id.q5answer:
                q6 = checked;
                break;
            case R.id.q5answer2:
            case R.id.q5answer3:
            case R.id.q5destiny:
                q6 = !checked;
                if(view.getId() == R.id.q5destiny)
                {
                    q5d = checked;
                }
                break;
            case R.id.q6answer:
                q6 = checked;
                break;
            case R.id.q6answer2:
            case R.id.q6answer3:
            case R.id.q6destiny:
                q6 = !checked;
                if(view.getId() == R.id.q6destiny)
                {
                    q6d = checked;
                }
                break;
            case R.id.q7answer:
                q7 = checked;
                break;
            case R.id.q7answer2:
            case R.id.q7answer3:
            case R.id.q7destiny:
                q7 = !checked;
                if(view.getId() == R.id.q7destiny)
                {
                    q7d = checked;
                }
                break;
            case R.id.q8answer:
                q8 = checked;
                break;
            case R.id.q8answer2:
            case R.id.q8answer3:
            case R.id.q8destiny:
                if(view.getId() == R.id.q8destiny)
                {
                    q8d = checked;
                }
                break;
            case R.id.q9answer:
                q9 = checked;
                break;
            case R.id.q9answer2:
            case R.id.q9answer3:
            case R.id.q9destiny:
                q9 = !checked;
                if(view.getId() == R.id.q9destiny)
                {
                    q9d = checked;
                }
                break;
            case R.id.q10answer:
                q10 = checked;
                break;
            case R.id.q10answer2:
            case R.id.q10answer3:
            case R.id.q10destiny:
                q10 = !checked;
                if(view.getId() == R.id.q10destiny)
                {
                    q10d = checked;
                }
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
                break;
            case R.id.q12a1:
            case R.id.q12a2:
            case R.id.q12a3:
            case R.id.q12destiny:
                q12 = q12Answer1.isChecked() && q12Answer2.isChecked() && q12Answer3.isChecked() && !q12Destiny.isChecked();
                break;
            case R.id.q13a1:
            case R.id.q13a2:
            case R.id.q13a3:
            case R.id.q13destiny:
                q13 = q13Answer1.isChecked() && q13Answer2.isChecked() && q13Answer3.isChecked() && !q13Destiny.isChecked();
                break;
            case R.id.q14a1:
            case R.id.q14a2:
            case R.id.q14aw1:
            case R.id.q14destiny:
                q14 = q14Answer1.isChecked() && q14Answer2.isChecked() && !q14Wrong.isChecked() && !q14Destiny.isChecked();
                break;
            default:
                break;
        }
    }

    private void DestinyChecker() {
        // Check if all values are set to Destiny and set the correct variables to true.
        if (q1d && q2d && q3d && q4d && q5d && q6d && q7d && q8d && q9d && q10d) {
            destinyRadio = true;
            Toast.makeText(this, "Destiny Radio: " + destinyRadio, Toast.LENGTH_SHORT).show();
        }

        // check the truth values of all checkboxes.
        boolean destinyCheckBoxes = q11Destiny.isChecked() && q12Destiny.isChecked() && q13Destiny.isChecked() && q14Destiny.isChecked();

        // q11 - q14 checkboxes are all false (therefore the boolean is true.)
        boolean q11CheckBoxes = !q11Answer1.isChecked() && !q11Answer2.isChecked() && !q11Wrong.isChecked();
        boolean q12CheckBoxes = !q12Answer1.isChecked() && !q12Answer2.isChecked() && !q12Answer3.isChecked();
        boolean q13CheckBoxes = !q13Answer1.isChecked() && !q13Answer2.isChecked() && !q13Answer3.isChecked();
        boolean q14CheckBoxes = !q14Answer1.isChecked() && !q14Answer2.isChecked() && !q14Wrong.isChecked();

        // determine that the checkboxes are as follows:
        // destinyCheckBoxes = true;
        // q11-14CheckBoxes = true;
        if (destinyCheckBoxes && q11CheckBoxes && q12CheckBoxes && q13CheckBoxes && q14CheckBoxes) {
            destiny11 = true;
            destiny12 = true;
            destiny13 = true;
            destiny14 = true;
            boolean tester = destiny11 && destiny12 && destiny13 && destiny14;
            Toast.makeText(this, "Truth values: " + tester, Toast.LENGTH_SHORT).show();
        }
    }

    public void chooseIntent() {

        DestinyChecker();
        boolean destinyTruthCheck = (destinyRadio && destiny11 && destiny12 && destiny13 && destiny14);

        Intent submitIntent;

        if (destinyTruthCheck) {
            submitIntent = new Intent(ExamActivity.this, DestinyActivity.class);
            startActivity(submitIntent);
        } else {
            submitIntent = new Intent(ExamActivity.this, ResultsActivity.class);
            startActivity(submitIntent);
        }
    }
}

