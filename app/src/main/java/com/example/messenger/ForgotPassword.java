package com.example.messenger;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.FirebaseAuth;

public class ForgotPassword extends AppCompatActivity {

    Button FBtn;
    EditText FEMail;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_forgot_password);
        FBtn = findViewById(R.id.FBtn);
        FEMail=findViewById(R.id.FEmail);
        FBtn=findViewById(R.id.FBtn);

        FBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                solve();
            }
        });
    }
    //--------------------
    private void solve()
    {
        FirebaseAuth auth = FirebaseAuth.getInstance();
        String emailAddress = FEMail.getText().toString().trim();

        auth.sendPasswordResetEmail(emailAddress)
                .addOnCompleteListener(new OnCompleteListener<Void>() {
                    @Override
                    public void onComplete(@NonNull Task<Void> task) {
                        if (task.isSuccessful()) {
                            Toast.makeText(ForgotPassword.this,"Reset Link send on e mail",Toast.LENGTH_LONG).show();

                        }
                    }
                });

    }


}