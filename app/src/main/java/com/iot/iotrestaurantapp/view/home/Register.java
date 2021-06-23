package com.iot.iotrestaurantapp.view.home;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.FirebaseFirestore;
import com.iot.iotrestaurantapp.R;

import java.util.HashMap;
import java.util.Map;

public class Register extends AppCompatActivity {
    public static final String TAG = "TAG";
    EditText mFullName,mEmail,mPassword,mPhone;
   ImageButton mRegisterBtn;
    TextView mLoginBtn;
    FirebaseAuth fAuth;
    ProgressBar progressBar;
    FirebaseFirestore fStore;
    String userID;
   TextView a;
   TextView a2;
    ImageView a3;
    ImageView a4;
    ImageView a5;
    ImageView a6;
    ImageView bcke;
    Animation btt,bttdua,bttiga;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        btt= AnimationUtils.loadAnimation(this,R.anim.btt);
        bttdua= AnimationUtils.loadAnimation(this,R.anim.bttdua);
        bttiga= AnimationUtils.loadAnimation(this,R.anim.bttiga);

        mFullName   = findViewById(R.id.fullName);
        mEmail      = findViewById(R.id.Email);
        mPassword   = findViewById(R.id.password);
        mPhone      = findViewById(R.id.phone);
        mRegisterBtn= findViewById(R.id.registerBtn);
        mLoginBtn   = findViewById(R.id.createText);
        bcke=findViewById(R.id.imageView5);
        a= findViewById(R.id.textView);
        a2= findViewById(R.id.textView2);
        a3= findViewById(R.id.imageView10);
        a4= findViewById(R.id.imageView11);
        a5= findViewById(R.id.imageView12);
        a6= findViewById(R.id.imageView13);


        fAuth = FirebaseAuth.getInstance();
        fStore = FirebaseFirestore.getInstance();
        progressBar = findViewById(R.id.progressBar);
bcke.startAnimation(bttiga);
        a.startAnimation(bttdua);
        a2.startAnimation(bttdua);
        a3.startAnimation(bttdua);
        a4.startAnimation(bttdua);
        a5.startAnimation(bttdua);
        a6.startAnimation(bttdua);
        mEmail.startAnimation(bttiga);
        mPassword.startAnimation(bttiga);
        mPhone.startAnimation(bttiga);
        mRegisterBtn.startAnimation(bttiga);
        mLoginBtn.startAnimation(bttiga);




        if(fAuth.getCurrentUser() != null){
            startActivity(new Intent(getApplicationContext(),MainActivity.class));
            finish();
        }


        mRegisterBtn.setOnClickListener(v -> {
            final String email = mEmail.getText().toString().trim();
            String password = mPassword.getText().toString().trim();
            final String fullName = mFullName.getText().toString();
            final String phone    = mPhone.getText().toString();

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

            // register the user in firebase

            fAuth.createUserWithEmailAndPassword(email,password).addOnCompleteListener(task -> {
                if(task.isSuccessful()){

                    // send verification link

                    FirebaseUser fuser = fAuth.getCurrentUser();
                    fuser.sendEmailVerification().addOnSuccessListener(aVoid -> Toast.makeText(Register.this,
                            "Verification Email Has been Sent.", Toast.LENGTH_SHORT).show()).addOnFailureListener(e -> Log.d(TAG,
                            "onFailure: Email not sent " + e.getMessage()));

                    Toast.makeText(Register.this, "User Created.", Toast.LENGTH_SHORT).show();
                    userID = fAuth.getCurrentUser().getUid();
                    DocumentReference documentReference = fStore.collection("users").document(userID);
                    Map<String,Object> user = new HashMap<>();
                    user.put("fName",fullName);
                    user.put("email",email);
                    user.put("phone",phone);
                    documentReference.set(user).addOnSuccessListener(aVoid -> Log.d(TAG, "onSuccess: user Profile is created for "+ userID)).addOnFailureListener(e -> Log.d(TAG, "onFailure: " + e.toString()));
                    startActivity(new Intent(getApplicationContext(),MainActivity.class));

                }else {
                    Toast.makeText(Register.this, "Error ! " + task.getException().getMessage(), Toast.LENGTH_SHORT).show();
                    progressBar.setVisibility(View.GONE);
                }
            });
        });



        mLoginBtn.setOnClickListener(v -> startActivity(new Intent(getApplicationContext(),login.class)));

    }
}
