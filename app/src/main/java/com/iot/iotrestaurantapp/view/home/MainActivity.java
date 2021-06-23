
package com.iot.iotrestaurantapp.view.home;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.util.Log;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.StorageReference;
import com.iot.iotrestaurantapp.R;
import com.squareup.picasso.Picasso;

import java.util.Objects;

public class MainActivity extends AppCompatActivity {

    private static final int GALLERY_INTENT_CODE = 1023;
    TextView fullName, email, phone, verifyMsg;
    FirebaseAuth fAuth;
    FirebaseFirestore fStore;
    String userId;
    Button resendCode;
    Button app;
    Button resetPassLocal, changeProfileImage;
    FirebaseUser user;
    ImageView profileImage;
    StorageReference storageReference;

    Animation btt,bttdua,bttiga;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        btt= AnimationUtils.loadAnimation(this,R.anim.btt);
        bttdua= AnimationUtils.loadAnimation(this,R.anim.bttdua);
        bttiga= AnimationUtils.loadAnimation(this,R.anim.bttiga);

        phone = findViewById(R.id.profilePhone);
        fullName = findViewById(R.id.profileName);
        email = findViewById(R.id.profileEmail);
        resetPassLocal = findViewById(R.id.resetPasswordLocal);
               app = findViewById(R.id.start);
        profileImage = findViewById(R.id.profileImage);
        changeProfileImage = findViewById(R.id.changeProfile);

        email.startAnimation(btt);
        fullName.startAnimation(btt);
        app.startAnimation(btt);
        changeProfileImage.startAnimation(btt);



        fAuth = FirebaseAuth.getInstance();
        fStore = FirebaseFirestore.getInstance();
        storageReference = FirebaseStorage.getInstance().getReference();

        StorageReference profileRef = storageReference.child("users/" + fAuth.getCurrentUser().getUid() + "/profile.jpg");
        profileRef.getDownloadUrl().addOnSuccessListener(uri -> Picasso.get().load(uri).into(profileImage));

        resendCode = findViewById(R.id.resendCode);
        verifyMsg = findViewById(R.id.verifyMsg);


        userId = fAuth.getCurrentUser().getUid();
        user = fAuth.getCurrentUser();

        if (!user.isEmailVerified()) {
            verifyMsg.setVisibility(View.VISIBLE);
            resendCode.setVisibility(View.VISIBLE);

            resendCode.setOnClickListener(v -> user.sendEmailVerification().addOnSuccessListener(aVoid -> Toast.makeText(v.getContext(),
                    "Verification Email Has been Sent.", Toast.LENGTH_SHORT).show()).addOnFailureListener(e -> Log.d("tag", "onFailure: Email not sent " + e.getMessage())));
        }


        DocumentReference documentReference = fStore.collection("users").document(userId);
        documentReference.addSnapshotListener(this, (documentSnapshot, e) -> {
            if (documentSnapshot.exists()) {
                phone.setText(documentSnapshot.getString("phone"));
                fullName.setText(documentSnapshot.getString("fName"));
                email.setText(documentSnapshot.getString("email"));
            } else {
                Log.d("tag", "onEvent: Document do not exists");
            }
        });


        resetPassLocal.setOnClickListener(v -> {

            final EditText resetPassword = new EditText(v.getContext());

            final AlertDialog.Builder passwordResetDialog = new AlertDialog.Builder(v.getContext());
            passwordResetDialog.setTitle("Reset Password ?");
            passwordResetDialog.setMessage("Enter New Password > 6 Characters long.");
            passwordResetDialog.setView(resetPassword);

            passwordResetDialog.setPositiveButton("Yes", (dialog, which) -> {
                // extract the email and send reset link
                String newPassword = resetPassword.getText().toString();
                user.updatePassword(newPassword).addOnSuccessListener(aVoid -> Toast.makeText(MainActivity.this, "Password Reset Successfully.", Toast.LENGTH_SHORT).show()).addOnFailureListener(e -> Toast.makeText(MainActivity.this, "Password Reset Failed.", Toast.LENGTH_SHORT).show());
            });

            passwordResetDialog.setNegativeButton("No", (dialog, which) -> {
                // close
            });

            passwordResetDialog.create().show();

        });

        changeProfileImage.setOnClickListener(v -> {
            // open gallery
            Intent openGalleryIntent = new Intent(Intent.ACTION_PICK, MediaStore.Images.Media.EXTERNAL_CONTENT_URI);
            startActivityForResult(openGalleryIntent, 1000);

        });
        app.setOnClickListener(v -> {

            startActivity(new Intent(getApplicationContext(), HomeActivity.class));

        });

    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @androidx.annotation.Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == 1000) {
            if (resultCode == Activity.RESULT_OK) {
                assert data != null;
                Uri imageUri = data.getData();

                //profileImage.setImageURI(imageUri);

                uploadImageToFirebase(imageUri);


            }
        }

    }

    private void uploadImageToFirebase(Uri imageUri) {
        // uplaod image to firebase storage
        final StorageReference fileRef = storageReference.child("users/" + Objects.requireNonNull(fAuth.getCurrentUser()).getUid() + "/profile.jpg");
        fileRef.putFile(imageUri).addOnSuccessListener(taskSnapshot -> fileRef.getDownloadUrl().addOnSuccessListener(uri -> Picasso.get().load(uri).into(profileImage))).addOnFailureListener(e -> Toast.makeText(MainActivity.this, "Failed.", Toast.LENGTH_SHORT).show());

    }

    public void logout(View view) {
        FirebaseAuth.getInstance().signOut();//logout
        startActivity(new Intent(getApplicationContext(), login.class));
        finish();
    }

    public void next(View view) {
        if (verifyMsg.getText().toString().equals("Email Not Verfied !")) {
            Toast.makeText(this, "please verify your email", Toast.LENGTH_SHORT).show();
        } else {
            startActivity(new Intent(getApplicationContext(), login.class));

        }
    }
}