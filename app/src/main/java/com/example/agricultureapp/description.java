package com.example.agricultureapp;

import static com.example.agricultureapp.R.id.btnBok;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class description extends AppCompatActivity implements View.OnClickListener{
public Button btnCart;
public ImageView imgbackDep;
ImageView btnDork,btnBok;
TextView quantity,total;



    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_description);
        btnBok = findViewById(R.id.btnBok);
        btnDork = findViewById(R.id.btnDork);
        quantity = findViewById(R.id.quantity);
        total = findViewById(R.id.total); // Find the total TextView
        btnBok.setOnClickListener(this);
        btnDork.setOnClickListener(this);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        imgbackDep = findViewById(R.id.imgbackDep);
        imgbackDep.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
        btnCart = findViewById(R.id.btnCart);
        btnCart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(description.this,payment.class);
                startActivity(i);
            }
        });
    }

    @SuppressLint("NonConstantResourceId")
    @Override
    public void onClick(View view) {

        if (view.getId() == R.id.btnBok) {
            String bokproduct = quantity.getText().toString();
            int Addnumber = Integer.parseInt(bokproduct);
            Addnumber+=1;
             final String updateNumber = String.valueOf(Addnumber);
            quantity.post(new Runnable() {
                @Override
                public void run() {
                    quantity.setText(updateNumber);
                }
            });


            // Calculate total price and update the total TextView
            double totalPrice = Addnumber * 3.99;
            @SuppressLint("DefaultLocale") final String updateTotal = String.format("%.2f", totalPrice);
            total.post(new Runnable() {
                @Override
                public void run() {
                    total.setText(updateTotal);
                }
            });


        } else if (view.getId() == R.id.btnDork) {
            String dokproduct = quantity.getText().toString();
            int Doknumber = Integer.parseInt(dokproduct);
            Doknumber-=1;
           final String updateNumber1 = String.valueOf(Doknumber);
            quantity.post(new Runnable() {
                @Override
                public void run() {
                    quantity.setText(updateNumber1);
                }
            });


            // Calculate total price and update the total TextView
            double totalPrice = Doknumber * 3.99;
            final String updateTotal = String.format("%.2f", totalPrice);
            total.post(new Runnable() {
                @Override
                public void run() {
                    total.setText(updateTotal);
                }
            });
        }

    }
}