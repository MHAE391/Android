package MHAE.m391.project;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
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
        getStart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this,login.class));
                finish();
            }
        });
    }
}