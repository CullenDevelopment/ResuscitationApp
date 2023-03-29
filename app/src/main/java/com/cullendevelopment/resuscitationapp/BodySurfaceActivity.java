package com.cullendevelopment.resuscitationapp;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import java.text.DecimalFormat;


public class BodySurfaceActivity extends AppCompatActivity {

    public double bsaWeightNum = 0;
    public double bsaHeightNum = 0;
    public double bsaSquared = 0;
    public double bsa = 0;

    public static String BSA_WEIGHT_NUM = "BSA_WEIGHT_NUM";
    public static String BSA_HEIGHT_NUM = "BSA_HEIGHT_NUM";
    public static String BSA_SQUARED = "BSA_SQUARED";
    public static String BSA = "BSA";

    DecimalFormat df = new DecimalFormat("##.###");


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_body_surface);

        TextView bsaTextView = findViewById(R.id.bsa_textview);
        bsaTextView.setText(df.format(bsa));

        // set onClickListeners for BSA activity
        ImageView menu_bsa = findViewById(R.id.menu_bsa);
        menu_bsa.setOnClickListener(this::menu_bsa);

        ImageView convert_bsa = findViewById(R.id.convert_bsa);
        convert_bsa.setOnClickListener(this::convert_bsa);
    }

    //Use onSaveInstanceState(Bundle) and onRestoreInstanceState
    @Override
    public void onSaveInstanceState(@NonNull Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putDouble(BSA_WEIGHT_NUM, bsaWeightNum);
        outState.putDouble(BSA_HEIGHT_NUM, bsaHeightNum);
        outState.putDouble(BSA_SQUARED, bsaSquared);
        outState.putDouble(BSA, bsa);
    }

    //onRestoreInstanceState
    @Override
    public void onRestoreInstanceState(@NonNull Bundle  savedInstanceState) {

        super.onRestoreInstanceState(savedInstanceState);

        // Restore UI state from the savedInstanceState.
        // This bundle has also been passed to onCreate.

        bsa = savedInstanceState.getDouble(BSA);
        bsaDisplay(bsa);

    }


    public void convert_bsa (View view){
        EditText bsaWeight = findViewById(R.id.bsa_weight_kg);
        String bsaWeightValue = bsaWeight.getText().toString();
        bsaWeightNum = Double.parseDouble(bsaWeightValue);

        EditText bsaHeight = findViewById(R.id.bsa_height_cm);
        String bsaHeightValue = bsaHeight.getText().toString();
        bsaHeightNum = Double.parseDouble(bsaHeightValue);

        bsaSquared = (bsaWeightNum * bsaHeightNum) / 3600;

        bsa = Math.sqrt(bsaSquared);


        TextView bsaTextView = findViewById(R.id.bsa_textview);
        bsaTextView.setText(df.format(bsa));
    }

    /**
     * This method displays the given energy amount in joules on the screen.
     */
    public void bsaDisplay(double bsa) {
        TextView bsaTextView = findViewById(R.id.bsa_textview);
        bsaTextView.setText(df.format(bsa));
    }


    public void menu_bsa(View view) {
        // Create a new intent to open the {@link body surface area calculator to Menu}
        Intent bsa_menu_intent = new Intent(BodySurfaceActivity.this, BackgroundActivity.class);

        // Start the new activity
        startActivity(bsa_menu_intent); // body surface area calculator  activity to Menu Activity
    }
}