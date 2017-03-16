package de.android.shendron.osio;

import android.content.Intent;
import android.support.v4.media.session.MediaSessionCompat;
import android.support.v4.widget.TextViewCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;


public class ScoreBoard extends AppCompatActivity {

    private TextView mScoreBoard;
    private Button menuButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_score_board);

        final Intent intent1 = getIntent();
        String message = intent1.getStringExtra(QuizActivity.EXTRA_MESSAGE);
        mScoreBoard = (TextView)findViewById(R.id.scoreboard);
        mScoreBoard.setText("Score:  " +message);



        menuButton = (Button)findViewById(R.id.mbtn);
        menuButton.setOnClickListener(new View.OnClickListener() {

            public void onClick(View v){
                Intent intent = new Intent(ScoreBoard.this, HomeMenuActivity.class);
                startActivity(intent);
                finish();
            }
        });



    }
}
