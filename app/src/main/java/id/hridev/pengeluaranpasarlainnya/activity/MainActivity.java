package id.hridev.pengeluaranpasarlainnya.activity;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;

import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.LinearLayout;

import com.google.android.material.navigation.NavigationView;

import id.hridev.pengeluaranpasarlainnya.R;
import id.hridev.pengeluaranpasarlainnya.periode.Kuartal12022Activity;

public class MainActivity extends AppCompatActivity {
    LinearLayout kuartal12022;
    DrawerLayout drawerLayout;
    NavigationView navigationView;
    ActionBarDrawerToggle actionBarDrawerToggle;
    ActionBar actionBar;

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        if(actionBarDrawerToggle.onOptionsItemSelected(item)){

            return true;
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        actionBar = getSupportActionBar();
        actionBar.setBackgroundDrawable(new ColorDrawable(Color.parseColor("#3423A6")));
        drawerLayout = findViewById(R.id.drawerLayout);
        navigationView = findViewById(R.id.navigationView);
        actionBarDrawerToggle = new ActionBarDrawerToggle(this, drawerLayout, R.string.menu_Open, R.string.close_menu);
        drawerLayout.addDrawerListener(actionBarDrawerToggle);
        actionBarDrawerToggle.syncState();
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        navigationView.setNavigationItemSelectedListener(item -> {

            switch (item.getItemId()) {
//                case R.id.nav_aboutUs:
//                    Intent intent = new Intent(HomeActivity.this, HomeActivity.class);
//                    startActivity(intent);
//                    drawerLayout.closeDrawer(GravityCompat.START);
//                    break;
                case R.id.nav_logout:
                    Intent intent1 = new Intent(MainActivity.this, LoginActivity.class);
                    startActivity(intent1);
                    drawerLayout.closeDrawer(GravityCompat.START);
                    break;
            }

            return true;
        });

        kuartal12022 = findViewById(R.id.kuartal12022);

        kuartal12022Listener();
    }

    public void kuartal12022Listener() {
        kuartal12022.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent =new Intent(MainActivity.this, Kuartal12022Activity.class);
                startActivity(intent);
            }
        });
    }
}