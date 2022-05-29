package MHAE.m391.project;

import android.content.Intent;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import  android.view.Window;
import android.widget.Button;

import MHAE.m391.project.DataBase.DataBase;

public class MainActivity extends AppCompatActivity {
     Button getStart;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getSupportActionBar().hide();
        setContentView(R.layout.activity_main);
        getStart =(Button) findViewById(R.id.start);
       // DataBase x=new DataBase (this);
        //x.Insert("ali amir","ali@gmail.com","12345","01013001808",30,1);
        getStart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this,login.class));
                finish();
            }
        });
    }
}