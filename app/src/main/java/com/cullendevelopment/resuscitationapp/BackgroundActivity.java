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

    public void abg_button(View view) {
        // Create a new intent to open the {@link Menu to abg activity}
        Intent abg_menu_intent = new Intent(BackgroundActivity.this, ABG.class);

        // Start the new activity
        startActivity(abg_menu_intent); // Menu to abg Activity
    }

    public void fluids_button(View view) {
        // Create a new intent to open the {@link Menu to Fluids activity}
        Intent fluids_menu_intent = new Intent(BackgroundActivity.this, Fluids.class);

        // Start the new activity
        startActivity(fluids_menu_intent); // Menu to abg Activity
    }

}
