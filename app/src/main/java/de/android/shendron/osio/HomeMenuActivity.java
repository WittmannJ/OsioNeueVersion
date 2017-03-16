package de.android.shendron.osio;

import android.content.Intent;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class HomeMenuActivity extends AppCompatActivity {
    public Button mPlaybutton;
    public Button mStat;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home_menu);

        mPlaybutton = (Button)findViewById(R.id.playbtn);
        mStat = (Button)findViewById(R.id.optbtn);

        mStat.setOnClickListener(new View.OnClickListener(){


            @Override
            public void onClick(View v) {
                Intent statIntent = new Intent(HomeMenuActivity.this, Statisctics.class);
                startActivity(statIntent);

            }
        });


        mPlaybutton.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                        Intent homeIntent = new Intent(HomeMenuActivity.this, QuizActivity.class);
                        startActivity(homeIntent);

                    }
                });
    }
}
