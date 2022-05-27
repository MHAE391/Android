package MHAE.m391.project;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.widget.EditText;
import android.widget.Toast;

import MHAE.m391.project.DataBase.DataBase;

public class ForgetPassword extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getSupportActionBar().hide();

        setContentView(R.layout.activity_forget_password);

        EditText FirstName=(EditText) findViewById(R.id.ForgetPasswordFirstName);
        EditText LastName=(EditText) findViewById(R.id.ForgetPasswordLastName);
        EditText Email=(EditText) findViewById(R.id.ForgetPasswordEmail);
        EditText Age=(EditText) findViewById(R.id.ForgetPasswordAge);
        EditText Phone=(EditText) findViewById(R.id.ForgetPasswordPhone);

        findViewById(R.id.ForgetPasswordButton).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String firstName=FirstName.getText().toString().toLowerCase();
                String lastName=LastName.getText().toString().toLowerCase();
                String email=Email.getText().toString().toLowerCase();
                String age=Age.getText().toString().toLowerCase();
                String phone=Phone.getText().toString().toLowerCase();

                if( Validation.EmailValidation(email).equals("Empty")
                        || Validation.NameValidation(firstName).equals("Empty")|| Validation.NameValidation(lastName).equals("Empty")
                        || Validation.AgeValidation(age).equals("Empty")
                        || Validation.PhoneValidation(phone).equals("Empty")){
                    Toast.makeText(ForgetPassword.this,"Please Fill Inputs",Toast.LENGTH_SHORT).show();
                }else {

                    if(Validation.EmailValidation(email).equals("Format Error")){
                        Toast.makeText(ForgetPassword.this,"Email Must Be Like This Format : " +
                                "\n         Example@Test.com",Toast.LENGTH_SHORT).show();
                    }
                    else if(Validation.EmailValidation(email).equals("Starting Error")){
                        Toast.makeText(ForgetPassword.this,"Email Must Start With Character",Toast.LENGTH_SHORT).show();
                    }
                    else if(Validation.NameValidation(firstName).equals("Too Small") || Validation.NameValidation(lastName).equals("Too Small")
                            || Validation.NameValidation(firstName).equals("Too Match") ||Validation.NameValidation(lastName).equals("Too Match")) {
                        Toast.makeText(ForgetPassword.this,"Name Must Be 3 Characters Or More " +
                                "\n & Name Must Be \n 15 Characters Or Less ",Toast.LENGTH_SHORT).show();
                    } else if(Validation.NameValidation(firstName).equals("Not Valid")||Validation.NameValidation(lastName).equals("Not Valid")){
                        Toast.makeText(ForgetPassword.this, "Name Must Include One Character At Least", Toast.LENGTH_SHORT).show();
                    } else if(Validation.NameValidation(firstName).equals("Find Space")||Validation.NameValidation(lastName).equals("Find Space")) {
                        Toast.makeText(ForgetPassword.this, "Name Include Spaces", Toast.LENGTH_SHORT).show();
                    }else if(Validation.NameValidation(firstName).equals("Special Character") || Validation.NameValidation(lastName).equals("Special Character") ) {
                        Toast.makeText(ForgetPassword.this, "Name Include Special Character", Toast.LENGTH_SHORT).show();
                    }else if(Validation.AgeValidation(age).equals("Wrong Start")) {
                        Toast.makeText(ForgetPassword.this, "Not Acceptable Age", Toast.LENGTH_SHORT).show();
                    }else if(Validation.AgeValidation(age).equals("Not Acceptable Age")) {
                        Toast.makeText(ForgetPassword.this, "Age Must Be 18 Or More " +
                                "\n   Age Must Be 99 Or Less ", Toast.LENGTH_SHORT).show();
                    }else if(Validation.PhoneValidation(phone).equals("Zero Not Founded")||Validation.PhoneValidation(phone).equals("No One")) {
                        Toast.makeText(ForgetPassword.this, "Phone Must Start With 01", Toast.LENGTH_SHORT).show();
                    }else if(Validation.PhoneValidation(phone).equals("Not Acceptable Phone")) {
                        Toast.makeText(ForgetPassword.this, "Phone Must Be 11 Number", Toast.LENGTH_SHORT).show();
                    } else{
                        DataBase x=new DataBase(ForgetPassword.this);
                        String Res=x.ForgetPassword(firstName+" "+lastName,email,phone,Integer.parseInt(age));
                        if(Res.equals("NOT")){
                            Toast.makeText(ForgetPassword.this,"Not A User",Toast.LENGTH_SHORT).show();
                        }else {
                            Toast.makeText(ForgetPassword.this,"Your Password = "+Res,Toast.LENGTH_SHORT).show();
                            startActivity(new Intent(ForgetPassword.this,login.class));
                            finish();
                        }
                    }
                    }
                }
        });

}
}