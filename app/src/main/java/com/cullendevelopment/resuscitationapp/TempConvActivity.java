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

public class TempConvActivity extends AppCompatActivity {

    public float inputFahrenheit = 0;
    public float inputCentigrade = 0;
    public float centResult = 0;
    public float fahrenResult = 0;

    public static String FAHRENHEIT= "FAHRENHEIT";
    public static String CENTIGRADE= "CENTIGRADE";

    DecimalFormat dfCalcs = new DecimalFormat("###.#");

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_temp_conv);

        TextView centigradeTextView =  findViewById(R.id.centigrade_result);
        centigradeTextView .setText(dfCalcs.format(centResult));

        TextView fahrenheitTextView =  findViewById(R.id.fahrenheit_result);
        fahrenheitTextView.setText(dfCalcs.format(fahrenResult));


        ImageView F_to_C_conv = findViewById(R.id.F_to_C_conv);
        F_to_C_conv.setOnClickListener(this::from_fahrenheit_calculation);

        ImageView C_to_F_conv= findViewById(R.id.C_to_F_conv);
        C_to_F_conv.setOnClickListener(this::from_centigrade_calculation);

        ImageView menu_temp_conv= findViewById(R.id.menu_temp_conv);
        menu_temp_conv.setOnClickListener(this::menu_temp_conv);
    }

    //Use onSaveInstanceState(Bundle) and onRestoreInstanceState
    @Override
    public void onSaveInstanceState(@NonNull Bundle  outState) {
        super.onSaveInstanceState(outState);
        outState.putFloat(CENTIGRADE, centResult);

        outState.putFloat(FAHRENHEIT, fahrenResult);
    }

    //onRestoreInstanceState
    @Override
    public void onRestoreInstanceState(@NonNull Bundle  savedInstanceState) {

        super.onRestoreInstanceState(savedInstanceState);

        // Restore UI state from the savedInstanceState.
        // This bundle has also been passed to onCreate.

        centResult = savedInstanceState.getFloat(CENTIGRADE);
        centigradeDisplay(centResult);


        fahrenResult = savedInstanceState.getFloat(FAHRENHEIT);
        fahrenheitDisplay(fahrenResult);

    }

    /**
     * This method displays the given  calculated weight quantity value on the screen.
     */
    public void centigradeDisplay(float centResult) {
        TextView centigradeTextView =  findViewById(R.id.centigrade_result);
        centigradeTextView .setText(dfCalcs.format(centResult));

    }


    /**
     * This method displays the given uncuffed tube size on the screen.
     */
    public void fahrenheitDisplay(float fahrenResult) {
        TextView fahrenheitTextView =  findViewById(R.id.fahrenheit_result);
        fahrenheitTextView.setText(dfCalcs.format(fahrenResult));
    }
    public void from_fahrenheit_calculation(View view){
        EditText fahrenheitToCentigrade = findViewById(R.id.enter_fahrenheit);
        String fahrenheitToCentigradeValue = fahrenheitToCentigrade.getText().toString();
        inputFahrenheit = Float.parseFloat(fahrenheitToCentigradeValue);

        centResult = (((inputFahrenheit - 32) * 5) / 9);

        TextView centigradeTextView =  findViewById(R.id.centigrade_result);
        centigradeTextView .setText(dfCalcs.format(centResult));

    }

    public void from_centigrade_calculation(View view){

        EditText centigradeToFahrenheit = findViewById(R.id.enter_centigrade);
        String centigradeToFahrenheitValue = centigradeToFahrenheit.getText().toString();
        inputCentigrade = Float.parseFloat(centigradeToFahrenheitValue);

        fahrenResult = ((inputCentigrade * 9) / 5) + 32;

        TextView fahrenheitTextView =  findViewById(R.id.fahrenheit_result);
        fahrenheitTextView.setText(dfCalcs.format(fahrenResult));

    }

    public void menu_temp_conv(View view) {
        // Create a new intent to open the {@link Temperature scale converter to Menu}
        Intent temp_conv_menu_intent = new Intent(TempConvActivity.this, BackgroundActivity.class);

        // Start the new activity
        startActivity(temp_conv_menu_intent); // Temperature scale converter activity to Menu Activity
    }
}
