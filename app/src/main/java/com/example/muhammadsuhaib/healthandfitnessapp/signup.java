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
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class signup extends AppCompatActivity  implements View.OnClickListener{

    public EditText signupEmail ;
    public EditText signupPassword;
    public Button signupBtn;
    public EditText signupName;

    private FirebaseAuth auth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup);

        signupEmail = findViewById(R.id.signup_email);
        signupPassword = findViewById(R.id.signup_password);
        signupBtn = findViewById(R.id.btn_signup);
        signupName = findViewById(R.id.signUp_username);

        auth = FirebaseAuth.getInstance();

        // here the listener ...

        signupBtn.setOnClickListener(this);

    }


    @Override
    public void onClick(View v) {

        if(v.getId() == R.id.btn_signup)
        {
            validateSignUp(signupEmail.getText().toString() , signupPassword.getText().toString() ,signupName.getText().toString());
        }
    }

    // here the function that sign up the user ....
    private void validateSignUp(String email, final String password  , String name) {

        if(TextUtils.isEmpty(name))
        {
            signupName.setError("Required");
            return;
        }
        if(TextUtils.isEmpty(email))
        {
           signupEmail.setError("Required");
           return;
        }

        if(TextUtils.isEmpty(password))
        {
           signupPassword.setError("Required");
           return;
        }

        // here call the fucntion of internet detector that tell whether internet are available on device or not ...


        InternetDetector internetDetector = new InternetDetector(this);

        boolean result = internetDetector.isConnected();

        if(result == false)
        {
            // show message that internet is not connected ...
            View view = findViewById(R.id.main_layout);

            Snackbar.make(view , "Looks like you are not connected to internet !!!" ,Snackbar.LENGTH_SHORT).show();
            return;
        }

        // here the code of the progress dialog...
        final  ProgressDialog progressDialog = new ProgressDialog(signup.this);
        progressDialog.setMessage("Signing Up....");
        progressDialog.show();

        auth.createUserWithEmailAndPassword(email , password).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(@NonNull Task<AuthResult> task) {

                View view = findViewById(R.id.main_layout);
                if(task.isSuccessful())
                {

                    progressDialog.dismiss();
                    Snackbar.make(view , "User Sucessfully Signup !!!! " , Snackbar.LENGTH_SHORT).show();
                    signupName.setHint("Name");
                    signupEmail.setHint("Email");
                    signupPassword.setHint("Password");
                }
                else
                {
                   // signupEmail.setHint(" ");
                    //signupPassword.setHint("");
                    progressDialog.dismiss();
                    if(password.length() < 6) {
                        Snackbar.make(view, " Failed  !!! Password must me 6 or more letters ", Snackbar.LENGTH_SHORT).show();
                    }
                }
            }
        });
    }
}
