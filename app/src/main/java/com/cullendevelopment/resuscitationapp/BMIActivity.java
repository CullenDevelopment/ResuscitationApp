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

public class BMIActivity extends AppCompatActivity {

    public float stonesNum = 0;
    public float poundsNum = 0;
    public float feetNum = 0;
    public float inchesNum = 0;
    public float weightKgNum = 0;
    public float heightMNum = 0;
    public float imperialPoundsBaseTen = 0;
    public float imperialInchesBaseTen =0;
    public float convertedKg = 0;
    public float convertedMetres = 0;
    public float kilogrammesBmi = 0;
    public float metresBmi = 0;
    public float bmi = 0;
    public float stonesTotal = 0;
    public float feetTotal = 0;


    public static String STONES_NUM = "STONES_NUM";
    public static String POUNDS_NUM = "POUNDS_NUM";
    public static String FEET_NUM = "FEET_NUM";
    public static String INCHES_NUM = "INCHES_NUM";
    public static String WEIGHT_KG_NUM = "WEIGHT_KG_NUM";
    public static String HEIGHT_M_NUM = "HEIGHT_M_NUM";
    public static String IMPERIAL_POUNDS_BASE_TEN = "IMPERIAL_POUNDS_BASE_TEN";
    public static String IMPERIAL_INCHES_BASE_TEN = "IMPERIAL_INCHES_BASE_TEN";
    public static String CONVERTED_KG = "CONVERTED_KG";
    public static String CONVERTED_METRES = "CONVERTED_METRES";
    public static String KILOGRAMMES_BMI = "KILOGRAMMES_BMI";
    public static String METRES_BMI = "METRES_BMI";
    public static String BMI = "BMI";

    DecimalFormat df = new DecimalFormat("##.##");




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bmi);

        TextView kgTextView =  findViewById(R.id.kg_textview);
        kgTextView.setText(df.format(convertedKg));

        TextView imperialMetresTextview =  findViewById(R.id.imperial_metres_textview);
        imperialMetresTextview.setText(df.format(convertedMetres));

        TextView bmiTextView =  findViewById(R.id.bmi_textview);
        bmiTextView.setText(df.format(bmi));

        //sets onClickListeners for BMIActivity
        ImageView convert_bmi = findViewById(R.id.convert_bmi);
        convert_bmi.setOnClickListener(this::convert_bmi);

        ImageView convert_weight = findViewById(R.id.convert_weight);
        convert_weight.setOnClickListener(this::convert_weight);

        ImageView convert_height = findViewById(R.id.convert_height);
        convert_height.setOnClickListener(this::convert_height);

        ImageView menu_bmi_main = findViewById(R.id.menu_bmi_main);
        menu_bmi_main.setOnClickListener(this::menu_bmi_main);



    }

    //Use onSaveInstanceState(Bundle) and onRestoreInstanceState
    @Override
    public void onSaveInstanceState(@NonNull Bundle  outState) {
        super.onSaveInstanceState(outState);
        outState.putFloat(STONES_NUM, stonesNum );
        outState.putFloat(POUNDS_NUM, poundsNum);
        outState.putFloat(FEET_NUM, feetNum);
        outState.putFloat(INCHES_NUM, inchesNum);
        outState.putFloat(WEIGHT_KG_NUM, weightKgNum);
        outState.putFloat(HEIGHT_M_NUM, heightMNum);
        outState.putFloat(IMPERIAL_POUNDS_BASE_TEN, imperialPoundsBaseTen);
        outState.putFloat(IMPERIAL_INCHES_BASE_TEN, imperialInchesBaseTen);
        outState.putFloat(CONVERTED_KG, convertedKg);
        outState.putFloat(CONVERTED_METRES, convertedMetres);
        outState.putFloat(KILOGRAMMES_BMI, kilogrammesBmi);
        outState.putFloat(METRES_BMI, metresBmi);
        outState.putFloat(BMI, bmi);

    }

    //onRestoreInstanceState
    @Override
    public void onRestoreInstanceState(@NonNull Bundle  savedInstanceState) {

        super.onRestoreInstanceState(savedInstanceState);

        // Restore UI state from the savedInstanceState.
        // This bundle has also been passed to onCreate.

        convertedKg = savedInstanceState.getFloat(CONVERTED_KG);
        convertedKgDisplay(convertedKg);

        convertedMetres = savedInstanceState.getFloat(CONVERTED_METRES);
        convertedMetresDisplay(convertedMetres);

        bmi = savedInstanceState.getFloat(BMI);
        bmiDisplay(bmi);

    }

    /**
     * This method displays the given uncuffed tube size on the screen.
     */
    public void convertedKgDisplay(float convertedKg) {
        TextView kgTextView =  findViewById(R.id.kg_textview);
        kgTextView.setText(df.format(convertedKg));
    }

    /**
     * This method displays the given cuffed tube size on the screen.
     */
    public void convertedMetresDisplay(float convertedMetres) {
        TextView imperialMetresTextview =  findViewById(R.id.imperial_metres_textview);
        imperialMetresTextview.setText(df.format(convertedMetres));
    }

    /**
     * This method displays the given energy amount in joules on the screen.
     */
    public void bmiDisplay(float bmi) {
        TextView bmiTextView =  findViewById(R.id.bmi_textview);
        bmiTextView.setText(df.format(bmi));
    }

    public void convert_weight(View view) {
        EditText stones =  findViewById(R.id.stones);
        String stonesValue = stones.getText().toString();
        float stonesNum = Float.parseFloat(stonesValue);

        EditText pounds =  findViewById(R.id.pounds);
        String poundsValue = pounds.getText().toString();
        float poundsNum = Float.parseFloat(poundsValue);

        imperialPoundsBaseTen = (poundsNum /14) * 10;
        stonesTotal = stonesNum + (imperialPoundsBaseTen / 10);

        convertedKg = (float) (stonesTotal * 6.35029);

        TextView kgTextView =  findViewById(R.id.kg_textview);
        kgTextView.setText(df.format(convertedKg));
    }

    public void convert_height(View view) {
        EditText feet =  findViewById(R.id.feet);
        String feetValue = feet.getText().toString();
        float feetNum = Float.parseFloat(feetValue);

        EditText inches =  findViewById(R.id.inches);
        String inchesValue = inches.getText().toString();
        float inchesNum = Float.parseFloat(inchesValue);

        imperialInchesBaseTen = (inchesNum / 12) * 10;
        feetTotal = feetNum + (imperialInchesBaseTen / 10);

        convertedMetres = (float) (feetTotal * 0.3048);

        TextView imperialMetresTextview =  findViewById(R.id.imperial_metres_textview);
        imperialMetresTextview.setText(df.format(convertedMetres));


    }
    public void convert_bmi(View view) {
        EditText weightKg =  findViewById(R.id.weight_kg);
        String weightKgValue = weightKg.getText().toString();
        float weightKgNum = Float.parseFloat(weightKgValue);

        EditText heightM = findViewById(R.id.height_m);
        String heightMValue = heightM.getText().toString();
        float heightMNum = Float.parseFloat(heightMValue);

        bmi = weightKgNum / (heightMNum * heightMNum);

        TextView bmiTextView =  findViewById(R.id.bmi_textview);
        bmiTextView.setText(df.format(bmi));
    }

    public void menu_bmi_main(View view) {
        // Create a new intent to open the {@link bmi calculator to Menu}
        Intent bmi_menu_intent = new Intent(BMIActivity.this, BackgroundActivity.class);

        // Start the new activity
        startActivity(bmi_menu_intent); // bmi calculator  activity to Menu Activity
    }
}

