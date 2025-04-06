package com.spamdetector.activities;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import com.spamdetector.R;
import com.spamdetector.utils.SpamDetector;

public class SettingsActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_settings);

        EditText whitelistEditText = findViewById(R.id.whitelistEditText);
        Button addWhitelistButton = findViewById(R.id.addWhitelistButton);
        EditText falsePositiveEditText = findViewById(R.id.falsePositiveEditText);
        Button reportFalsePositiveButton = findViewById(R.id.reportFalsePositiveButton);

        addWhitelistButton.setOnClickListener(v -> {
            String number = whitelistEditText.getText().toString();
            if (!number.isEmpty()) {
                SpamDetector.addToWhitelist(number);
                whitelistEditText.setText("");
                Toast.makeText(this, "Number added to whitelist", Toast.LENGTH_SHORT).show();
            } else {
                Toast.makeText(this, "Please enter a phone number", Toast.LENGTH_SHORT).show();
            }
        });

        reportFalsePositiveButton.setOnClickListener(v -> {
            String message = falsePositiveEditText.getText().toString();
            if (!message.isEmpty()) {
                // TODO: Implement false positive reporting
                falsePositiveEditText.setText("");
                Toast.makeText(this, "False positive reported", Toast.LENGTH_SHORT).show();
            } else {
                Toast.makeText(this, "Please enter message content", Toast.LENGTH_SHORT).show();
            }
        });
    }
}