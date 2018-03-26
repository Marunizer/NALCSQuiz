package menu.noni.android.nalcsquiz;

import android.annotation.SuppressLint;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    LinearLayout checkBoxAnswer;
    LinearLayout buttonAnswer;
    LinearLayout radioAnswer;
    LinearLayout editTextAnswer;

    Button submitButton;
    TextView questionText;
    int answerCounter = 0;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void onBegin(View view) {
        setContentView(R.layout.activity_quiz);

        checkBoxAnswer = findViewById(R.id.checkLayout);
        checkBoxAnswer.setVisibility(View.GONE);
        buttonAnswer = findViewById(R.id.buttonLayout);
        buttonAnswer.setVisibility(View.GONE);
        radioAnswer = findViewById(R.id.radioLayout);
        radioAnswer.setVisibility(View.GONE);
        editTextAnswer = findViewById(R.id.editTextLayout);
        editTextAnswer.setVisibility(View.GONE);

        submitButton = findViewById(R.id.answerButton);
        submitButton.setVisibility(View.GONE);
        questionText = findViewById(R.id.questionText);

        firstQuestion();
    }

    @SuppressLint("SetTextI18n")
    private void firstQuestion()
    {
        questionText.setText("What was the first NA rivalry between teams?");
        buttonAnswer.setVisibility(View.VISIBLE);
        Button b1 = findViewById(R.id.button1);
        Button b2 = findViewById(R.id.button2);
        Button b3 = findViewById(R.id.button3);
        Button b4 = findViewById(R.id.button4);

        b1.setText("Cloud 9 VS Team Solo Mid");
        b2.setText("Team Curse VS Team Dignitas");
        b3.setText("Team Solo Mid VS Counter Logic Gaming");
        b4.setText("Team Liquid vs Finatic");

        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getApplicationContext(),"Sorry, wrong answer :(",Toast.LENGTH_SHORT).show();
                buttonAnswer.setVisibility(View.GONE);
                secondQuestion();
            }
        });
        b2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getApplicationContext(),"Sorry, wrong answer :(",Toast.LENGTH_SHORT).show();
                buttonAnswer.setVisibility(View.GONE);
                secondQuestion();
            }
        });
        b3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getApplicationContext(),"Correct ! :)",Toast.LENGTH_SHORT).show();
                buttonAnswer.setVisibility(View.GONE);
                answerCounter++;
                secondQuestion();
            }
        });
        b4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getApplicationContext(),"Sorry, wrong answer :(",Toast.LENGTH_SHORT).show();
                buttonAnswer.setVisibility(View.GONE);
                secondQuestion();
            }
        });
    }

    @SuppressLint("SetTextI18n")
    private void secondQuestion()
    {
        questionText.setText("Who is the one and only player TSM will never kick?");
        editTextAnswer.setVisibility(View.VISIBLE);

        final EditText editText = findViewById(R.id.editText);

        submitButton.setVisibility(View.VISIBLE);
        submitButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(editText.getText().toString().equals(""))
                {
                    Toast.makeText(getApplicationContext(),"Please type something in and try again",Toast.LENGTH_SHORT).show();
                }
                else if (editText.getText().toString().toLowerCase().equals("burger king")
                        || editText.getText().toString().toLowerCase().equals("bjergson"))
                {
                    Toast.makeText(getApplicationContext(),"Correct! (:",Toast.LENGTH_SHORT).show();
                    editTextAnswer.setVisibility(View.GONE);
                    answerCounter++;
                    thirdQuestion();
                }
                else
                {
                    Toast.makeText(getApplicationContext(),"Wrongeroni :(",Toast.LENGTH_SHORT).show();
                    editTextAnswer.setVisibility(View.GONE);
                    thirdQuestion();
                }
            }
        });
    }

    @SuppressLint("SetTextI18n")
    private void thirdQuestion()
    {
        questionText.setText("Which of these teams has won a season?");
        checkBoxAnswer.setVisibility(View.VISIBLE);

        final CheckBox ch1 = findViewById(R.id.check1);
        final CheckBox ch2 = findViewById(R.id.check2);
        final CheckBox ch3 = findViewById(R.id.check3);
        final CheckBox ch4 = findViewById(R.id.check4);

        ch1.setText("Team Solo Mid");
        ch2.setText("Team Vulcan");
        ch3.setText("Team Liquid");
        ch4.setText("Cloud 9");

        submitButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (ch1.isChecked() && !ch2.isChecked() && !ch3.isChecked() && ch4.isChecked())
                {
                    Toast.makeText(getApplicationContext(),"Correct! (:",Toast.LENGTH_SHORT).show();
                    answerCounter++;
                    checkBoxAnswer.setVisibility(View.GONE);
                    fourthQuestion();
                }
                else
                {
                    Toast.makeText(getApplicationContext(),"Sorry, wrong!! :(",Toast.LENGTH_SHORT).show();
                    checkBoxAnswer.setVisibility(View.GONE);
                    fourthQuestion();
                }
            }
        });
    }

    @SuppressLint("SetTextI18n")
    private void fourthQuestion()
    {
        questionText.setText("Who is by far the greatest player to ever bless the North American LCS");
        radioAnswer.setVisibility(View.VISIBLE);

        final RadioButton r1 = findViewById(R.id.radio1);
        final RadioButton r2 = findViewById(R.id.radio2);
        final RadioButton r3 = findViewById(R.id.radio3);
        final RadioButton r4 = findViewById(R.id.radio4);

        r1.setText("imaqtpie");
        r2.setText("Lustboy");
        r3.setText("WildTurtle");
        r4.setText("Huni");

        submitButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (r3.isChecked())
                {
                    Toast.makeText(getApplicationContext(),"Correct! (:",Toast.LENGTH_SHORT).show();
                    answerCounter++;
                    radioAnswer.setVisibility(View.GONE);
                    submitResults();
                }
                else
                {
                    Toast.makeText(getApplicationContext(),"Sorry, wrong!! (; - ;)",Toast.LENGTH_SHORT).show();
                    radioAnswer.setVisibility(View.GONE);
                    submitResults();
                }
            }
        });

    }

    private void submitResults()
    {
        setContentView(R.layout.activity_results);
        TextView tv = findViewById(R.id.score);

        tv.setText(String.format("%d out of 4 !", answerCounter));
    }
}
