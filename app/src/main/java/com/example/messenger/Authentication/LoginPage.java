package com.example.messenger.Authentication;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Patterns;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.messenger.ForgotPassword;
import com.example.messenger.HomePage;
import com.example.messenger.R;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class LoginPage extends AppCompatActivity {


    EditText UEmail;
    EditText UPassword;
    TextView UForgot;
    TextView URegister;
    Button ULogin;

    FirebaseAuth firebaseAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login_page2);

        this.bindComponents();

        //---------------------------------------
        ULogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                logIn();
            }
        });

        URegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(LoginPage.this, RegistrationPage.class);
                startActivity(i);
            }
        });

        //-----------------------------------------------
        UForgot.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(LoginPage.this, ForgotPassword.class);
                startActivity(i);
            }
        });



    }
    //****************************
    private void bindComponents() {
        UEmail=findViewById(R.id.UEmail);
        UPassword=findViewById(R.id.UPassword);
        ULogin=findViewById(R.id.ULogin);
        URegister=findViewById(R.id.URegister);
        UForgot=findViewById(R.id.UForgot);
    }
  //**********************************************

    private void logIn()
    {
        String email=UEmail.getText().toString().trim();
        String pass=UPassword.getText().toString().trim();

        if(ValidateCred())
        {

            firebaseAuth = FirebaseAuth.getInstance();

            firebaseAuth.signInWithEmailAndPassword(email, pass)
                    .addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
                        @Override
                        public void onComplete(@NonNull Task<AuthResult> task) {
                            if (task.isSuccessful()) {


                                Intent i = new Intent(LoginPage.this, HomePage.class);
                                startActivity(i);
                                // Sign in success, update UI with the signed-in user's information


                            } else {
                                // If sign in fails, display a message to the user.
                                Toast.makeText(LoginPage.this, "Invalid Credentials Try Again!", Toast.LENGTH_LONG).show();


                            }
                        }
                    });

        }

    }
  //**************************************************
  private boolean ValidateCred()
  {
      String email=UEmail.getText().toString().trim();
      String pass=UPassword.getText().toString().trim();

      if(email.isEmpty())
      {
          UEmail.setError("EMail cannot Empty");
          UEmail.requestFocus();
          return false;
      }
      if(pass.isEmpty())
      {
          UPassword.setError("Password cannot Epmty");
          UPassword.requestFocus();
          return false;
      }
      if(!Patterns.EMAIL_ADDRESS.matcher(email).matches())
      {
          UEmail.setError("Email should be valid");
          UEmail.requestFocus();
          return  false;
      }
      return true;
  }
 //*************************************************************

}