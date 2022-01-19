package com.example.alafitness;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

/**
 * Class for logging into the application, child class that contains inherited methods.
 * Calls methods from the DBHelper class.
 */
public class LoginActivity extends AppCompatActivity {
    EditText username, password;
    Button buttonLogin;
    Button buttonSignup;
    DBHelper DB;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        username = findViewById(R.id.username);
        password = findViewById(R.id.password);
        buttonLogin = findViewById(R.id.sign_in_button);
        buttonSignup = findViewById(R.id.sign_up_button);
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
                        Intent intent = new Intent(LoginActivity.this, ProfileActivity.class);
                        intent.putExtra("username", user);
                        startActivity(intent);
                        Log.i("Successful login", username.getText().toString());
                    } else {
                        Toast.makeText(LoginActivity.this, "Invalid username or password!", Toast.LENGTH_SHORT).show();
                    }
                }
            }
        });

        buttonSignup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent2 = new Intent (LoginActivity.this, SignupActivity.class);
                startActivity(intent2);
            }
        });
    }
}
