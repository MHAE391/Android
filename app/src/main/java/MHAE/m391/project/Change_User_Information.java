package MHAE.m391.project;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import MHAE.m391.project.DataBase.DataBase;
import MHAE.m391.project.DataBase.User;

public class Change_User_Information extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getSupportActionBar().hide();
        setContentView(R.layout.activity_change_user_information);
        DataBase x=new DataBase(this);
        User y=x.GetProfile();
        EditText Fname=findViewById(R.id.ChangeFirstName);
        EditText Lname=findViewById(R.id.ChangeLastName);
        EditText Email=findViewById(R.id.ChangeEmail);
        EditText Password=findViewById(R.id.ChangePassword);
        EditText Phone=findViewById(R.id.ChangePhone);
        EditText Age=findViewById(R.id.ChangeAge);
        String [] Name=y.getName().split(" ",2);
        Fname.setText(Name[0]);
        Lname.setText(Name[1]);
        Email.setText(y.getEmail());
        Phone.setText(y.getPhone());
        Age.setText(y.getAge()+"");

        findViewById(R.id.Change).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String password=Password.getText().toString();
                if(!password.equals(y.getPassword())){
                    Toast.makeText(Change_User_Information.this,"Wrong Password",Toast.LENGTH_SHORT).show();
                }else {
                    String firstName=Fname.getText().toString().toLowerCase();
                    String lastName=Lname.getText().toString().toLowerCase();
                    String email=Email.getText().toString().toLowerCase();
                    String age=Age.getText().toString().toLowerCase();
                    String phone=Phone.getText().toString().toLowerCase();
                    if(Validation.PasswordValidation(password).equals("Empty") || Validation.EmailValidation(email).equals("Empty")
                            || Validation.NameValidation(firstName).equals("Empty")|| Validation.NameValidation(lastName).equals("Empty")
                            || Validation.AgeValidation(age).equals("Empty")
                            || Validation.PhoneValidation(phone).equals("Empty")){
                        Toast.makeText(Change_User_Information.this,"Please Fill Inputs",Toast.LENGTH_SHORT).show();
                    }else {

                        if(Validation.EmailValidation(email).equals("Format Error")){
                            Toast.makeText(Change_User_Information.this,"Email Must Be Like This Format : " +
                                    "\n         Example@Test.com",Toast.LENGTH_SHORT).show();
                        }
                        else if(Validation.EmailValidation(email).equals("Starting Error")){
                            Toast.makeText(Change_User_Information.this,"Email Must Start With Character",Toast.LENGTH_SHORT).show();
                        }

                        else if(Validation.PasswordValidation(password).equals("Small Password")){
                            Toast.makeText(Change_User_Information.this,"Password Must Be 4 Numbers Or More",Toast.LENGTH_SHORT).show();
                        }else if(Validation.NameValidation(firstName).equals("Too Small") || Validation.NameValidation(lastName).equals("Too Small")
                                || Validation.NameValidation(firstName).equals("Too Match") ||Validation.NameValidation(lastName).equals("Too Match")) {
                            Toast.makeText(Change_User_Information.this,"Name Must Be 3 Characters Or More " +
                                    "\n & Name Must Be \n 15 Characters Or Less ",Toast.LENGTH_SHORT).show();
                        } else if(Validation.NameValidation(firstName).equals("Not Valid")||Validation.NameValidation(lastName).equals("Not Valid")){
                            Toast.makeText(Change_User_Information.this, "Name Must Include One Character At Least", Toast.LENGTH_SHORT).show();
                        } else if(Validation.NameValidation(firstName).equals("Find Space")||Validation.NameValidation(lastName).equals("Find Space")) {
                            Toast.makeText(Change_User_Information.this, "Name Include Spaces", Toast.LENGTH_SHORT).show();
                        }else if(Validation.NameValidation(firstName).equals("Special Character") || Validation.NameValidation(lastName).equals("Special Character") ) {
                            Toast.makeText(Change_User_Information.this, "Name Include Special Character", Toast.LENGTH_SHORT).show();
                        }else if(Validation.AgeValidation(age).equals("Wrong Start")) {
                            Toast.makeText(Change_User_Information.this, "Not Acceptable Age", Toast.LENGTH_SHORT).show();
                        }else if(Validation.AgeValidation(age).equals("Not Acceptable Age")) {
                            Toast.makeText(Change_User_Information.this, "Age Must Be 18 Or More " +
                                    "\n   Age Must Be 99 Or Less ", Toast.LENGTH_SHORT).show();
                        }else if(Validation.PhoneValidation(phone).equals("Zero Not Founded")||Validation.PhoneValidation(phone).equals("No One")) {
                            Toast.makeText(Change_User_Information.this, "Phone Must Start With 01", Toast.LENGTH_SHORT).show();
                        }else if(Validation.PhoneValidation(phone).equals("Not Acceptable Phone")) {
                            Toast.makeText(Change_User_Information.this, "Phone Must Be 11 Number", Toast.LENGTH_SHORT).show();
                        }else {
                            if(phone.equals(y.getPhone())&& age.equals(y.getAge()+"")&&y.getName().equals(firstName+" "+lastName)
                            && email.equals(y.getEmail())){
                                Toast.makeText(Change_User_Information.this,"Nothing Changed",Toast.LENGTH_SHORT).show();
                            }else {
                                x.ChangeInformation(y.getEmail(),firstName+" "+lastName,email,phone,Integer.parseInt(age));
                                Toast.makeText(Change_User_Information.this, "Updated Successfully", Toast.LENGTH_SHORT).show();
                                startActivity(new Intent(Change_User_Information.this,UserUi.class));
                                finish();
                            }
                        }
                    }
                }
            }
        });



    }
}