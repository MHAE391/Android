package MHAE.m391.project;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import MHAE.m391.project.DataBase.DataBase;
import MHAE.m391.project.DataBase.User;

public class ChangePassword extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getSupportActionBar().hide();
        setContentView(R.layout.activity_change_password);
        DataBase x=new DataBase(this);
        User y=x.GetProfile();
        EditText  OldPassword =(EditText) findViewById(R.id.OldPassword);
        EditText  NewPassword =(EditText) findViewById(R.id.NewPassword);
        EditText  ReNewPassword =(EditText) findViewById(R.id.ReNewPassword);
        Button  Change=(Button) findViewById(R.id.ChangeOldPassword);
        Change.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String old=OldPassword.getText().toString();
                String New=NewPassword.getText().toString();
                String ReNew=ReNewPassword.getText().toString();
                if(Validation.PasswordValidation(old).equals("Empty")|| Validation.PasswordValidation(New).equals("Empty")||
                        Validation.PasswordValidation(ReNew).equals("Empty")){
                    Toast.makeText(ChangePassword.this, "Please Fill All Inputs", Toast.LENGTH_SHORT).show();
                }else if(!old.equals(y.getPassword())){
                    Toast.makeText(ChangePassword.this, "Wrong Old Password", Toast.LENGTH_SHORT).show();
                }else if(Validation.PasswordValidation(New).equals("Small Password") ||
                        Validation.PasswordValidation(ReNew).equals("Small Password") ){
                    Toast.makeText(ChangePassword.this, "Password Must Be 4 Character Or More", Toast.LENGTH_SHORT).show();
                }else if(!New.equals(ReNew)){
                    Toast.makeText(ChangePassword.this, "Password & Confirm Password Does Not Match", Toast.LENGTH_SHORT).show();
                }else if(New.equals(old)){
                    Toast.makeText(ChangePassword.this, "Old Password Is The Same New Password", Toast.LENGTH_SHORT).show();
                }else {
                    x.ChangePassword(y.getEmail(),New);
                    Toast.makeText(ChangePassword.this, "Password Changed ", Toast.LENGTH_SHORT).show();
                    startActivity(new Intent(ChangePassword.this,UserUi.class));
                    finish();
                }

            }
        });
    }
}