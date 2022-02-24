package com.example.alafitness;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

/**
 * Class for signing up to the application, child class that contains inherited methods.
 * Calls methods from the DBHelper class.
 */
public class SignupActivity extends AppCompatActivity {
    EditText username, password, retypePassword;
    Button buttonSignUp, buttonSignIn;
    DBHelper DB;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().addFlags(WindowManager.LayoutParams.FLAG_KEEP_SCREEN_ON);
        setContentView(R.layout.activity_sing_up);
        username = findViewById(R.id.new_username);
        password = findViewById(R.id.new_password);
        retypePassword = findViewById(R.id.retype_password);
        buttonSignUp = findViewById(R.id.sign_up_button);
        buttonSignIn = findViewById(R.id.sign_in_button);
        DB = new DBHelper(this);

        buttonSignUp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String user = username.getText().toString();
                String pass = password.getText().toString();
                String repass = retypePassword.getText().toString();
                if (user.equals("") || pass.equals("") || repass.equals("")) {
                    Toast.makeText(SignupActivity.this, "Please enter your username, the new password and retype the new password!", Toast.LENGTH_SHORT).show();
                } else {
                    if (pass.equals(repass)) {
                        Boolean checkUser = DB.checkUsername(user);
                        if (checkUser == false) {
                            Boolean insert = DB.insertUserData(user, pass);
                            if (insert == true) {
                                Toast.makeText(SignupActivity.this, "User successfully registered!", Toast.LENGTH_SHORT).show();
                                Intent intent = new Intent(getApplicationContext(), LoginActivity.class);
                                startActivity(intent);
                            } else {
                                Toast.makeText(SignupActivity.this, "Registration has failed!", Toast.LENGTH_SHORT).show();
                            }
                        } else {
                            Toast.makeText(SignupActivity.this, "User already exists! Please sign in", Toast.LENGTH_SHORT).show();
                        }
                    } else {
                        Toast.makeText(SignupActivity.this, "Passwords do not match! Please check!", Toast.LENGTH_SHORT).show();
                    }
                }
            }
        });

        buttonSignIn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent1 = new Intent(getApplicationContext(), LoginActivity.class);
                startActivity(intent1);
            }
        });
    }
}