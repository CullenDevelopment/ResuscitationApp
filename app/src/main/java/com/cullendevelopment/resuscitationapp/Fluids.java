package com.cullendevelopment.resuscitationapp;

import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class Fluids extends AppCompatActivity {


    public int minutes = 0;
    public float ml_per_min = 0;
    public float drops_min_crystalloid = 0;
    public float drops_min_colloid = 0;

    public static String ML_PER_MIN= "ML_PER_MIN";
    public static String DROPS_MIN_CRYSTALLOID= "DROPS_MIN_CRYSTALLOID";
    public static String DROPS_MIN_COLLOID = "DROP_MIN_COLLOID";
    public static String MINUTES = "MINUTES";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fluids);

        TextView mlMinDisplayTextView = findViewById(R.id.mls_min);
        mlMinDisplayTextView.setText(String.format(String.valueOf(ml_per_min), "%.2f", ml_per_min));

        TextView dropsMinCrystalloidDisplayTextView = findViewById(R.id.crystalloid_drops_min);
        dropsMinCrystalloidDisplayTextView.setText(String.format(String.valueOf(drops_min_crystalloid), "%.2f", drops_min_crystalloid));

        TextView dropsMinColloidDisplayTextView = findViewById(R.id.colloid_drops_min);
        dropsMinColloidDisplayTextView.setText(String.format(String.valueOf(drops_min_colloid), "%.2f", drops_min_colloid));

        TextView minutesDisplayTextView = findViewById(R.id.mins);
        minutesDisplayTextView.setText(String.format(String.valueOf(minutes), "%.2f", minutes));

    }

    //Use onSaveInstanceState(Bundle) and onRestoreInstanceState
    @Override
    public void onSaveInstanceState(@NonNull Bundle  outState) {
        super.onSaveInstanceState(outState);
        outState.putFloat(ML_PER_MIN, ml_per_min);
        outState.putFloat(DROPS_MIN_CRYSTALLOID, drops_min_crystalloid);
        outState.putFloat(DROPS_MIN_COLLOID, drops_min_colloid);
        outState.putFloat(MINUTES, minutes);
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

        minutes = savedInstanceState.getInt(MINUTES);
        minutesDisplay(minutes);

    }


    public void menu_button_fluids(View view) {
        // Create a new intent to open the {@link fluids calculations to Menu}
        Intent fluids_menu_intent = new Intent(Fluids.this, BackgroundActivity.class);

        // Start the new activity
        startActivity(fluids_menu_intent); // fluids calcs activity to Menu Activity
    }

    public void calculation_fluids(View view) {
        EditText initVolume = (EditText) findViewById(R.id.init_volume);
        String initVolumeValue = initVolume.getText().toString();
        float initVolumeNum = Float.parseFloat(initVolumeValue);

        EditText timeMinutes = (EditText) findViewById(R.id.time_minutes);
        String timeMinutesValue = timeMinutes.getText().toString();
        float timeMinutesNum = Float.parseFloat(timeMinutesValue);


        ml_per_min = initVolumeNum / timeMinutesNum;
        drops_min_crystalloid = ml_per_min * 20;
        drops_min_colloid = ml_per_min * 15;


        TextView mlMinDisplayTextView = findViewById(R.id.mls_min);
        mlMinDisplayTextView.setText(String.format(String.valueOf(ml_per_min), "%.2f", ml_per_min));

        TextView dropsMinCrystalloidDisplayTextView = findViewById(R.id.crystalloid_drops_min);
        dropsMinCrystalloidDisplayTextView.setText(String.format(String.valueOf(drops_min_crystalloid), "%.2f", drops_min_crystalloid));

        TextView dropsMinColloidDisplayTextView = findViewById(R.id.colloid_drops_min);
        dropsMinColloidDisplayTextView.setText(String.format(String.valueOf(drops_min_colloid), "%.2f", drops_min_colloid));

    }


    /**
     * This method displays the given  calculated weight quantity value on the screen.
     */
    public void mlMinDisplay(float ml_per_min) {
        TextView mlMinDisplayTextView = findViewById(R.id.mls_min);
        mlMinDisplayTextView.setText(String.format(String.valueOf(ml_per_min), "%.2f", ml_per_min));
    }

    /**
     * This method displays the given cuffed tube size on the screen.
     */
    public void dropsMinCrystalloidDisplay(float drops_min_crystalloid) {
        TextView dropsMinCrystalloidDisplayTextView = findViewById(R.id.crystalloid_drops_min);
        dropsMinCrystalloidDisplayTextView.setText(String.format(String.valueOf(drops_min_crystalloid), "%.2f", drops_min_crystalloid));

    }

    /**
     * This method displays the given energy amount in joules on the screen.
     */
    public void dropsMinColloidDisplay(float drops_min_colloid) {
        TextView dropsMinColloidDisplayTextView = findViewById(R.id.colloid_drops_min);
        dropsMinColloidDisplayTextView.setText(String.format(String.valueOf(drops_min_colloid), "%.2f", drops_min_colloid));

    }
    /**
     * This method displays the  amount of minutes in an hour on the screen.
     */
    public void minutesDisplay(float minutes) {
        TextView minutesDisplayTextView = findViewById(R.id.mins);
        minutesDisplayTextView.setText(String.format(String.valueOf(minutes), "%.2f", minutes));

    }


    public void convert(View view) {
        EditText hours = (EditText) findViewById(R.id.hours);
        String hoursValue = hours.getText().toString();
        int hoursNum = Integer.parseInt(hoursValue);

        minutes = hoursNum * 60;

        TextView minutesDisplayTextView = findViewById(R.id.mins);
        minutesDisplayTextView.setText(String.format(String.valueOf(minutes), "%.2f", minutes));
    }
}
