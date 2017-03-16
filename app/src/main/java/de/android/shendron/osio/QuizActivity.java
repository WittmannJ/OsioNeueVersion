package de.android.shendron.osio;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.graphics.PorterDuff;
import android.os.CountDownTimer;
import android.os.Handler;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;
import java.lang.Object;
import de.android.shendron.osio.R.id;
import org.w3c.dom.Text;

import static de.android.shendron.osio.R.id.activity_quiz;
import static de.android.shendron.osio.R.id.choice1;
import static de.android.shendron.osio.R.id.up;

public class QuizActivity extends AppCompatActivity {

    public final static String EXTRA_MESSAGE = "de.android.shendron.osio";

    private Fragenkatalog mFragenkataloge = new Fragenkatalog();

    private static int freeze = 2000;

    private TextView mScoreView;
    private TextView mQuestionView;
    private Button mButtonChoice1;
    private Button mButtonChoice2;
    private Button mButtonChoice3;
    private Button mQuit;


    private String mAnswer;
    private int mScore = 0;
    private  int mQuestionNumber = 0;

    TextView mCD;
    CountDownTimer timer1;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quiz);


       // mCountDown = (ProgressBar)findViewById(R.id.timer);
        //startTime(mCountDown);

        mScoreView = (TextView)findViewById(R.id.score);
        mQuestionView = (TextView)findViewById(R.id.question);
        mButtonChoice1 = (Button)findViewById(R.id.choice1);
        mButtonChoice2 = (Button)findViewById(R.id.choice2);
        mButtonChoice3 = (Button)findViewById(R.id.choice3);
        mQuit = (Button)findViewById(R.id.quit);


                 mCD = (TextView)findViewById(R.id.time);

           timer1 = new CountDownTimer(20000, 1000){

               public void onTick(long seconds){

                   mCD.setText("time: "+ seconds/1000);
               }

           public void onFinish(){
               mCD.setText("Zeit ist um!");
               updateQuestion();


           }

        };

        updateQuestion();



            mButtonChoice1.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                    if (mButtonChoice1.getText() == mAnswer) {
                        mScore = mScore + 1;
                        updateScore(mScore);
                        timer1.cancel();
                        updateQuestion();

                        Toast.makeText(QuizActivity.this, "richtig", Toast.LENGTH_SHORT).show();
                    } else {
                        Toast.makeText(QuizActivity.this, "falsch", Toast.LENGTH_SHORT).show();

                        timer1.cancel();
                        updateQuestion();



                    }
                }
            });
        mButtonChoice2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if(mButtonChoice2.getText() == mAnswer){
                    mScore = mScore + 1;
                    updateScore(mScore);
                    timer1.cancel();
                    updateQuestion();

                    Toast.makeText(QuizActivity.this, "richtig", Toast.LENGTH_SHORT).show();
                }else {
                    Toast.makeText(QuizActivity.this, "falsch", Toast.LENGTH_SHORT).show();
                    timer1.cancel();
                    updateQuestion();
                }
            }
        });

        mButtonChoice3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if(mButtonChoice3.getText() == mAnswer){
                    mScore = mScore + 1;
                    updateScore(mScore);
                    timer1.cancel();
                    updateQuestion();

                    Toast.makeText(QuizActivity.this, "richtig", Toast.LENGTH_SHORT).show();
                }else {
                    Toast.makeText(QuizActivity.this, "falsch", Toast.LENGTH_SHORT).show();
                    timer1.cancel();
                    updateQuestion();


                }
            }
        });
        mQuit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final Intent intent = new Intent(QuizActivity.this, HomeMenuActivity.class);
                startActivity(intent);
                finish();
            }
        });
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.main_menu, menu);
        return true;
    }


    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        switch (item.getItemId()){
            case R.id.stats:
                Intent intent1 = new Intent(this, Statisctics.class);
                this.startActivity(intent1);
                return true;
            case R.id.about:
                Intent intent2 = new Intent(this, About.class);
                this.startActivity(intent2);
                return true;
            default:
                return super.onOptionsItemSelected(item);

        }
    }



    private void updateQuestion () {
        if (mQuestionNumber <= 3) {
            mButtonChoice1.setBackgroundColor(0xFF0091EA);
            mButtonChoice2.setBackgroundColor(0xFF0091EA);
            mButtonChoice3.setBackgroundColor(0xFF0091EA);


            mQuestionView.setText(mFragenkataloge.getQuestion(mQuestionNumber));
            mButtonChoice1.setText(mFragenkataloge.getChoice1(mQuestionNumber));
            mButtonChoice2.setText(mFragenkataloge.getChoice2(mQuestionNumber));
            mButtonChoice3.setText(mFragenkataloge.getChoice3(mQuestionNumber));


            mAnswer = mFragenkataloge.getCorrectAnswer(mQuestionNumber);
            mQuestionNumber++;
            timer1.start();



        } else {

            Intent intent1 = new Intent(this, ScoreBoard.class);
            String message = ""+ mScore;
            intent1.putExtra(EXTRA_MESSAGE, message);
            startActivity(intent1);



            timer1.cancel();
            Toast.makeText(QuizActivity.this, "Keine Fragen mehr", Toast.LENGTH_SHORT).show();




            mButtonChoice1.setVisibility(View.INVISIBLE);
            mButtonChoice2.setVisibility(View.INVISIBLE);
            mButtonChoice3.setVisibility(View.INVISIBLE);

        }
    }

    public void updateScore(int point){

        mScoreView.setText("" + mScore);

    }

    public void showColorCorrect(Button btn){

        btn.setBackgroundColor(0x32CD32);
        updateQuestion();
        btn.setBackgroundColor(0xFF091EA);

    }

    public void showColorWrong(Button btn){

        btn.setBackgroundColor(0xFF00000);
        updateQuestion();
        btn.setBackgroundColor(0xFF0091EA);
    }
}
