package com.cullendevelopment.resuscitationapp;

import android.content.Intent;
import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import android.view.View;

public class ABG extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_abg);


    }

    public void menu_button_abg(View view) {
        // Create a new intent to open the {@link ABG calculations to Menu}
        Intent abg_menu_intent = new Intent(ABG.this, BackgroundActivity.class);

        // Start the new activity
        startActivity(abg_menu_intent); // ABG calcs activity to Menu Activity
    }

}
