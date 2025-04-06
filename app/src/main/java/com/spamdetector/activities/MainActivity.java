package com.spamdetector.activities;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import android.Manifest;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.widget.Button;
import android.widget.Toast;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.spamdetector.R;
import com.spamdetector.adapters.SpamMessageAdapter;
import com.spamdetector.models.SpamMessage;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private static final int SMS_PERMISSION_CODE = 100;
    private RecyclerView spamRecyclerView;
    private SpamMessageAdapter adapter;
    private List<SpamMessage> spamMessages = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Request SMS permissions
        if (checkSelfPermission(Manifest.permission.READ_SMS) != PackageManager.PERMISSION_GRANTED) {
            requestPermissions(new String[]{Manifest.permission.READ_SMS}, SMS_PERMISSION_CODE);
        }

        // Initialize RecyclerView
        spamRecyclerView = findViewById(R.id.spamRecyclerView);
        spamRecyclerView.setLayoutManager(new LinearLayoutManager(this));
        adapter = new SpamMessageAdapter(spamMessages);
        spamRecyclerView.setAdapter(adapter);

        // Settings FAB
        FloatingActionButton fabSettings = findViewById(R.id.fabSettings);
        fabSettings.setOnClickListener(view -> {
            // Open SettingsActivity
            Intent settingsIntent = new Intent(MainActivity.this, SettingsActivity.class);
            startActivity(settingsIntent);
        });

        // Load spam messages from database
        loadSpamMessages();
    }

    private void loadSpamMessages() {
        // Load sample messages from SpamDetector
        String[] spamSamples = SpamDetector.getSpamMessages();
        String[] hamSamples = SpamDetector.getHamMessages();
        
        // Add spam samples
        for (String message : spamSamples) {
            spamMessages.add(new SpamMessage(
                String.valueOf(new Random().nextInt(900000000) + 100000000), // Random 9-digit number
                message,
                System.currentTimeMillis() - new Random().nextInt(1000000000) // Random timestamp in past
            ));
        }
        
        // Add some ham samples (20% of total)
        for (int i = 0; i < hamSamples.length/5; i++) {
            spamMessages.add(new SpamMessage(
                String.valueOf(new Random().nextInt(900000000) + 100000000), // Random 9-digit number
                hamSamples[i],
                System.currentTimeMillis() - new Random().nextInt(1000000000) // Random timestamp in past
            ));
        }
        
        adapter.notifyDataSetChanged();
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        if (requestCode == SMS_PERMISSION_CODE) {
            if (grantResults.length > 0 && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                Toast.makeText(this, "SMS permission granted", Toast.LENGTH_SHORT).show();
            } else {
                Toast.makeText(this, "SMS permission denied", Toast.LENGTH_SHORT).show();
            }
        }
    }
}