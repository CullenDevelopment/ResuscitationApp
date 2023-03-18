package com.cullendevelopment.resuscitationapp;

import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

public class Fluids extends AppCompatActivity {


    public float minutes = 0;
    public float ml_per_min = 0;
    public float drops_min_crystalloid = 0;
    public float drops_min_colloid = 0;
    public float drops_min_microdrop = 0;

    int round_ml_per_min = 0;
    int round_drops_min_crystalloid = 0;
    int round_drops_min_colloid = 0;
    int round_drops_min_microdrop = 0;


    public static String ML_PER_MIN= "ML_PER_MIN";
    public static String DROPS_MIN_CRYSTALLOID= "DROPS_MIN_CRYSTALLOID";
    public static String DROPS_MIN_COLLOID = "DROP_MIN_COLLOID";
    public static String MINUTES = "MINUTES";
    public static String DROPS_MIN_MICRODROP = "DROPS_MIN+MICRODROP";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fluids);

        TextView mlMinDisplayTextView = findViewById(R.id.mls_min);
        mlMinDisplayTextView.setText(String.format(String.valueOf(round_ml_per_min), "%.f", round_ml_per_min));

        TextView dropsMinCrystalloidDisplayTextView = findViewById(R.id.crystalloid_drops_min);
        dropsMinCrystalloidDisplayTextView.setText(String.valueOf(round_drops_min_crystalloid));

        TextView dropsMinColloidDisplayTextView = findViewById(R.id.colloid_drops_min);
        dropsMinColloidDisplayTextView.setText(String.valueOf(round_drops_min_colloid));

        TextView minutesDisplayTextView = findViewById(R.id.mins);
        minutesDisplayTextView.setText(String.valueOf(minutes));

        TextView dropsMinMicrodropTextView = findViewById(R.id.microdrop_textview);
        dropsMinMicrodropTextView.setText(String.valueOf(round_drops_min_microdrop));

        //sets onClickListeners for Fluids activity
        ImageView convert_fluids = findViewById(R.id.convert_fluid_volume);
        convert_fluids.setOnClickListener(this::convert_fluids);

        ImageView calculate_fluids = findViewById(R.id.calculate_fluids);
        calculate_fluids.setOnClickListener(this::calculation_fluids);

        ImageView menu_fluids = findViewById(R.id.menu_fluids);
        menu_fluids.setOnClickListener(this::menu_fluids);

    }

    //Use onSaveInstanceState(Bundle) and onRestoreInstanceState
    @Override
    public void onSaveInstanceState(@NonNull Bundle  outState) {
        super.onSaveInstanceState(outState);
        outState.putFloat(ML_PER_MIN, ml_per_min);
        outState.putFloat(DROPS_MIN_CRYSTALLOID, drops_min_crystalloid);
        outState.putFloat(DROPS_MIN_COLLOID, drops_min_colloid);
        outState.putFloat(MINUTES, minutes);
        outState.putFloat(DROPS_MIN_MICRODROP, drops_min_microdrop);
    }

    //onRestoreInstanceState
    @Override
    public void onRestoreInstanceState(@NonNull Bundle  savedInstanceState) {

        super.onRestoreInstanceState(savedInstanceState);

        // Restore UI state from the savedInstanceState.
        // This bundle has also been passed to onCreate.



        ml_per_min = savedInstanceState.getFloat(ML_PER_MIN);
        mlMinDisplay(ml_per_min);

        drops_min_crystalloid = savedInstanceState.getFloat(DROPS_MIN_CRYSTALLOID);
        dropsMinCrystalloidDisplay(drops_min_crystalloid);


        drops_min_colloid = savedInstanceState.getFloat(DROPS_MIN_COLLOID);
        dropsMinColloidDisplay(drops_min_colloid);

        minutes = savedInstanceState.getFloat(MINUTES);
        minutesDisplay(minutes);

        drops_min_microdrop = savedInstanceState.getFloat(DROPS_MIN_MICRODROP);
        dropsMinMicrodropDisplay(drops_min_microdrop);

    }


    public void menu_fluids(View view) {
        // Create a new intent to open the {@link fluids calculations to Menu}
        Intent fluids_menu_intent = new Intent(Fluids.this, BackgroundActivity.class);

        // Start the new activity
        startActivity(fluids_menu_intent); // fluids calcs activity to Menu Activity
    }

    public void calculation_fluids(View view) {
        EditText initVolume = findViewById(R.id.init_volume);
        String initVolumeValue = initVolume.getText().toString();
        float initVolumeNum = Float.parseFloat(initVolumeValue);

        EditText timeMinutes =  findViewById(R.id.time_minutes);
        String timeMinutesValue = timeMinutes.getText().toString();
        float timeMinutesNum = Float.parseFloat(timeMinutesValue);


        ml_per_min = initVolumeNum / timeMinutesNum;
        drops_min_crystalloid = ml_per_min * 20;
        drops_min_colloid = ml_per_min * 15;
        drops_min_microdrop = ml_per_min * 60;

        int round_ml_per_min = Math.round(ml_per_min);
        int round_drops_min_crystalloid = Math.round(drops_min_crystalloid);
        int round_drops_min_colloid = Math.round(drops_min_colloid);
        int round_drops_min_microdrop = Math.round(drops_min_microdrop);



        TextView mlMinDisplayTextView = findViewById(R.id.mls_min);
        mlMinDisplayTextView.setText(String.valueOf(round_ml_per_min));

        TextView dropsMinCrystalloidDisplayTextView = findViewById(R.id.crystalloid_drops_min);
        dropsMinCrystalloidDisplayTextView.setText(String.valueOf(round_drops_min_crystalloid));

        TextView dropsMinColloidDisplayTextView = findViewById(R.id.colloid_drops_min);
        dropsMinColloidDisplayTextView.setText(String.valueOf(round_drops_min_colloid));

        TextView dropsMinMicrodropTextView = findViewById(R.id.microdrop_textview);
        dropsMinMicrodropTextView.setText(String.valueOf(round_drops_min_microdrop));

    }


    /**
     * This method displays the given  calculated weight quantity value on the screen.
     */
    public void mlMinDisplay(float ml_per_min) {
        TextView mlMinDisplayTextView = findViewById(R.id.mls_min);
        mlMinDisplayTextView.setText(String.valueOf(ml_per_min));
    }

    /**
     * This method displays the given cuffed tube size on the screen.
     */
    public void dropsMinCrystalloidDisplay(float drops_min_crystalloid) {
        TextView dropsMinCrystalloidDisplayTextView = findViewById(R.id.crystalloid_drops_min);
        dropsMinCrystalloidDisplayTextView.setText(String.valueOf(drops_min_crystalloid));

    }

    /**
     * This method displays the given energy amount in joules on the screen.
     */
    public void dropsMinColloidDisplay(float drops_min_colloid) {
        TextView dropsMinColloidDisplayTextView = findViewById(R.id.colloid_drops_min);
        dropsMinColloidDisplayTextView.setText(String.valueOf(drops_min_colloid));

    }
    /**
     * This method displays the  amount of minutes in an hour on the screen.
     */
    public void minutesDisplay(float minutes) {
        TextView minutesDisplayTextView = findViewById(R.id.mins);
        minutesDisplayTextView.setText(String.valueOf(minutes));

    }
    /**
     * This method displays the given energy amount in joules on the screen.
     */
    public void dropsMinMicrodropDisplay(float drops_min_microdrop) {
        TextView dropsMinMicrodropDisplayTextView = findViewById(R.id.microdrop_textview);
        dropsMinMicrodropDisplayTextView.setText(String.valueOf(drops_min_microdrop));

    }


    public void convert_fluids(View view) {
        EditText hours =  findViewById(R.id.hours);
        String hoursValue = hours.getText().toString();
        int hoursNum = Integer.parseInt(hoursValue);

        minutes = hoursNum * 60;

        int round_minutes = Math.round(minutes);

        TextView minutesDisplayTextView = findViewById(R.id.mins);
        minutesDisplayTextView.setText(String.valueOf(round_minutes));
    }
}
