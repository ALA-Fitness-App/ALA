package com.example.alafitness;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class LoginActivity extends AppCompatActivity {

    EditText username, password;
    Button buttonLogin;
    DBHelper DB;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        username = findViewById(R.id.username);
        password = findViewById(R.id.password);
        buttonLogin = findViewById(R.id.sign_in_button);
        DB = new DBHelper(this);

        buttonLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String user = username.getText().toString();
                String pass = password.getText().toString();

                if (user.equals("") || pass.equals("")) {
                    Toast.makeText(LoginActivity.this, "Please enter your username and password!", Toast.LENGTH_SHORT).show();
                } else {
                    Boolean checkUserPass = DB.checkUsernamePassword(user, pass);
                    if (checkUserPass == true) {
                        Toast.makeText(LoginActivity.this, "Sign in successful!", Toast.LENGTH_SHORT).show();
                        Intent intent = new Intent(getApplicationContext(), profile.class);
                        startActivity(intent);
                    } else {
                        Toast.makeText(LoginActivity.this, "Invalid username or password!", Toast.LENGTH_SHORT).show();
                    }
                }
            }
        });
    }

}
