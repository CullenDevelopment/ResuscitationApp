package com.cullendevelopment.resuscitationapp;


import android.content.Intent;
import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageView;

public class BackgroundActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_background);
        //onClickListeners for activity background
        ImageView calcs_link = findViewById(R.id.calcs_paed);
        calcs_link.setOnClickListener(this::calcs_link);

        ImageView websites = findViewById(R.id.websites);
        websites.setOnClickListener(this::websites);

        ImageView fluids_link = findViewById(R.id.fluids);
        fluids_link.setOnClickListener(this::fluids_link);

        ImageView body_surface = findViewById(R.id.body_surface);
        body_surface.setOnClickListener(this::body_surface);

        ImageView bmi_link = findViewById(R.id.bmi);
        bmi_link.setOnClickListener(this::bmi_link);

        ImageView gcs_view = findViewById(R.id.gcs_view);
        gcs_view.setOnClickListener(this::gcs_view);

        ImageView flacc = findViewById(R.id.flacc);
        flacc.setOnClickListener(this::flacc);


        ImageView temperature_conv = findViewById(R.id.temp_conversion);
        temperature_conv.setOnClickListener(this::temperature_conv);




    }

    public void calcs_link(View view) {
        // Create a new intent to open the {@link Menu to paed resus calculations}
        Intent calcs_menu_intent = new Intent(BackgroundActivity.this, CalcsActivity.class);

        // Start the new activity
        startActivity(calcs_menu_intent); // Menu Activity
    }

    public void websites(View view) {
        // Create a new intent to open the {@link Menu to websites}
        Intent websites_menu_intent = new Intent(BackgroundActivity.this, WebsiteActivity.class);

        // Start the new activity
        startActivity(websites_menu_intent); // Menu to websites Activity
    }


    public void fluids_link(View view) {
        // Create a new intent to open the {@link Menu to Fluids activity}
        Intent fluids_menu_intent = new Intent(BackgroundActivity.this, Fluids.class);

        // Start the new activity
        startActivity(fluids_menu_intent); // Menu to abg Activity
    }


    public void body_surface(View view) {
        // Create a new intent to open the {@link Menu to body surface area Activity}
        Intent body_surface_menu_intent = new Intent(BackgroundActivity.this, BodySurfaceActivity.class);

        // Start the new activity
        startActivity(body_surface_menu_intent); // Menu to body surface area Activity
    }

    public void bmi_link(View view) {
        // Create a new intent to open the {@link Menu to metric to imperial Activity}
        Intent bmi_menu_intent = new Intent(BackgroundActivity.this, BMIActivity.class);

        // Start the new activity
        startActivity(bmi_menu_intent); // Menu to metric to imperial Activity
    }

    public void gcs_view(View view) {
        // Create a new intent to open the {@link Menu to PGCSActivity}
        Intent pgcs_menu_intent = new Intent(BackgroundActivity.this, PgcsActivity.class);

        // Start the new activity
        startActivity(pgcs_menu_intent); // Menu to PGCSActivity
    }

    public void flacc(View view) {
        // Create a new intent to open the {@link Menu to FlaccActivity}
        Intent flacc_menu_intent = new Intent(BackgroundActivity.this, FlaccActivity.class);

        // Start the new activity
        startActivity(flacc_menu_intent); // Menu to FlaccActivity
    }


    public void temperature_conv(View view) {
        // Create a new intent to open the {@link Menu to TempConvActivity}
        Intent temp_conv_menu_intent = new Intent(BackgroundActivity.this, TempConvActivity.class);

        // Start the new activity
        startActivity(temp_conv_menu_intent); // Menu to TempConvSActivity
    }
}
