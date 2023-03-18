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

public class PgcsActivity extends AppCompatActivity implements View.OnClickListener {


    //declaration of variables

    public int score = 0;

    RadioGroup eye_opening_group;
    RadioButton spontaneously;
    RadioButton to_speech;
    RadioButton to_pain;
    RadioButton no_response_eye_open;
    RadioGroup verbal_response_group;
    RadioButton orientated;
    RadioButton confused;
    RadioButton inappropriate_words;
    RadioButton incomprehensible_words;
    RadioButton no_response_verbal;
    RadioGroup motor_response_group;
    RadioButton obeys_commands;
    RadioButton localises_pain;
    RadioButton withdraws;
    RadioButton flexion;
    RadioButton extension;
    RadioButton no_response_pain;

    //storage for string value of score for saved instance
    public static String SCORE = "SCORE";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pgcs);

        eye_opening_group = findViewById(R.id.eye_opening_group);
        eye_opening_group.setOnClickListener(this);
        spontaneously = findViewById(R.id.spontaneously);
        spontaneously.setOnClickListener(this);
        to_speech = findViewById(R.id.to_speech);
        to_speech.setOnClickListener(this);
        to_pain = findViewById(R.id.to_pain);
        to_pain.setOnClickListener(this);
        no_response_eye_open = findViewById(R.id.no_response_eye_open);
        no_response_eye_open.setOnClickListener(this);

        verbal_response_group = findViewById(R.id.verbal_response_group);
        verbal_response_group.setOnClickListener(this);
        orientated = findViewById(R.id.orientated);
        orientated.setOnClickListener(this);
        confused = findViewById(R.id.confused);
        confused.setOnClickListener(this);
        inappropriate_words = findViewById(R.id.inappropriate_words);
        inappropriate_words.setOnClickListener(this);
        incomprehensible_words = findViewById(R.id.incomprehensible_words);
        incomprehensible_words.setOnClickListener(this);
        no_response_verbal = findViewById(R.id.no_response_verbal);
        no_response_verbal.setOnClickListener(this);

        motor_response_group = findViewById(R.id.motor_response_group);
        motor_response_group.setOnClickListener(this);
        obeys_commands = findViewById(R.id.obeys_commands);
        obeys_commands.setOnClickListener(this);
        localises_pain = findViewById(R.id.localises_pain);
        localises_pain.setOnClickListener(this);
        withdraws = findViewById(R.id.withdraws);
        withdraws.setOnClickListener(this);
        flexion = findViewById(R.id.flexion);
        flexion.setOnClickListener(this);
        extension = findViewById(R.id.extension);
        extension.setOnClickListener(this);
        no_response_pain = findViewById(R.id.no_response_pain);
        no_response_pain.setOnClickListener(this);

        ImageView menu_pgcs= findViewById(R.id.menu_pgcs);
        menu_pgcs.setOnClickListener(this::menu_pgcs);

        ImageView get_score = findViewById(R.id.reveal_score);
        get_score.setOnClickListener(this::get_score);
    }


    @Override
    public void onSaveInstanceState(@NonNull Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putInt(SCORE, score);
    }


    //saves  scores if screen rewritten
    @Override
    public void onRestoreInstanceState(Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);
        //restores UI from storeInstanceState

        score = savedInstanceState.getInt(SCORE);
        scoreDisplay(score);
    }

    public void scoreDisplay(int score) {
        TextView scoreTextView = findViewById(R.id.score_box);
        scoreTextView.setText(String.valueOf(score));
    }


    //scoreDisplay used to give onClick something to do - an effort to stop score being counted multi times
    @Override
    public void onClick(@NonNull View view) {
        //default method for onClick events

        boolean checked = ((RadioButton) view).isChecked();


        //check which radio button was checked

        if (view.getId() == R.id.spontaneously) {
            if (checked)
                scoreDisplay(score);
        }
        if (view.getId() == R.id.to_speech) {
            if (checked)

                scoreDisplay(score);

        }
        if (view.getId() == R.id.to_pain) {
            if (checked)

                scoreDisplay(score);
        }
        if (view.getId() == R.id.no_response_eye_open) {
            if (checked)

                scoreDisplay(score);
        }


        if (view.getId() == R.id.orientated) {
            if (checked)

                scoreDisplay(score);
        }

        if (view.getId() == R.id.confused) {
            if (checked)

                scoreDisplay(score);
        }

        if (view.getId() == R.id.inappropriate_words) {
            if (checked)

                scoreDisplay(score);
        }
        if (view.getId() == R.id.incomprehensible_words) {
            if (checked)

                scoreDisplay(score);
        }
        if (view.getId() == R.id.no_response_verbal) {
            if (checked)

                scoreDisplay(score);
        }

        if (view.getId() == R.id.obeys_commands) {
            if (checked)

                scoreDisplay(score);
        }

        if (view.getId() == R.id.localises_pain) {
            if (checked)

                scoreDisplay(score);
        }

        if (view.getId() == R.id.withdraws) {
            if (checked)

                scoreDisplay(score);
        }

        if (view.getId() == R.id.flexion) {
            if (checked)

                scoreDisplay(score);
        }

        if (view.getId() == R.id.extension) {
            if (checked)

                scoreDisplay(score);
        }

        if (view.getId() == R.id.no_response_pain) {
            if (checked)

                scoreDisplay(score);
        }


    }


    public void menu_pgcs (View view){
        Intent menu_pgcs_intent = new Intent(PgcsActivity.this, BackgroundActivity.class);
        // Start the new activity
        startActivity(menu_pgcs_intent); // Glasgow Coma scale calculator  activity to Menu Activity
    }

    //Actually adds the scores
    public void get_score (View view){
        // Eyes open to radio buttons
        if(spontaneously.isChecked()){
            score += 4;
        }
        if(to_speech.isChecked()){
            score += 3;
        }
        if(to_pain.isChecked()){
            score += 2;
        }
        if(no_response_eye_open.isChecked()){
            score += 1;
        }
        //verbal response radio buttons
        if(orientated.isChecked()){
            score += 5;
        }
        if(confused.isChecked()){
            score += 4;
        }
        if(inappropriate_words.isChecked()){
            score += 3;
        }
        if(incomprehensible_words.isChecked()){
            score += 2;
        }
        if(no_response_verbal.isChecked()){
            score += 1;
        }
        // motor response radio buttons
        if(obeys_commands.isChecked()){
            score += 6;
        }
        if(localises_pain.isChecked()){
            score += 5;
        }
        if(withdraws.isChecked()){
            score += 4;
        }
        if(flexion.isChecked()){
            score += 3;
        }
        if(extension.isChecked()){
            score += 2;
        }
        if(no_response_pain.isChecked()){
            score += 1;
        }
        scoreDisplay(score);

        score = 0;

    }
}

