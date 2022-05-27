package MHAE.m391.project;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

import MHAE.m391.project.DataBase.DataBase;
import MHAE.m391.project.DataBase.User;

public class login extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getSupportActionBar().hide();
        setContentView(R.layout.activity_login);
        TextView Register=(TextView) findViewById(R.id.Register);
        Register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(login.this,Register.class));
                finish();
            }
        });
        EditText Email=(EditText) findViewById(R.id.LoginEmail);
        EditText Password=(EditText) findViewById(R.id.LoginPassword);
        Button Login=(Button) findViewById(R.id.LogIn);

        Login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String password=Password.getText().toString();
                String email=Email.getText().toString().toLowerCase();

                if(Validation.PasswordValidation(password).equals("Empty") || Validation.EmailValidation(email).equals("Empty")){
                    Toast.makeText(login.this,"Please Fill Inputs",Toast.LENGTH_SHORT).show();
                }else {

               if(Validation.EmailValidation(email).equals("Format Error")){
                   Toast.makeText(login.this,"Email Must Be Like This Format : " +
                                "\n         Example@Test.com",Toast.LENGTH_SHORT).show();
               }
               else if(Validation.EmailValidation(email).equals("Starting Error")){
                        Toast.makeText(login.this,"Email Must Start With Character",Toast.LENGTH_SHORT).show();
               }

              else if(Validation.PasswordValidation(password).equals("Small Password")){
                        Toast.makeText(login.this,"Password Must Be 4 Numbers Or More",Toast.LENGTH_SHORT).show();
               }else{
                    DataBase x=new DataBase(login.this);
                    if(x.CheckUser(email.toString(),password.toString()).equals("User"))
                    {
                    startActivity(new Intent(login.this,UserUi.class));
                        Toast.makeText(login.this,"Successful Login",Toast.LENGTH_SHORT).show();
                        finish();
                    }else if(x.CheckUser(email.toString(),password.toString()).equals("Admin")){
                        startActivity(new Intent(login.this,AdminUi.class));
                        Toast.makeText(login.this,"Successful Login",Toast.LENGTH_SHORT).show();
                        finish();
                    }else {
                        Toast.makeText(login.this,"Email Or Password Is Wrong ",Toast.LENGTH_SHORT).show();
                    }
                }
            }
            }
        });

        findViewById(R.id.Forget).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(login.this,ForgetPassword.class));
            }
        });
    }
    }