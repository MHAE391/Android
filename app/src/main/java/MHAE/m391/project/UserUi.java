package MHAE.m391.project;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Window;

public class UserUi extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getSupportActionBar().hide();
        setContentView(R.layout.activity_user_ui);
    }
}