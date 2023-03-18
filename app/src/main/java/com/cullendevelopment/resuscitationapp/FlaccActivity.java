package com.cullendevelopment.resuscitationapp;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;



public class FlaccActivity extends AppCompatActivity implements View.OnClickListener{


    public int score = 0;

    RadioGroup face_group;
    RadioButton no_expression;
    RadioButton grimace_frown;
    RadioButton jaw;

    RadioGroup legs_group;
    RadioButton normal;
    RadioButton uneasy;
    RadioButton kicking;

    RadioGroup activity_group;
    RadioButton lying_quietly;
    RadioButton squirming;
    RadioButton rigid;

    RadioGroup cry_group;
    RadioButton no_cry;
    RadioButton whimpers;
    RadioButton crying_steadily;

    RadioGroup consolability_group;
    RadioButton content;
    RadioButton distractible;
    RadioButton difficult_to_console;

    //storage for string value of score for saved instance
    public static String FLACC_SCORE = "FLACC_SCORE";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_flacc);


        face_group = findViewById(R.id.face_group);
        no_expression = findViewById(R.id.no_expression);
        no_expression.setOnClickListener(this);
        grimace_frown = findViewById(R.id.grimace_frown);
        grimace_frown.setOnClickListener(this);
        jaw = findViewById(R.id.clenched_jaw);
        jaw.setOnClickListener(this);

        activity_group = findViewById(R.id.activity_group);
        activity_group.setOnClickListener(this);
        lying_quietly = findViewById(R.id.lying_quietly);
        lying_quietly.setOnClickListener(this);
        squirming = findViewById(R.id.squirming);
        squirming.setOnClickListener(this);
        rigid = findViewById(R.id.rigid);
        rigid.setOnClickListener(this);

        legs_group = findViewById(R.id.legs_group);
        legs_group.setOnClickListener(this);
        normal = findViewById(R.id.normal_position);
        normal.setOnClickListener(this);
        uneasy = findViewById(R.id.uneasy);
        uneasy.setOnClickListener(this);
        kicking = findViewById(R.id.kicking);
        kicking.setOnClickListener(this);

        cry_group = findViewById(R.id.cry_group);
        cry_group.setOnClickListener(this);
        no_cry = findViewById(R.id.no_cry);
        no_cry.setOnClickListener(this);
        whimpers = findViewById(R.id.whimpers);
        whimpers.setOnClickListener(this);
        crying_steadily = findViewById(R.id.crying_steadily);
        crying_steadily.setOnClickListener(this);

        consolability_group = findViewById(R.id.consolability_group);
        consolability_group.setOnClickListener(this);
        content = findViewById(R.id.content);
        content.setOnClickListener(this);
        distractible = findViewById(R.id.distractible);
        distractible.setOnClickListener(this);
        difficult_to_console = findViewById(R.id.difficult_to_console);
        difficult_to_console.setOnClickListener(this);

        ImageView menu_flacc= findViewById(R.id.menu_flacc);
        menu_flacc.setOnClickListener(this::menu_flacc);

        ImageView get_score = findViewById(R.id.reveal_score);
        get_score.setOnClickListener(this::get_score);


    }

    @Override
    public void onSaveInstanceState(@NonNull Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putInt(FLACC_SCORE, score);
    }

    //saves  scores if screen rewritten
    @Override
    public void onRestoreInstanceState(Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);
        //restores UI from storeInstanceState

        score = savedInstanceState.getInt(FLACC_SCORE);
        scoreDisplay(score);
    }

    public void scoreDisplay(int score) {
        TextView scoreTextView = findViewById(R.id.score_box_flacc);
        scoreTextView.setText(String.valueOf(score));
    }

    //scoreDisplay used to give onClick something to do - an effort to stop score being counted multi times
    @Override
    public void onClick(@NonNull View view) {
        //default method for onClick events

        boolean checked = ((RadioButton) view).isChecked();


        //check which radio button was checked

        if (view.getId() == R.id.no_expression) {
            if (checked)
                scoreDisplay(score);
        }
        if (view.getId() == R.id.grimace_frown) {
            if (checked)

                scoreDisplay(score);

        }
        if (view.getId() == R.id.clenched_jaw) {
            if (checked)

                scoreDisplay(score);
        }
        if (view.getId() == R.id.normal_position) {
            if (checked)

                scoreDisplay(score);
        }


        if (view.getId() == R.id.uneasy) {
            if (checked)

                scoreDisplay(score);
        }

        if (view.getId() == R.id.kicking) {
            if (checked)

                scoreDisplay(score);
        }

        if (view.getId() == R.id.lying_quietly) {
            if (checked)

                scoreDisplay(score);
        }
        if (view.getId() == R.id.squirming) {
            if (checked)

                scoreDisplay(score);
        }
        if (view.getId() == R.id.rigid) {
            if (checked)

                scoreDisplay(score);
        }

        if (view.getId() == R.id.no_cry) {
            if (checked)

                scoreDisplay(score);
        }

        if (view.getId() == R.id.whimpers) {
            if (checked)

                scoreDisplay(score);
        }

        if (view.getId() == R.id.crying_steadily) {
            if (checked)

                scoreDisplay(score);
        }

        if (view.getId() == R.id.content) {
            if (checked)

                scoreDisplay(score);
        }

        if (view.getId() == R.id.distractible) {
            if (checked)

                scoreDisplay(score);
        }

        if (view.getId() == R.id.difficult_to_console) {
            if (checked)

                scoreDisplay(score);
        }


    }

    public void menu_flacc(View view) {
        // Create a new intent to open the {@link flacc calculator to Menu}
        Intent flacc_menu_intent = new Intent(FlaccActivity.this, BackgroundActivity.class);

        // Start the new activity
        startActivity(flacc_menu_intent); // flacc calculator  activity to Menu Activity
    }

    //Actually adds the scores
    public void get_score (View view){
        // face_group to radio buttons
        //no_expression not included because if checked it does not add to score
        if(grimace_frown.isChecked()){
            score += 1;
        }
        if(jaw.isChecked()){
            score += 2;
        }

        //legs_group radio buttons
        //normal position not included because if checked it does not add to score
        if(uneasy.isChecked()){
            score += 1;
        }
        if(kicking.isChecked()){
            score += 2;
        }
        //activity_group radio buttons
        //lying quietly not included because if checked it does not add to score
        if(squirming.isChecked()){
            score += 1;
        }
        if(rigid.isChecked()){
            score += 2;
        }
        // cry group radio buttons
        //no_cry not included because if checked it does not add to score
        if(whimpers.isChecked()){
            score += 1;
        }
        if(crying_steadily.isChecked()){
            score += 2;
        }
        //consolability group radio buttons checked
        //content not included because if checked it does not add to score
        if(distractible.isChecked()){
            score += 1;
        }
        if(difficult_to_console.isChecked()){
            score += 2;
        }
        scoreDisplay(score);

        score = 0;

    }
}
