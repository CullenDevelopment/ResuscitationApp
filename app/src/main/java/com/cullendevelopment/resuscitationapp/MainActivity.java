package com.cullendevelopment.resuscitationapp;

import android.content.Intent;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // sets onClickListeners for mainActivity

        ImageView start = findViewById(R.id.start);
        start.setOnClickListener(this::start);


    }

    public void start(View view) {
        // Create a new intent to open the {@link menu/background}
        Intent start_home_intent = new Intent(MainActivity.this, BackgroundActivity.class);

        // Start the new activity
        startActivity(start_home_intent); // opens up the Menu/Background Activity
    }
}

