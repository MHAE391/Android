package MHAE.m391.project;

import android.content.Intent;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.widget.EditText;
import android.widget.Toast;

import MHAE.m391.project.DataBase.DataBase;

public class Register extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getSupportActionBar().hide();
        setContentView(R.layout.activity_register);

        EditText FirstName=(EditText) findViewById(R.id.FirstName);
        EditText LastName=(EditText) findViewById(R.id.LastName);
        EditText Email=(EditText) findViewById(R.id.RegisterEmail);
        EditText Password=(EditText) findViewById(R.id.RegisterPassword);
        EditText RePassword=(EditText) findViewById(R.id.ReRegisterPassword);
        EditText Age=(EditText) findViewById(R.id.Age);
        EditText Phone=(EditText) findViewById(R.id.Phone);

        findViewById(R.id.RegisterButton).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String firstName=FirstName.getText().toString().toLowerCase();
                String lastName=LastName.getText().toString().toLowerCase();
                String email=Email.getText().toString().toLowerCase();
                String password=Password.getText().toString().toLowerCase();
                String rePassword=RePassword.getText().toString().toLowerCase();
                String age=Age.getText().toString().toLowerCase();
                String phone=Phone.getText().toString().toLowerCase();

                if(Validation.PasswordValidation(password).equals("Empty") || Validation.EmailValidation(email).equals("Empty")
                || Validation.NameValidation(firstName).equals("Empty")|| Validation.NameValidation(lastName).equals("Empty")
                || Validation.PasswordValidation(rePassword).equals("Empty") || Validation.AgeValidation(age).equals("Empty")
                || Validation.PhoneValidation(phone).equals("Empty")){
                    Toast.makeText(Register.this,"Please Fill Inputs",Toast.LENGTH_SHORT).show();
                }else {

                    if(Validation.EmailValidation(email).equals("Format Error")){
                        Toast.makeText(Register.this,"Email Must Be Like This Format : " +
                                "\n         Example@Test.com",Toast.LENGTH_SHORT).show();
                    }
                    else if(Validation.EmailValidation(email).equals("Starting Error")){
                        Toast.makeText(Register.this,"Email Must Start With Character",Toast.LENGTH_SHORT).show();
                    }

                    else if(Validation.PasswordValidation(password).equals("Small Password")){
                        Toast.makeText(Register.this,"Password Must Be 4 Numbers Or More",Toast.LENGTH_SHORT).show();
                    }else if(Validation.NameValidation(firstName).equals("Too Small") || Validation.NameValidation(lastName).equals("Too Small")
                             || Validation.NameValidation(firstName).equals("Too Match") ||Validation.NameValidation(lastName).equals("Too Match")) {
                        Toast.makeText(Register.this,"Name Must Be 3 Characters Or More " +
                                "\n & Name Must Be \n 15 Characters Or Less ",Toast.LENGTH_SHORT).show();
                    } else if(Validation.NameValidation(firstName).equals("Not Valid")||Validation.NameValidation(lastName).equals("Not Valid")){
                        Toast.makeText(Register.this, "Name Must Include One Character At Least", Toast.LENGTH_SHORT).show();
                    } else if(Validation.NameValidation(firstName).equals("Find Space")||Validation.NameValidation(lastName).equals("Find Space")) {
                        Toast.makeText(Register.this, "Name Include Spaces", Toast.LENGTH_SHORT).show();
                    }else if(Validation.NameValidation(firstName).equals("Special Character") || Validation.NameValidation(lastName).equals("Special Character") ) {
                        Toast.makeText(Register.this, "Name Include Special Character", Toast.LENGTH_SHORT).show();
                    }else if(Validation.AgeValidation(age).equals("Wrong Start")) {
                        Toast.makeText(Register.this, "Not Acceptable Age", Toast.LENGTH_SHORT).show();
                    }else if(Validation.AgeValidation(age).equals("Not Acceptable Age")) {
                        Toast.makeText(Register.this, "Age Must Be 18 Or More " +
                                "\n   Age Must Be 99 Or Less ", Toast.LENGTH_SHORT).show();
                    }else if(Validation.PhoneValidation(phone).equals("Zero Not Founded")||Validation.PhoneValidation(phone).equals("No One")) {
                        Toast.makeText(Register.this, "Phone Must Start With 01", Toast.LENGTH_SHORT).show();
                    }else if(Validation.PhoneValidation(phone).equals("Not Acceptable Phone")) {
                        Toast.makeText(Register.this, "Phone Must Be 11 Number", Toast.LENGTH_SHORT).show();
                    }else if(!password.equals(rePassword)) {
                        Toast.makeText(Register.this, "Password And Confirm Password Does Not Match", Toast.LENGTH_SHORT).show();
                    } else{
                        DataBase x=new DataBase(Register.this);
                        if(x.Check(email.toString()).equals("User")){
                            Toast.makeText(Register.this, email+"\nIs Already A User", Toast.LENGTH_SHORT).show();
                        } else {
                            String Done=x.Insert(firstName+" "+lastName,email,password,phone,Integer.parseInt(age),0);

                       if(Done.equals("DONE")) {
                           startActivity(new Intent(Register.this, login.class));
                           Toast.makeText(Register.this, "Account Created", Toast.LENGTH_SHORT).show();
                       }else{
                           Toast.makeText(Register.this, "Can't Create Account", Toast.LENGTH_SHORT).show();
                       }                }
                }
            }
            }
        });


    }
}