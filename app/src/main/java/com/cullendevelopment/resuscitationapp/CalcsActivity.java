package com.cullendevelopment.resuscitationapp;

import android.content.Intent;
import android.os.Bundle;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;


public class CalcsActivity  extends AppCompatActivity {

    public float ageYearsNum = 0;
    public float weight = 0;
    public float uncuffedTube = 0;
    public float cuffedTube = 0;
    public float joules = 0;
    public float fluid = 0;
    public float adrenaline = 0;
    public float amiodarone = 0;
    public float glucose = 0;


    public static String WEIGHT = "WEIGHT";
    public static String UNCUFFED_TUBE= "UNCUFFED_TUBE";
    public static String CUFFED_TUBE= "CUFFED_TUBE";
    public static String JOULES = "JOULES";
    public static String FLUID = "FLUID";
    public static String ADRENALINE = "ADRENALINE";
    public static String AMIODARONE = "AMIODARONE";
    public static String GLUCOSE = "GLUCOSE";





    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calcs);

        TextView weightTextView =  findViewById(R.id.weight_calc);
        weightTextView.setText(String.format(String.valueOf(weight), "%.2f", weight));

        TextView uncuffedTubeTextView =  findViewById(R.id.tube_uncuffed_text);
        uncuffedTubeTextView.setText(String.format(String.valueOf(uncuffedTube), "%.2f", uncuffedTube));

        TextView cuffedTubeTextView =  findViewById(R.id.tube_cuffed_text);
        cuffedTubeTextView.setText(String.format(String.valueOf(cuffedTube), "%.2f", cuffedTube));

        TextView energyTextView =  findViewById(R.id.energy_text);
        energyTextView.setText(String.format(String.valueOf(joules), "%.2f", joules));

        TextView crystalloidTextView = findViewById(R.id.crystalloid_text);
        crystalloidTextView.setText(String.format(String.valueOf(fluid), "%.2f", fluid));

        TextView adrenalineTextView =  findViewById(R.id.adrenaline_text);
        adrenalineTextView.setText(String.format(String.valueOf(adrenaline), "%.2f", adrenaline));

        TextView amiodaroneTextView =  findViewById(R.id.amiodarone_text);
        amiodaroneTextView.setText(String.format(String.valueOf(amiodarone), "%.2f", amiodarone));

        TextView glucoseTextView = findViewById(R.id.glucose_text);
        glucoseTextView.setText(String.format(String.valueOf(glucose), "%.2f", glucose));


    }

    //Use onSaveInstanceState(Bundle) and onRestoreInstanceState
    @Override
    public void onSaveInstanceState(@NonNull Bundle  outState) {
        super.onSaveInstanceState(outState);
        outState.putFloat(WEIGHT, weight);
        outState.putFloat(UNCUFFED_TUBE, uncuffedTube);
        outState.putFloat(CUFFED_TUBE, cuffedTube);
        outState.putFloat(JOULES, joules);
        outState.putFloat(FLUID, fluid);
        outState.putFloat(ADRENALINE, adrenaline);
        outState.putFloat(AMIODARONE, amiodarone);
        outState.putFloat(GLUCOSE, glucose);

    }

    //onRestoreInstanceState
    @Override
    public void onRestoreInstanceState(@NonNull Bundle  savedInstanceState) {

        super.onRestoreInstanceState(savedInstanceState);

        // Restore UI state from the savedInstanceState.
        // This bundle has also been passed to onCreate.

        weight = savedInstanceState.getFloat(WEIGHT);
        weightDisplay(weight);


        uncuffedTube = savedInstanceState.getFloat(UNCUFFED_TUBE);
        uncuffedDisplay(uncuffedTube);

        cuffedTube = savedInstanceState.getFloat(CUFFED_TUBE);
        cuffedDisplay(cuffedTube);


        joules = savedInstanceState.getFloat(JOULES);
        joulesDisplay(joules);

        fluid = savedInstanceState.getFloat(FLUID);
        fluidDisplay(fluid);

        adrenaline = savedInstanceState.getFloat(ADRENALINE);
        adrenalineDisplay(adrenaline);

        amiodarone = savedInstanceState.getFloat(AMIODARONE);
        amiodaroneDisplay(amiodarone);

        glucose = savedInstanceState.getFloat(GLUCOSE);
        glucoseDisplay(glucose);

    }


    public void menu_button_calcs(View view) {
        // Create a new intent to open the {@link paed resus calculations to Menu}
        Intent calcs_menu_intent = new Intent(CalcsActivity.this, BackgroundActivity.class);

        // Start the new activity
        startActivity(calcs_menu_intent); // Paed Resus calcs activity to Menu Activity
    }

    public void calculation_paed(View view) {
        EditText ageYears = (EditText) findViewById(R.id.age_box_years);
        String ageYearsValue = ageYears.getText().toString();
        ageYearsNum = Float.parseFloat(ageYearsValue);

        weight = (ageYearsNum +4)*2;
        uncuffedTube = (ageYearsNum /4) + 4;
        cuffedTube = (float) ((ageYearsNum / 4) + 3.5);
        joules = weight * 4;
        fluid = weight * 20;
        adrenaline = weight * 10;
        amiodarone = weight * 5;
        glucose = weight * 5;



        TextView weightDisplayTextView = findViewById(R.id.weight_calc);
        weightDisplayTextView.setText(String.format(String.valueOf(weight), "%.2f", weight));

        TextView uncuffedDisplayTextView = findViewById(R.id.tube_uncuffed_text);
        uncuffedDisplayTextView.setText(String.format(String.valueOf(uncuffedTube), "%.2f", uncuffedTube));

        TextView cuffedDisplayTextView = findViewById(R.id.tube_cuffed_text);
        cuffedDisplayTextView.setText(String.format(String.valueOf(cuffedTube), "%.2f", cuffedTube));

        TextView joulesDisplayTextView = findViewById(R.id.energy_text);
        joulesDisplayTextView.setText(String.format(String.valueOf(joules), "%.2f", joules));

        TextView fluidDisplayTextView = findViewById(R.id.crystalloid_text);
        fluidDisplayTextView.setText(String.format(String.valueOf(fluid), "%.2f", fluid));

        TextView adrenalineDisplayTextView = findViewById(R.id.adrenaline_text);
        adrenalineDisplayTextView.setText(String.format(String.valueOf(adrenaline), "%.2f", adrenaline));

        TextView amiodaroneDisplayTextView = findViewById(R.id.amiodarone_text);
        amiodaroneDisplayTextView.setText(String.format(String.valueOf(amiodarone), "%.2f", amiodarone));

        TextView glucoseDisplayTextView = findViewById(R.id.glucose_text);
        glucoseDisplayTextView.setText(String.format(String.valueOf(glucose), "%.2f", glucose));


    }




    /**
     * This method displays the given  calculated weight quantity value on the screen.
     */
    public void weightDisplay(double weight) {
        TextView weightDisplayTextView = findViewById(R.id.weight_calc);
        weightDisplayTextView.setText(String.valueOf(weight));
    }


    /**
     * This method displays the given uncuffed tube size on the screen.
     */
    public void uncuffedDisplay(float uncuffedTube) {
        TextView uncuffedDisplayTextView = findViewById(R.id.tube_uncuffed_text);
        uncuffedDisplayTextView.setText(String.valueOf(uncuffedTube));
    }

    /**
     * This method displays the given cuffed tube size on the screen.
     */
    public void cuffedDisplay(float cuffedTube) {
        TextView cuffedDisplayTextView = findViewById(R.id.tube_cuffed_text);
        cuffedDisplayTextView.setText(String.valueOf(cuffedTube));
    }

    /**
     * This method displays the given energy amount in joules on the screen.
     */
    public void joulesDisplay(float joules) {
        TextView joulesDisplayTextView = findViewById(R.id.energy_text);
        joulesDisplayTextView.setText(String.valueOf(joules));
    }
    /**
     * This method displays the given crystalloid fluid amount on the screen.
     */
    public void fluidDisplay(float fluid) {
        TextView fluidDisplayTextView = findViewById(R.id.crystalloid_text);
        fluidDisplayTextView.setText(String.valueOf(fluid));
    }
    /**
     * This method displays the given adrenaline dose on the screen.
     */
    public void adrenalineDisplay(float adrenaline) {
        TextView adrenalineDisplayTextView = findViewById(R.id.adrenaline_text);
        adrenalineDisplayTextView.setText(String.valueOf(adrenaline));
    }
    /**
     * This method displays the given amiodarone dose on the screen.
     */
    public void amiodaroneDisplay(float amiodarone) {
        TextView amiodaroneDisplayTextView = findViewById(R.id.amiodarone_text);
        amiodaroneDisplayTextView.setText(String.valueOf(amiodarone));
    }
    /**
     * This method displays the given amiodarone dose on the screen.
     */
    public void glucoseDisplay(float glucose) {
        TextView glucoseDisplayTextView = findViewById(R.id.glucose_text);
        glucoseDisplayTextView.setText(String.valueOf(glucose));
    }


}
