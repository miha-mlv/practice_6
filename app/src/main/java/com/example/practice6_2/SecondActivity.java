package com.example.practice6_2;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;

import android.os.Bundle;
import android.view.MenuItem;
import android.widget.Toast;

import com.google.android.material.bottomnavigation.BottomNavigationView;

public class SecondActivity extends AppCompatActivity {
    private FragmentManager manager;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        manager = getSupportFragmentManager();
        BottomNavigationView bottomNavigationView = findViewById(R.id.bottom_navigation);
        bottomNavigationView.setOnNavigationItemSelectedListener
                (new BottomNavigationView.OnNavigationItemSelectedListener() {
                    @Override
                    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                        if (item.getItemId() == R.id.nav_home) {
                            manager.beginTransaction().replace(R.id.FragmentContainer, SecondFragment1.class, null).commit();
                            return true;
                        } else if (item.getItemId() == R.id.nav_basket) {
                            manager.beginTransaction().replace(R.id.FragmentContainer, SecondFragment2.class, null).commit();
                            return true;
                        }
                        else if(item.getItemId() == R.id.nav_settings)
                        {
                            manager.beginTransaction().replace(R.id.FragmentContainer, SecondFragment3.class, null).commit();
                            return true;
                        }
                        return false;
                    }
                });

    }

}
