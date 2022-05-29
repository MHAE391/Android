package MHAE.m391.project;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.widget.EditText;
import android.widget.Toast;

import java.util.Locale;

import MHAE.m391.project.DataBase.Data;
import MHAE.m391.project.DataBase.DataBase;

public class AddNewRoom extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getSupportActionBar().hide();
        setContentView(R.layout.activity_add_new_room);

        findViewById(R.id.AddRoom).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                EditText Name=findViewById(R.id.RoomName);
                EditText Price=findViewById(R.id.RoomPrice);
                EditText Description=findViewById(R.id.RoomDescription);
                String name=Name.getText().toString();
                String price=Price.getText().toString();
                String description=Description.getText().toString();
                if(name.length()==0 || price.length()==0 || description.length() == 0){
                    Toast.makeText(AddNewRoom.this, "Please Fill All Inputs", Toast.LENGTH_SHORT).show();
                }else {
                    Data x=new Data(AddNewRoom.this);
                    String Y=x.InsertRoom(name.toLowerCase(),Integer.parseInt(price),0,0,0,description.toLowerCase());
                    if(Y.equals("DONE")){
                        Toast.makeText(AddNewRoom.this,"Added Successfully",Toast.LENGTH_SHORT).show();
                        startActivity(new Intent(AddNewRoom.this,AdminUi.class));
                        finish();
                    }
                }
            }
        });

    }
}