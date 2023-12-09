package com.example.projetmob;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class ShowDetailsActivity extends AppCompatActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_show_details);

        Intent i = getIntent();
        int showId = i.getIntExtra("showId", 0);
        String showUrl = i.getStringExtra("showUrl");
        String showLanguage = i.getStringExtra("showLanguage");

        // Populate UI components with show details
        TextView idTextView = findViewById(R.id.textViewShowId);
        TextView urlTextView = findViewById(R.id.textViewShowUrl);
        TextView languageTextView = findViewById(R.id.textViewShowLanguage);

        idTextView.setText(String.valueOf(showId));
        urlTextView.setText(showUrl);
        languageTextView.setText(showLanguage);

        // Add click listener to the URL TextView
        urlTextView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Open the URL in a web browser
                Uri uri = Uri.parse(showUrl);
                Intent intent = new Intent(Intent.ACTION_VIEW, uri);
                startActivity(intent);
            }
        });
    }
}
