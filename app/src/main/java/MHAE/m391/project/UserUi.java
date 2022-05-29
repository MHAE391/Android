package MHAE.m391.project;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import android.net.Uri;
import android.content.Intent;
import android.os.Bundle;
import android.view.Gravity;
import android.view.MenuItem;
import android.view.Window;
import android.widget.Toast;

import com.google.android.material.navigation.NavigationView;

public class UserUi extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {
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
         getSupportActionBar().setDisplayHomeAsUpEnabled(true);
         navigationView.setNavigationItemSelectedListener(this);
        drawerToggle =new ActionBarDrawerToggle(this,drawerLayout,R.string.open,R.string.close);
        drawerLayout.addDrawerListener(drawerToggle);
        drawerToggle.syncState();
         if(savedInstanceState == null){
             getSupportFragmentManager().beginTransaction().replace(R.id.FragmentUserUi,
                     new UserUiHomeFragment()).commit();
             navigationView.setCheckedItem(R.id.Navigation_Menu);
         }
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

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()){
            case R.id.main:
                getSupportFragmentManager().beginTransaction().replace(R.id.FragmentUserUi,
                        new UserUiHomeFragment()).commit();
                break;
            case  R.id.about:
                getSupportFragmentManager().beginTransaction().replace(R.id.FragmentUserUi,
                        new UserUiAboutFragment()).commit();
                break;
            case  R.id.profile:
                getSupportFragmentManager().beginTransaction().replace(R.id.FragmentUserUi,
                        new UserUiProfileFragment()).commit();
                break;
            case  R.id.logout:
                startActivity(new Intent(UserUi.this,MainActivity.class));
                finish();
                break;
            case R.id.callus:
                getSupportFragmentManager().beginTransaction().replace(R.id.FragmentUserUi,
                        new UserUiAboutFragment()).commit();
              Intent Call=new Intent(Intent.ACTION_DIAL);
              Call.setData(Uri.parse("tel:"+"01013001808"));
              if(Call.resolveActivity(getPackageManager())!=null){
                  startActivity(Call);
              }
              break;
        }
        drawerLayout.closeDrawer(GravityCompat.START);
        return true;
    }
}