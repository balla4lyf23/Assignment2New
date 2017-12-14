package com.assign1.ssheikh.ssassigment1;

import android.content.Intent;
import android.support.annotation.IdRes;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Patterns;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Switch;
import android.widget.TextView;
import android.widget.Toast;;

public class SignUp extends AppCompatActivity {

    private EditText editUserName, editEmail, editPassword;
    private String user, email, password;
    Button btnCreate;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);
        if (android.os.Build.VERSION.SDK_INT >= 21) {
            Window window = this.getWindow();
            window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS);
            window.clearFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);
            window.setStatusBarColor(this.getResources().getColor(R.color.black));
        }
        editUserName=(EditText) findViewById(R.id.editTxtUser);
        editEmail=(EditText) findViewById(R.id.editTxtCreateEmail);
        editPassword=(EditText) findViewById(R.id.editTxtCreatePass);
        btnCreate = (Button) findViewById(R.id.btnCreate);
        btnCreate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                setUp();
            }
        });
    }

    public void setUp(){
        trim();
        if (!validation()){
            Toast.makeText(this,"Sign-up failed. Please try again.", Toast.LENGTH_SHORT).show();
        }
        else {
            ifSuccessful();
        }
    }

    public void ifSuccessful(){

        Intent intent = new Intent(SignUp.this, Login.class);
        startActivity(intent);
    }

    public boolean validation(){
        boolean ok = true;

        if (user.isEmpty()){
            editUserName.setError("Please try entering a user name again.");
        }
        if (password.isEmpty()){
            editPassword.setError("Please try entering password again");
            ok = false;
        }
        if (email.isEmpty() || !Patterns.EMAIL_ADDRESS.matcher(email).matches()){
            editEmail.setError("Please try entering email again.");
            ok=false;
        }
        return ok;
    }

    public void trim(){

        user = editUserName.getText().toString().trim();
        email = editEmail.getText().toString().trim();
        password = editPassword.getText().toString().trim();

    }
}

