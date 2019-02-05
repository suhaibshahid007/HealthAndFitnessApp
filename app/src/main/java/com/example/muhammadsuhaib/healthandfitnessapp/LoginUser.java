package com.example.muhammadsuhaib.healthandfitnessapp;

import android.app.ProgressDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.annotation.NonNull;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class LoginUser extends AppCompatActivity  implements  View.OnClickListener{


    public TextView signUpText;
    public EditText login_email , login_password;
    public TextView forgotPassword;
    public Button loginBtn;

   // public SharedPreferences sharedPreferences;

    private FirebaseAuth auth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login_user);

        // get the views...
        signUpText = (TextView) findViewById(R.id.tv_signup);
        forgotPassword =(TextView)findViewById(R.id.forgotPass);
        login_email = (EditText)findViewById(R.id.login_email);
        login_password = (EditText)findViewById(R.id.login_password);
        loginBtn = (Button)findViewById(R.id.loginBtn);

       // sharedPreferences = getSharedPreferences("data" , MODE_PRIVATE);
        // here the click listener ...

        loginBtn.setOnClickListener(this);
        signUpText.setOnClickListener(this);
        forgotPassword.setOnClickListener(this);

        // here check the sessions...

        auth = FirebaseAuth.getInstance();

       if(auth.getCurrentUser() !=null)
        {
            startActivity(new Intent(LoginUser.this , MainActivity.class));
        }

    }

    @Override
    public void onClick(View v) {

        // here check if the login button clicks...

        // for forgot password
        if(v.getId() == R.id.forgotPass)
        {
               startActivity( new Intent(LoginUser.this , forgotPassword.class));
        }
         // for sign up
       else  if(v.getId() == R.id.tv_signup)
        {
            startActivity( new Intent(LoginUser.this , signup.class));
        }
        // for login..
        else if (v.getId() == R.id.loginBtn)
        {

            // get the email and password from the fields and pass to the function...

            validateLogin(login_email.getText().toString() , login_password.getText().toString());

        }

    }

    // here the function that validates it is the valid user....
    private void validateLogin(String email, String password) {

        if(TextUtils.isEmpty(email))
        {
            login_email.setError("Required");
            return;
        }

        if(TextUtils.isEmpty(password))
        {
            login_password.setError("Required");
            return;
        }

        // here call the fucntion of internet detector that tell whether internet are available on device or not ...


         InternetDetector internetDetector = new InternetDetector(this);

           boolean result = internetDetector.isConnected();

           if(result == false)
           {
               // show message that internet is not connected ...
               View view = findViewById(R.id.main_layout_id);

               Snackbar.make(view , "Looks like you are not connected to internet !!! " ,Snackbar.LENGTH_SHORT).show();
               return;
           }


        // here the code of the progress dialog...
        final  ProgressDialog progressDialog = new ProgressDialog(LoginUser.this);
        progressDialog.setMessage("Signing in...");
        progressDialog.show();



        auth.signInWithEmailAndPassword(email , password).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(@NonNull Task<AuthResult> task) {


                if(task.isSuccessful())
                {
                    progressDialog.dismiss();
                    startActivity(new Intent(LoginUser.this , MainActivity.class));
                   // sharedPreferences.edit().putBoolean("flag",true);
                    finish();
                }
                else
                {
                    progressDialog.dismiss();
                    View view =  findViewById(R.id.main_layout_id);
                  //  sharedPreferences.edit().putBoolean("flag",false);
                 Snackbar.make(view, "Email or Password is Incorrect !!!",Snackbar.LENGTH_SHORT).show();


                    //Toast.makeText(LoginUser.this ," Email or password is Incorrect !!!" , Toast.LENGTH_SHORT).show();
                }
            }
        });
    }

    @Override
    public void onBackPressed() {
       // super.onBackPressed();

        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("Fitness Buddy");
        builder.setMessage("Do you want to exit?")
                .setCancelable(false)
                .setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {
                        finish();
                        System.exit(0);
                    }
                })
                .setNegativeButton("No", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {
                        dialog.cancel();
                    }
                });
        AlertDialog alert = builder.create();
        alert.show();
    }


}
