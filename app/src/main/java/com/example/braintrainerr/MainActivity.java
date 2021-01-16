package com.example.braintrainerr;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.os.CountDownTimer;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Random;

public class MainActivity extends AppCompatActivity {

    Button startbutton;
    ArrayList<Integer> answers = new ArrayList<Integer>();
    int locationofcorrectanswer;
    int wronganswer;
    int score = 0;
    TextView ResultTextView;
    int NumberOfQuestions;
    TextView ScoreTextView;
    Button button0;
    Button button1;
    Button button2;
    Button button3;
    TextView sumTextView;
    TextView TimerTextView;
    Button PlayAgainButton;


    public void PlayAgain(final View view) {

        score = 0;
        NumberOfQuestions = 0;

        ScoreTextView.setText("0/0");
        TimerTextView.setText("30");
        ResultTextView.setText("");
        PlayAgainButton.setVisibility(view.INVISIBLE);
        generatequestion();
        button0.setVisibility(view.VISIBLE);
        button1.setVisibility(view.VISIBLE);
        button2.setVisibility(view.VISIBLE);
        button3.setVisibility(view.VISIBLE);
        sumTextView.setVisibility(view.VISIBLE);


        new CountDownTimer(30100, 1000) {


            @Override
            public void onTick(long millisUntilFinished) {

                TimerTextView.setText(String.valueOf(millisUntilFinished / 1000));


            }

            @Override
            public void onFinish() {
                PlayAgainButton.setVisibility(view.VISIBLE);
                TimerTextView.setText("0");
                ResultTextView.setText("Your score: " + Integer.toString(score) + "/" + Integer.toString(NumberOfQuestions));
                button0.setVisibility(view.INVISIBLE);
                button1.setVisibility(view.INVISIBLE);
                button2.setVisibility(view.INVISIBLE);
                button3.setVisibility(view.INVISIBLE);
                sumTextView.setVisibility(view.INVISIBLE);
            }

        }.start();
    }


    public void generatequestion() {

        Random rand = new Random();

        int a = rand.nextInt(21);
        int b = rand.nextInt(21);

        sumTextView.setText(Integer.toString(a) + "+" + Integer.toString(b));

        locationofcorrectanswer = rand.nextInt(4);

        answers.clear();

        for (int i = 0; i < 4; i++) {

            if (i == locationofcorrectanswer) {
                answers.add(a + b);
            } else {
                wronganswer = rand.nextInt(41);

                while (wronganswer == (a + b)) {
                    wronganswer = rand.nextInt(41);
                }
                answers.add(wronganswer);
            }

        }

        button0.setText(Integer.toString(answers.get(0)));
        button1.setText(Integer.toString(answers.get(1)));
        button2.setText(Integer.toString(answers.get(2)));
        button3.setText(Integer.toString(answers.get(3)));

    }


    public void chooseanswer(View view) {

        if (view.getTag().toString().equals(Integer.toString(locationofcorrectanswer))) {


            score++;
            ResultTextView.setText("CORRECT");
        } else {
            ResultTextView.setText("WRONG!");
        }

        NumberOfQuestions++;
        ScoreTextView.setText(Integer.toString(score) + "/" + Integer.toString(NumberOfQuestions));
        generatequestion();
    }

    public void Start(View view) {

        startbutton.setVisibility(view.INVISIBLE);
        TimerTextView.setVisibility(view.VISIBLE);
        ScoreTextView.setVisibility(view.VISIBLE);
        sumTextView.setVisibility(view.VISIBLE);
        PlayAgainButton.setVisibility(view.VISIBLE);
        ResultTextView.setVisibility(view.VISIBLE);
        button0.setVisibility(view.VISIBLE);
        button1.setVisibility(view.VISIBLE);
        button2.setVisibility(view.VISIBLE);
        button3.setVisibility(view.VISIBLE);


        PlayAgain(findViewById(R.id.PlayAgainButton));
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        startbutton = findViewById(R.id.StartButton);
        sumTextView = findViewById(R.id.SumTextView);
        button0 = findViewById(R.id.button0);
        button1 = findViewById(R.id.button1);
        button2 = findViewById(R.id.button2);
        button3 = findViewById(R.id.button3);
        ResultTextView = findViewById(R.id.ResultTextView);
        ScoreTextView = findViewById(R.id.ScoreTextView);
        TimerTextView = findViewById(R.id.TimerTextView);
        PlayAgainButton = findViewById(R.id.PlayAgainButton);




    }
}
