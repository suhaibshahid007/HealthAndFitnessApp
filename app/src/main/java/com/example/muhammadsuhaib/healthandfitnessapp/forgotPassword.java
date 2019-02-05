package com.example.muhammadsuhaib.healthandfitnessapp;

import android.app.ProgressDialog;
import android.support.annotation.NonNull;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.FirebaseAuth;

public class forgotPassword extends AppCompatActivity implements  View.OnClickListener {

    private FirebaseAuth auth;
    public EditText forgot_email;
    public Button forgotButton;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_forgot_password);


        auth = FirebaseAuth.getInstance();

        forgot_email = findViewById(R.id.emailForgot);

        forgotButton = findViewById(R.id.forgotBtn);
        // here the click listener ....
        forgotButton.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {

        if(v.getId() == R.id.forgotBtn)
        {
            resetPassword(forgot_email.getText().toString());
        }

    }

    // here the function that reset the password...

    public void resetPassword(final String email)
    {
         if(TextUtils.isEmpty(email))
         {
             forgot_email.setError("Required");
             return ;
         }

        // here call the fucntion of internet detector that tell whether internet are available on device or not ...


        InternetDetector internetDetector = new InternetDetector(this);

        boolean result = internetDetector.isConnected();

        if(result == false)
        {
            // show message that internet is not connected ...
            View view = findViewById(R.id.main_layout);

            Snackbar.make(view , "Looks like you are not connected to internet !!! " ,Snackbar.LENGTH_SHORT).show();
            return;
        }

        // here the code to show the progress dialog...

        final ProgressDialog progressDialog = new ProgressDialog(this);
        progressDialog.setMessage("Reset Password .....");
        progressDialog.show();

         auth.sendPasswordResetEmail(email).addOnCompleteListener(new OnCompleteListener<Void>() {
             @Override
             public void onComplete(@NonNull Task<Void> task) {

                 View view = findViewById(R.id.main_layout);
                 if(task.isSuccessful())
                 {
                     progressDialog.dismiss();
                     Snackbar.make(view , "We have sent Password to email "+email, Snackbar.LENGTH_SHORT).show();
                 }
                 else
                 {
                     progressDialog.dismiss();
                     Snackbar.make(view , "Failed to send Password !!!", Snackbar.LENGTH_SHORT).show();
                 }
             }
         });
    }
}
