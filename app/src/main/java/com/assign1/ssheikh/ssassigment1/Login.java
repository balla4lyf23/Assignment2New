package com.assign1.ssheikh.ssassigment1;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Patterns;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class Login extends AppCompatActivity {

    private EditText editEmail, editPassword;
    private String password, email;
    Button btnSubmitCreds;
    Button btnSignUp;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        if (android.os.Build.VERSION.SDK_INT >= 21) {
            Window window = this.getWindow();
            window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS);
            window.clearFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);
            window.setStatusBarColor(this.getResources().getColor(R.color.black));
        }
        editEmail = (EditText) findViewById(R.id.editTxtEmail);
        editPassword = (EditText) findViewById(R.id.editTxtPass);
        btnSubmitCreds = (Button) findViewById(R.id.btnSubmitCreds);
        btnSignUp = (Button) findViewById(R.id.btnSignUp);
        btnSubmitCreds.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                setUp();
            }
        });
        btnSignUp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Login.this ,SignUp.class);
                startActivity(intent);
            }
        });
    }

    public void setUp(){
        trim();
        if (!validation()){
            Toast.makeText(this,"Sign-in failed. Please try again.", Toast.LENGTH_SHORT).show();
            }
            else {
            ifSuccessful();
            }
        }

        public void ifSuccessful(){

            Intent intent = new Intent(Login.this, Scores.class);
            startActivity(intent);

        }

        public boolean validation(){
            boolean ok = true;
            if (email.isEmpty() || !Patterns.EMAIL_ADDRESS.matcher(email).matches()){
                editEmail.setError("Please try entering email again.");
                ok=false;
            }

            if (password.isEmpty()){
                editPassword.setError("Please try entering password again");
                ok = false;
            }
            return ok;
    }

    public void trim(){
        email = editEmail.getText().toString().trim();
        password = editPassword.getText().toString().trim();

    }
}




