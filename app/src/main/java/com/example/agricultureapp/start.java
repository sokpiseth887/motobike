package com.example.agricultureapp;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;
import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class start extends AppCompatActivity {

    public Button btnStart;
     TextView txtName;
    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_start);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        txtName = findViewById(R.id.txtName);
        Bundle extras = getIntent().getExtras();
        if(extras == null){
            return;
        }else{
            txtName.setText(extras.getString("username"));
        }


        btnStart = findViewById(R.id.btnStarted);
        btnStart.setOnClickListener(view -> {
            Toast.makeText(start.this, "Welcome To My App:)", Toast.LENGTH_SHORT).show();
            Intent i = new Intent(start.this,navigation.class);
            startActivity(i);
        });
    }
}