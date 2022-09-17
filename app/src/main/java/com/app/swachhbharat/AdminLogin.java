package com.app.swachhbharat;


import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
public class AdminLogin extends AppCompatActivity {
    private EditText editText;
    private Button button;
    private String passwordString;
    private int chances;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_admin_login);
        chances = 3;
        editText = findViewById(R.id.password_admin);
        button = findViewById(R.id.continue_);
        passwordString = "admin123";

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (chances ==0){
                    Intent intent = new Intent(AdminLogin.this,Login.class);
                    startActivity(intent);
                }
                if (editText.getText().toString().equals(passwordString)){
                    Intent intent = new Intent(AdminLogin.this,AdminPanel.class);
                    startActivity(intent);
                }
                else {
                    Toast.makeText(getApplicationContext(),"Wrong Admin Password, "+chances+" more tries available",Toast.LENGTH_LONG).show();
                    chances = chances-1;
                    editText.setText("");
                }
            }
        });


    }
}
