package com.cullendevelopment.resuscitationapp;

import android.content.Intent;
import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import android.view.View;

public class BackgroundActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_background);
    }

    public void calcs_button(View view) {
        // Create a new intent to open the {@link Menu to paed resus calculations}
        Intent calcs_menu_intent = new Intent(BackgroundActivity.this, CalcsActivity.class);

        // Start the new activity
        startActivity(calcs_menu_intent); // Menu Activity
    }

    public void website_button(View view) {
        // Create a new intent to open the {@link Menu to websites}
        Intent websites_menu_intent = new Intent(BackgroundActivity.this, WebsiteActivity.class);

        // Start the new activity
        startActivity(websites_menu_intent); // Menu to websites Activity
    }


    public void fluids_button(View view) {
        // Create a new intent to open the {@link Menu to Fluids activity}
        Intent fluids_menu_intent = new Intent(BackgroundActivity.this, Fluids.class);

        // Start the new activity
        startActivity(fluids_menu_intent); // Menu to abg Activity
    }

    public void converter_button(View view) {
        // Create a new intent to open the {@link Menu to converter activity}
        Intent converter_menu_intent = new Intent(BackgroundActivity.this, ConverterActivity.class);

        // Start the new activity
        startActivity(converter_menu_intent); // Menu to converter Activity
    }

    public void metric_measurement_button(View view) {
        // Create a new intent to open the {@link Menu to metric measurement Activity}
        Intent metric_measurement_menu_intent = new Intent(BackgroundActivity.this, MetricMeasurement.class);

        // Start the new activity
        startActivity(metric_measurement_menu_intent); // Menu to metric measurement Activity
    }


    public void bsa_button(View view) {
        // Create a new intent to open the {@link Menu to body surface area Activity}
        Intent body_surface_menu_intent = new Intent(BackgroundActivity.this, BodySurfaceActivity.class);

        // Start the new activity
        startActivity(body_surface_menu_intent); // Menu to body surface area Activity
    }

    public void bmi_button(View view) {
        // Create a new intent to open the {@link Menu to metric to imperial Activity}
        Intent bmi_menu_intent = new Intent(BackgroundActivity.this, BMIActivity.class);

        // Start the new activity
        startActivity(bmi_menu_intent); // Menu to metric to imperial Activity
    }
}
