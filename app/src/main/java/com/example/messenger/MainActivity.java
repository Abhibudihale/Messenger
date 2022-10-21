package com.example.messenger;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;

import com.example.messenger.Authentication.LoginPage;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class MainActivity extends AppCompatActivity {

    FirebaseUser firebaseUser;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

       firebaseUser = FirebaseAuth.getInstance().getCurrentUser();
        Intent intent1;
        if(firebaseUser != null)
        {
            intent1 = new Intent(MainActivity.this, HomePage.class);
        }
        else
        {
            intent1 = new Intent(MainActivity.this, LoginPage.class);
        }

        startActivity(intent1);

        finish();

    }
}

