package com.cullendevelopment.resuscitationapp;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;




public class MetricMeasurement extends AppCompatActivity {

    public float mmToCm = 0;
    public float millimetresToCentimetresNum = 0;
    public float cmToMM = 0;
    public float centimetresToMillimetresNum = 0;
    public float mmToM = 0;
    public float millimetresToMetresNum = 0;
    public float metresToMillimetresNum = 0;
    public float mToMM = 0;
    public float cmToM = 0;
    public float centimetresToMetresNum =0;
    public float mToCm =0;
    public float metresToCentimetresNum = 0;

    public static String MM_TO_CM = "MM_TO_CM";
    public static String MILLIMETRES_TO_CENTIMETRES_NUM= "MILLIMETRES_TO_CENTIMETRES_NUM";
    public static String CM_TO_MM= "CM_TO_MM";
    public static String CENTIMETRES_TO_MILLIMETRES_NUM = "CENTIMETRES_TO_MILLIMETRES_NUM";
    public static String MM_TO_M = "MM_TO_M";
    public static String MILLIMETRES_TO_METRES_NUM = "MILLIMETRES_TO_METRES_NUM";
    public static String METRES_TO_MILLIMETRES_NUM = "METRES_TO_MILLIMETRES_NUM";
    public static String M_TO_MM = "M_TO_MM";
    public static String CM_TO_M = "CM_TO_M";
    public static String CENTIMETRES_TO_METRES_NUM = "CENTIMETRES_TO_METRES_NUM";
    public static String M_TO_CM = "M_TO_CM";
    public static String METRES_TO_CENTIMETRES_NUM = "METRES_TO_CENTIMETRES_NUM";





    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_metric_measurement);

        TextView millimetres_centimetres_textview =  findViewById(R.id.millimetres_centimetres_textview);
        millimetres_centimetres_textview.setText(String.format(String.valueOf(mmToCm), "%.2f", mmToCm));

        TextView centimetres_millimetres_textview =  findViewById(R.id.centimetres_millimetres_textview);
        centimetres_millimetres_textview.setText(String.format(String.valueOf(cmToMM), "%.2f", cmToMM));

        TextView millimetres_metres_textview =  findViewById(R.id.millimetres_metres_textview);
        millimetres_metres_textview.setText(String.format(String.valueOf(mmToM), "%.2f", mmToM));

        TextView metres_millimetres_textview =  findViewById(R.id.metres_millimetres_textview);
        metres_millimetres_textview.setText(String.format(String.valueOf(mToMM), "%.2f", mToMM));

        TextView centimetres_result_textview =  findViewById(R.id.centimetres_result_textview);
        centimetres_result_textview.setText(String.format(String.valueOf(cmToM), "%.2f", cmToM));

        TextView metres_result_textview =  findViewById(R.id.metres_result_textview);
        metres_result_textview.setText(String.format(String.valueOf(mToCm), "%.2f", mToCm));
    }

    //Use onSaveInstanceState(Bundle) and onRestoreInstanceState
    @Override
    public void onSaveInstanceState(@NonNull Bundle  outState) {
        super.onSaveInstanceState(outState);
        outState.putFloat(MM_TO_CM, mmToCm);
        outState.putFloat(MILLIMETRES_TO_CENTIMETRES_NUM, millimetresToCentimetresNum);
        outState.putFloat(CM_TO_MM, cmToMM);
        outState.putFloat(CENTIMETRES_TO_MILLIMETRES_NUM, centimetresToMillimetresNum);
        outState.putFloat(MM_TO_M, mmToM);
        outState.putFloat(MILLIMETRES_TO_METRES_NUM, millimetresToMetresNum);
        outState.putFloat(METRES_TO_MILLIMETRES_NUM, metresToMillimetresNum);
        outState.putFloat(M_TO_MM, mToMM);
        outState.putFloat(CM_TO_M, cmToM);
        outState.putFloat(CENTIMETRES_TO_METRES_NUM, centimetresToMetresNum);
        outState.putFloat(M_TO_CM, mToCm);
        outState.putFloat(METRES_TO_CENTIMETRES_NUM, metresToCentimetresNum);

    }

    //onRestoreInstanceState
    @Override
    public void onRestoreInstanceState(@NonNull Bundle  savedInstanceState) {

        super.onRestoreInstanceState(savedInstanceState);

        // Restore UI state from the savedInstanceState.
        // This bundle has also been passed to onCreate.


        mmToCm = savedInstanceState.getFloat(MM_TO_CM);
        mmToCmDisplay(mmToCm);

        cmToMM = savedInstanceState.getFloat(CM_TO_MM);
        cmToMMDisplay(cmToMM);

        mmToM = savedInstanceState.getFloat(MM_TO_M);
        mmToMDisplay(mmToM);

        mToMM = savedInstanceState.getFloat(M_TO_MM);
        mToMMDisplay(mToMM);

        cmToM = savedInstanceState.getFloat(CM_TO_M);
        cmToMDisplay(cmToM);

        mToCm = savedInstanceState.getFloat(M_TO_CM);
        mToCmDisplay(mmToCm);

    }


    public void calculation_millimetres_to_centimetres(View view) {
        EditText millimetresToCentimetres = findViewById(R.id.millimetres_centimetres);
        String millimetresToCentimetresValue = millimetresToCentimetres.getText().toString();
        millimetresToCentimetresNum = Float.parseFloat(millimetresToCentimetresValue);

        mmToCm = millimetresToCentimetresNum / 10;

        TextView millimetres_centimetres_textview =  findViewById(R.id.millimetres_centimetres_textview);
        millimetres_centimetres_textview.setText(String.format(String.valueOf(mmToCm), "%.2f", mmToCm));
    }


    public void calculate_centimetres_millimetres(View view) {
        EditText centimetresToMillimetres = findViewById(R.id.centimetres_millimetres);
        String centimetresToMillimetresValue = centimetresToMillimetres.getText().toString();
        centimetresToMillimetresNum = Float.parseFloat(centimetresToMillimetresValue);

        cmToMM = centimetresToMillimetresNum * 10;

        TextView centimetres_millimetres_textview =  findViewById(R.id.centimetres_millimetres_textview);
        centimetres_millimetres_textview.setText(String.format(String.valueOf(cmToMM), "%.2f", cmToMM));
    }

    public void calculate_millimetres_metres(View view) {
        EditText millimetresToMetres = findViewById(R.id.millimetres_metres);
        String millimetresToMetresValue = millimetresToMetres.getText().toString();
        millimetresToMetresNum = Float.parseFloat(millimetresToMetresValue);

        mmToM = millimetresToMetresNum / 1000;

        TextView millimetres_metres_textview =  findViewById(R.id.millimetres_metres_textview);
        millimetres_metres_textview.setText(String.format(String.valueOf(mmToM), "%.2f", mmToM));
    }

    public void calculate_metres_millimetres(View view) {
        EditText metresToMillimetres = findViewById(R.id.metres_millimetres);
        String metresToMillimetresValue = metresToMillimetres.getText().toString();
        metresToMillimetresNum = Float.parseFloat(metresToMillimetresValue);

        mToMM = metresToMillimetresNum * 1000;

        TextView metres_millimetres_textview =  findViewById(R.id.metres_millimetres_textview);
        metres_millimetres_textview.setText(String.format(String.valueOf(mToMM), "%.2f", mToMM));
    }

    public void calculate_centimetres_metres(View view) {
        EditText centimetresToMetres =  findViewById(R.id.centimetres_metres);
        String centimetresToMetresValue = centimetresToMetres.getText().toString();
        centimetresToMetresNum = Float.parseFloat(centimetresToMetresValue);

        cmToM = centimetresToMetresNum / 100;

        TextView centimetres_result_textview =  findViewById(R.id.centimetres_result_textview);
        centimetres_result_textview.setText(String.format(String.valueOf(cmToM), "%.2f", cmToM));
    }

    public void calculate_metres_centimetres(View view) {
        EditText metresToCentimetres =  findViewById(R.id.metres_centimetres);
        String metresToCentimetresValue = metresToCentimetres.getText().toString();
        metresToCentimetresNum = Float.parseFloat(metresToCentimetresValue);

        mToCm = metresToCentimetresNum * 100;

        TextView metres_result_textview =  findViewById(R.id.metres_result_textview);
        metres_result_textview.setText(String.format(String.valueOf(mToCm), "%.2f", mToCm));
    }

    /**
     * This method displays the mm to cm conversion on the screen.
     */
    public void mmToCmDisplay(float mmToCm) {
        TextView millimetres_centimetres_textview =  findViewById(R.id.millimetres_centimetres_textview);
        millimetres_centimetres_textview.setText(String.format(String.valueOf(mmToCm), "%.2f", mmToCm));
    }

    /**
     * This method displays the  cm to mm conversion on the screen.
     */
    public void cmToMMDisplay(float cmToMM) {
        TextView centimetres_millimetres_textview =  findViewById(R.id.centimetres_millimetres_textview);
        centimetres_millimetres_textview.setText(String.format(String.valueOf(cmToMM), "%.2f", cmToMM));
    }

    /**
     * This method displays the  mm to m conversion on the screen.
     */
    public void mmToMDisplay(float mmToM) {
        TextView millimetres_metres_textview =  findViewById(R.id.millimetres_metres_textview);
        millimetres_metres_textview.setText(String.format(String.valueOf(mmToM), "%.2f", mmToM));
    }
    /**
     * This method displays the  m to mm conversion on the screen.
     */
    public void mToMMDisplay(float mToMM) {
        TextView metres_millimetres_textview =  findViewById(R.id.metres_millimetres_textview);
        metres_millimetres_textview.setText(String.format(String.valueOf(mToMM), "%.2f", mToMM));
    }
    /**
     * This method displays the  cm to m conversion on the screen.
     */
    public void cmToMDisplay(float cmToM) {
        TextView centimetres_result_textview =  findViewById(R.id.centimetres_result_textview);
        centimetres_result_textview.setText(String.format(String.valueOf(cmToM), "%.2f", cmToM));

    }
    /**
     * This method displays the  m to cm conversion on the screen.
     */
    public void mToCmDisplay(float mToCm) {
        TextView metres_result_textview =  findViewById(R.id.metres_result_textview);
        metres_result_textview.setText(String.format(String.valueOf(mToCm), "%.2f", mToCm));

    }


    public void menu_button_metric_measurement(View view) {
        // Create a new intent to open the {@link metric measurement conversions to Menu}
        Intent metric_measurement_menu_intent = new Intent(MetricMeasurement.this, BackgroundActivity.class);

        // Start the new activity
        startActivity(metric_measurement_menu_intent); // metric measurement converter  activity to Menu Activity
    }
}




