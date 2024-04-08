package com.example.practice6_2;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.fragment.app.FragmentManager;

import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.MenuItem;
import android.widget.Toast;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.navigation.NavigationView;

public class MainActivity extends AppCompatActivity {

    private DrawerLayout drawerLayout;
    private NavigationView navigationView;
    private FragmentManager manager;
    private BottomNavigationView bottomNavigationView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        DrawerLayout drawer = findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                MainActivity.this, drawer, R.string.open,
                R.string.close);
        if (drawer != null) {
            drawer.addDrawerListener(toggle);
        }
        toggle.syncState();
// to make the Navigation drawer icon always appear on the action bar
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        NavigationView navigationView1 = findViewById(R.id.nav_view);
        manager = getSupportFragmentManager();
        navigationView1.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                if(item.getItemId() == R.id.milk)
                {
                    manager.beginTransaction().replace(R.id.FragmentContainer, Fragment1.class, null).commit();
                    getSupportActionBar().setTitle("Молочные продукты");
                }
                else if(item.getItemId() == R.id.fruits)
                {
                    manager.beginTransaction().replace(R.id.FragmentContainer, Fragment2.class, null).commit();
                    getSupportActionBar().setTitle("Фрукты");
                }
                else if(item.getItemId() == R.id.meat)
                {
                    manager.beginTransaction().replace(R.id.FragmentContainer, Fragment3.class, null).commit();
                    getSupportActionBar().setTitle("Мясо");
                }
                else if(item.getItemId() == R.id.vegetables)
                {
                    manager.beginTransaction().replace(R.id.FragmentContainer, Fragment4.class, null).commit();
                    getSupportActionBar().setTitle("Овощи");
                }
                else if(item.getItemId() == R.id.nextActivity)
                {
                    Intent intent = new Intent(MainActivity.this, SecondActivity.class);
                    startActivity(intent);
                }
                return true;
            }
        });
    }
    @Override
    public boolean onOptionsItemSelected(MenuItem item){
        DrawerLayout drawer = findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                MainActivity.this, drawer, R.string.open,
                R.string.close);
        if(toggle.onOptionsItemSelected(item)){
            return true;
        }
        return super.onOptionsItemSelected(item);
    }
}

