package com.cullendevelopment.resuscitationapp;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import android.view.View;

public class WebsiteActivity  extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_websites);


    }

    public void menu_button_websites(View view) {
        // Create a new intent to open the {@link Useful websites to Menu}
        Intent websites_menu_intent = new Intent(WebsiteActivity.this, BackgroundActivity.class);

        // Start the new activity
        startActivity(websites_menu_intent); // Useful websites activity to Menu Activity
    }

    public void alsg(View view) {
        String url = "https://www.alsg.org/home";
        Intent alsg = new Intent(Intent.ACTION_VIEW);
        alsg.setData(Uri.parse(url));
        startActivity(alsg); // ALSG uk website
    }

    public void aim(View view) {
        String url = "https://www.gmccmt.org.uk/critical-care-skills-institute/acute-illness-management";
        Intent aim = new Intent(Intent.ACTION_VIEW);
        aim.setData(Uri.parse(url));
        startActivity(aim); // opens AIM website
    }

    public void resus(View view) {
        String url = "https://www.resus.org.uk";
        Intent resus = new Intent(Intent.ACTION_VIEW);
        resus.setData(Uri.parse(url));
        startActivity(resus); // opens resus council uk website
    }
}
