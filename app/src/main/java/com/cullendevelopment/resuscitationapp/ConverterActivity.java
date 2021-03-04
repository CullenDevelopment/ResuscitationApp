package com.cullendevelopment.resuscitationapp;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

public class ConverterActivity extends AppCompatActivity {

    public float largeToSmallNum = 0;
    public float smallerUnits = 0;
    public float largerUnits = 0;
    public float smallToLargeNum = 0;
    public float smallerFluidUnits = 0;
    public float largeToSmallFluidsNum = 0;
    public float smallToLargeFluidsNum = 0;
    public float largerFluidUnits = 0;

    public static String LARGE_TO_SMALL_NUM = "LARGE_TO_SMALL_NUM";
    public static String SMALLER_UNITS= "SMALLER_UNITS";
    public static String LARGER_UNITS= "LARGER_UNITS";
    public static String SMALL_TO_LARGE_NUM = "SMALL_TO_LARGE_NUM";
    public static String SMALLER_FLUID_UNITS = "SMALLER_FLUID_UNITS";
    public static String LARGE_TO_SMALL_FLUIDS_NUM = "LARGE_TO_SMALL_FLUIDS_NUM";
    public static String SMALL_TO_LARGE_FLUIDS_NUM = "SMALL_TO_LARGE_FLUIDS_NUM";
    public static String LARGER_FLUID_UNITS = "LARGER_FLUID_UNITS";



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_converter);

        TextView largeUnitResultTextView =  findViewById(R.id.large_unit_result_textview);
        largeUnitResultTextView.setText(String.format(String.valueOf(smallerUnits), "%.2f", smallerUnits));

        TextView smallResultTextView =  findViewById(R.id.small_result_textview);
        smallResultTextView.setText(String.format(String.valueOf(largerUnits), "%.2f", largerUnits));

        TextView largeUnitFluidTextView =  findViewById(R.id.large_unit_fluid_textview);
        largeUnitFluidTextView.setText(String.format(String.valueOf(smallerFluidUnits), "%.2f", smallerFluidUnits));

        TextView smallUnitFluidTextView =  findViewById(R.id.small_fluid_result_textview);
        smallUnitFluidTextView.setText(String.format(String.valueOf(largerFluidUnits), "%.2f", largerFluidUnits));

    }

    //Use onSaveInstanceState(Bundle) and onRestoreInstanceState
    @Override
    public void onSaveInstanceState(@NonNull Bundle  outState) {
        super.onSaveInstanceState(outState);
        outState.putFloat(LARGE_TO_SMALL_NUM, largeToSmallNum);
        outState.putFloat(SMALLER_UNITS, smallerUnits);
        outState.putFloat(LARGER_UNITS, largerUnits);
        outState.putFloat(SMALL_TO_LARGE_NUM, smallToLargeNum);
        outState.putFloat(SMALLER_FLUID_UNITS, smallerFluidUnits);
        outState.putFloat(LARGE_TO_SMALL_FLUIDS_NUM, largeToSmallFluidsNum);
        outState.putFloat(SMALL_TO_LARGE_FLUIDS_NUM, smallToLargeFluidsNum);
        outState.putFloat(LARGER_FLUID_UNITS, largerFluidUnits);

    }

    //onRestoreInstanceState
    @Override
    public void onRestoreInstanceState(@NonNull Bundle  savedInstanceState) {

        super.onRestoreInstanceState(savedInstanceState);

        // Restore UI state from the savedInstanceState.
        // This bundle has also been passed to onCreate.


        smallerUnits = savedInstanceState.getFloat(SMALLER_UNITS);
        smallerUnitsDisplay(smallerUnits);

        largerUnits = savedInstanceState.getFloat(LARGER_UNITS);
        largerUnitsDisplay(largerUnits);

        smallerFluidUnits = savedInstanceState.getFloat(SMALLER_FLUID_UNITS);
        smallerFluidUnitsDisplay(smallerFluidUnits);

        largerFluidUnits = savedInstanceState.getFloat(LARGER_FLUID_UNITS);
        largerFluidUnitsDisplay(largerFluidUnits);

    }

    /**
     * This method displays the given uncuffed tube size on the screen.
     */
    public void smallerUnitsDisplay(float smallerUnits) {
        TextView largeUnitResultTextView =  findViewById(R.id.large_unit_result_textview);
        largeUnitResultTextView.setText(String.format(String.valueOf(smallerUnits), "%.2f", smallerUnits));
    }

    /**
     * This method displays the given cuffed tube size on the screen.
     */
    public void largerUnitsDisplay(float largerUnits) {
        TextView smallResultTextView =  findViewById(R.id.small_result_textview);
        smallResultTextView.setText(String.format(String.valueOf(largerUnits), "%.2f", largerUnits));
    }

    /**
     * This method displays the given energy amount in joules on the screen.
     */
    public void smallerFluidUnitsDisplay(float smallerFluidUnits) {
        TextView largeUnitFluidTextView =  findViewById(R.id.large_unit_fluid_textview);
        largeUnitFluidTextView.setText(String.format(String.valueOf(smallerFluidUnits), "%.2f", smallerFluidUnits));
    }
    /**
     * This method displays the given crystalloid fluid amount on the screen.
     */
    public void largerFluidUnitsDisplay(float largerFluidUnits) {
        TextView smallUnitFluidTextView =  findViewById(R.id.small_fluid_result_textview);
        smallUnitFluidTextView.setText(String.format(String.valueOf(largerFluidUnits), "%.2f", largerFluidUnits));

    }
    // image/button to take you to the menu of apps
    public void menu_button_converter(View view) {
        // Create a new intent to open the {@link fluids calculations to Menu}
        Intent converter_menu_intent = new Intent(ConverterActivity.this, BackgroundActivity.class);

        // Start the new activity
        startActivity(converter_menu_intent); // conversion calculator  activity to Menu Activity
    }

    public void calculation_Large_units(View view) {
        EditText largeToSmall =  findViewById(R.id.large_unit_1000);
        String largeToSmallValue = largeToSmall.getText().toString();
        largeToSmallNum = Float.parseFloat(largeToSmallValue);

        smallerUnits = largeToSmallNum * 1000;

        TextView largeUnitResultTextView =  findViewById(R.id.large_unit_result_textview);
        largeUnitResultTextView.setText(String.format(String.valueOf(smallerUnits), "%.2f", smallerUnits));
    }

    public void calculation_small_units(View view) {
        EditText smallToLarge =  findViewById(R.id.small_unit_1000);
        String smallToLargeValue = smallToLarge.getText().toString();
        smallToLargeNum = Float.parseFloat(smallToLargeValue);

        largerUnits = smallToLargeNum / 1000;

        TextView smallResultTextView =  findViewById(R.id.small_result_textview);
        smallResultTextView.setText(String.format(String.valueOf(largerUnits), "%.2f", largerUnits));
    }

    public void calculation_Large_fluid_units(View view) {
        EditText largeToSmallFluids =  findViewById(R.id.large_unit_fluids_1000);
        String largeToSmallFluidsValue = largeToSmallFluids.getText().toString();
        largeToSmallFluidsNum = Float.parseFloat(largeToSmallFluidsValue);

        smallerFluidUnits = largeToSmallFluidsNum * 1000;

        TextView largeUnitFluidTextView =  findViewById(R.id.large_unit_fluid_textview);
        largeUnitFluidTextView.setText(String.format(String.valueOf(smallerFluidUnits), "%.2f", smallerFluidUnits));
    }

    public void calculation_small_fluid_units(View view) {
        EditText smallToLargeFluids =  findViewById(R.id.small_unit_fluids_1000);
        String smallToLargeFluidsValue = smallToLargeFluids.getText().toString();
        smallToLargeFluidsNum = Float.parseFloat(smallToLargeFluidsValue);

        largerFluidUnits = smallToLargeFluidsNum / 1000;

        TextView smallUnitFluidTextView =  findViewById(R.id.small_fluid_result_textview);
        smallUnitFluidTextView.setText(String.format(String.valueOf(largerFluidUnits), "%.2f", largerFluidUnits));
    }
}
