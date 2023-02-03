package edu.ucsd.cse110.lab4;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button launchProfileButton = findViewById(R.id.button_launch_profile);
        launchProfileButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onLaunchProfileClicked();
            }
        });
    }

    public void onLaunchProfileClicked() {
        Intent intent = new Intent(this, ProfileActivity.class);
        startActivity(intent);
    }
}