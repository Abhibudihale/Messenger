package com.example.messenger;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.messenger.Authentication.LoginPage;
import com.google.firebase.auth.FirebaseAuth;

public class HomePage extends AppCompatActivity {

    Button btnlogOut;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home_page);
        btnlogOut=findViewById(R.id.BtnlogOut);
        btnlogOut.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                LogOut();
            }
        });
    }

    private void LogOut() {
        FirebaseAuth.getInstance().signOut();
        Intent intent = new Intent(HomePage.this, LoginPage.class);

        //To make sure user cant go  back

        intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);

        startActivity(intent);

    }
}