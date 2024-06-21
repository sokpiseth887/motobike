package com.example.AgricultureApp;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.example.agricultureapp.R;

public class MainActivity extends AppCompatActivity {
public Button btnLogin;
private EditText etUsername, etPassword;
//private String realUser = "Jame", realPass = "123";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        btnLogin = findViewById(R.id.btnLogin);
        etUsername = findViewById(R.id.etUser);
        etPassword = findViewById(R.id.etPass);

        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
            String strUser = etUsername.getText().toString().trim();
//            String strPass = etPassword.getText().toString().trim();
//            if(strUser.equals(realUser) && strPass.equals(realPass)){
                //bundle
                Bundle mBundle = new Bundle();
                mBundle.putString("username",strUser);
                Toast.makeText(MainActivity.this, "Login Successfully", Toast.LENGTH_SHORT).show();
                Intent i = new Intent(MainActivity.this, start.class);
                i.putExtras(mBundle); // sent data from login to account details
                startActivity(i);
//            }else{
//                Toast.makeText(MainActivity.this, "Login Failed , Try again", Toast.LENGTH_SHORT).show();
//            }
            }
        });
    }
}