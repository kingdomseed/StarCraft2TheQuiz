package org.holtnet.officialimperialbusiness;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button beginButton = findViewById(R.id.begin_button);

        beginButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent beginIntent = new Intent(MainActivity.this, ExamActivity.class);
                startActivity(beginIntent);
            }
        });
    }


}
