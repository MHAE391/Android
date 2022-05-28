package MHAE.m391.project;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;

import android.content.Intent;
import android.os.Bundle;
import android.view.Gravity;
import android.view.MenuItem;
import android.view.Window;
import android.widget.Toast;

import com.google.android.material.navigation.NavigationView;

public class UserUi extends AppCompatActivity {
DrawerLayout drawerLayout;
NavigationView navigationView;
ActionBarDrawerToggle drawerToggle;

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        if(drawerToggle.onOptionsItemSelected(item)){
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getSupportActionBar().hide();
        setContentView(R.layout.activity_user_ui);
        drawerLayout=findViewById(R.id.NavMenu);
        navigationView=findViewById(R.id.Navigation_Menu);
        drawerToggle =new ActionBarDrawerToggle(this,drawerLayout,R.string.open,R.string.close);
         drawerLayout.addDrawerListener(drawerToggle);
         drawerToggle.syncState();
         getSupportActionBar().setDisplayHomeAsUpEnabled(true);
         navigationView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
             @Override
             public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                 switch (item.getItemId()){
                     case R.id.main:{
                         startActivity(new Intent(UserUi.this,login.class));
                         Toast.makeText(UserUi.this,"HOme",Toast.LENGTH_SHORT).show();
                         break;
                     }
                     case R.id.about:{
                         Toast.makeText(UserUi.this,"about",Toast.LENGTH_SHORT).show();
                         break;

                     }case R.id.profile:{
                         Toast.makeText(UserUi.this,"Profile",Toast.LENGTH_SHORT).show();
                         break;
                     }case R.id.logout:{
                         Toast.makeText(UserUi.this,"Logout",Toast.LENGTH_SHORT).show();
                         break;
                     }case R.id.callus:{
                         Toast.makeText(UserUi.this,"callus",Toast.LENGTH_SHORT).show();
                         break;
                     }
                 }
                 return false;
             }
         });
     }

    @Override
    public void onBackPressed() {
        if(drawerLayout.isDrawerOpen(GravityCompat.START)){
            drawerLayout.closeDrawer(GravityCompat.START);
        }
        else {
            super.onBackPressed();
        }
        }
}