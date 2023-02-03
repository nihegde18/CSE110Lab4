package edu.ucsd.cse110.lab4;

import androidx.appcompat.app.AppCompatActivity;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class ProfileActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);
        loadProfile();
        Button goBackButton = findViewById(R.id.button_go_back);
        goBackButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onGoBackClicked();
            }
        });
    }

    private void loadProfile() {
        SharedPreferences sharedPreferences = getSharedPreferences("profile", MODE_PRIVATE);
        String name = sharedPreferences.getString("name", "");
        String status = sharedPreferences.getString("status", "");
        EditText nameEditText = (EditText) findViewById(R.id.name_textview);
        EditText statusEditText = findViewById(R.id.status_textview);
        nameEditText.setText(name);
        statusEditText.setText(status);
    }

    private void saveProfile(){
        EditText nameEditText = findViewById(R.id.name_textview);
        EditText statusEditText = findViewById(R.id.status_textview);
        String name = nameEditText.getText().toString();
        String status = statusEditText.getText().toString();
        SharedPreferences sharedPreferences = getSharedPreferences("profile", MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putString("name", name);
        editor.putString("status", status);
        editor.apply();
    }

    private void onGoBackClicked() {
        finish();
    }
}