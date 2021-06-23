package com.haerul.foodsapp.view.home;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import com.google.firebase.auth.FirebaseAuth;
import com.haerul.foodsapp.R;

public class login extends AppCompatActivity {
    EditText mEmail,mPassword;
    ImageButton mLoginBtn;
    TextView mCreateBtn,forgotTextLink;
    ProgressBar progressBar;
    FirebaseAuth fAuth;
    ImageView lobo;
    TextView restu;
    ImageView lobo2;
    ImageView lobo3;
    ImageView bck;

    Animation btt,bttdua,bttiga;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        btt= AnimationUtils.loadAnimation(this,R.anim.btt);
        bttdua= AnimationUtils.loadAnimation(this,R.anim.bttdua);
        bttiga= AnimationUtils.loadAnimation(this,R.anim.bttiga);


        mEmail = findViewById(R.id.Email);
        mPassword = findViewById(R.id.password);
        progressBar = findViewById(R.id.progressBar);
        fAuth = FirebaseAuth.getInstance();
        mLoginBtn = findViewById(R.id.loginBtn);
        mCreateBtn = findViewById(R.id.createText);
        forgotTextLink = findViewById(R.id.forgotPassword);
        lobo = findViewById(R.id.imageView7);
        lobo2 = findViewById(R.id.imageView8);
        lobo3 = findViewById(R.id.imageView9);
        bck=findViewById(R.id.imageView);
restu= findViewById(R.id.textView);
bck.startAnimation(bttiga);
        lobo.startAnimation(btt);
        restu.startAnimation(bttdua);
        lobo2.startAnimation(bttdua);
        lobo3.startAnimation(bttdua);
        mEmail.startAnimation(bttiga);
        mPassword.startAnimation(bttiga);
        mLoginBtn.startAnimation(bttiga);
        mCreateBtn.startAnimation(bttiga);
        forgotTextLink.startAnimation(bttiga);






        mLoginBtn.setOnClickListener(v -> {

            String email = mEmail.getText().toString().trim();
            String password = mPassword.getText().toString().trim();

            if(TextUtils.isEmpty(email)){
                mEmail.setError("Email is Required.");
                return;
            }

            if(TextUtils.isEmpty(password)){
                mPassword.setError("Password is Required.");
                return;
            }

            if(password.length() < 6){
                mPassword.setError("Password Must be >= 6 Characters");
                return;
            }

            progressBar.setVisibility(View.VISIBLE);

            // authenticate the user

            fAuth.signInWithEmailAndPassword(email,password).addOnCompleteListener(task -> {
                if(task.isSuccessful()){
                    Toast.makeText(login.this, "Logged in Successfully", Toast.LENGTH_SHORT).show();
                    startActivity(new Intent(getApplicationContext(),HomeActivity.class));
                }else {
                    Toast.makeText(login.this, "Error ! " + task.getException().getMessage(), Toast.LENGTH_SHORT).show();
                    progressBar.setVisibility(View.GONE);
                }

            });

        });

        mCreateBtn.setOnClickListener(v -> startActivity(new Intent(getApplicationContext(),Register.class)));

        forgotTextLink.setOnClickListener(v -> {

            final EditText resetMail = new EditText(v.getContext());
            final AlertDialog.Builder passwordResetDialog = new AlertDialog.Builder(v.getContext());
            passwordResetDialog.setTitle("Reset Password ?");
            passwordResetDialog.setMessage("Enter Your Email To Received Reset Link.");
            passwordResetDialog.setView(resetMail);

            passwordResetDialog.setPositiveButton("Yes", (dialog, which) -> {
                // extract the email and send reset link
                String mail = resetMail.getText().toString();
                fAuth.sendPasswordResetEmail(mail).addOnSuccessListener(aVoid -> Toast.makeText(login.this,
                        "Reset Link Sent To Your Email.", Toast.LENGTH_SHORT).show()).addOnFailureListener(e -> Toast.makeText(login.this,
                        "Error ! Reset Link is Not Sent" + e.getMessage(), Toast.LENGTH_SHORT).show());

            });

            passwordResetDialog.setNegativeButton("No", (dialog, which) -> {
                // close the dialog
            });

            passwordResetDialog.create().show();

        });


    }
}
