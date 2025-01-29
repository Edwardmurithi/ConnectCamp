package com.example.campusconnect;

import android.os.Bundle;

import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.fragment.app.Fragment;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.navigation.NavigationView;

public class MainActivity extends AppCompatActivity {

    private DrawerLayout drawerLayout;
    private ActionBarDrawerToggle toggle;
    private NavigationView navigationView;
    private BottomNavigationView bottomNavigationView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Set up Toolbar
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        // Set up Drawer Layout
        drawerLayout = findViewById(R.id.drawer_layout);
        navigationView = findViewById(R.id.navigation_view);
        bottomNavigationView = findViewById(R.id.bottom_navigation);

        // Set up Hamburger Menu Toggle
        toggle = new ActionBarDrawerToggle(this, drawerLayout, toolbar,
                R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawerLayout.addDrawerListener(toggle);
        toggle.syncState();

        // Set default fragment (Schedule)
        if (savedInstanceState == null) {
            getSupportFragmentManager().beginTransaction()
                    .replace(R.id.fragment_container, new ScheduleFragment())
                    .commit();
            bottomNavigationView.setSelectedItemId(R.id.nav_schedules);
        }

        // Handle Bottom Navigation Clicks
        bottomNavigationView.setOnItemSelectedListener(item -> {
            Fragment selectedFragment = null;

            if (item.getItemId() == R.id.nav_schedules) {
                selectedFragment = new ScheduleFragment();
            } else if (item.getItemId() == R.id.nav_events) {
                selectedFragment = new EventsFragment();
            } else if (item.getItemId() == R.id.nav_news) {
                selectedFragment = new NewsFragment();
            } else if (item.getItemId() == R.id.nav_feedback) {
                selectedFragment = new FeedbackFragment();
            }

            if (selectedFragment != null) {
                getSupportFragmentManager().beginTransaction()
                        .replace(R.id.fragment_container, selectedFragment)
                        .commit();
            }

            return true;
        });

        // Handle Hamburger Menu Clicks
        navigationView.setNavigationItemSelectedListener(item -> {
            Fragment selectedFragment = null;
            if (item.getItemId() == R.id.nav_profile) {
                selectedFragment = new ProfileFragment();
            } else if ((item.getItemId() == R.id.nav_schedules)) {
                selectedFragment = new ScheduleFragment();
            } else if ((item.getItemId() == R.id.nav_events)) {
                selectedFragment = new EventsFragment();
            } else if ((item.getItemId() == R.id.nav_news)) {
                selectedFragment = new NewsFragment();
            } else if ((item.getItemId() == R.id.nav_feedback)) {
                selectedFragment = new FeedbackFragment();
            }

            if (selectedFragment != null) {
                getSupportFragmentManager().beginTransaction()
                        .replace(R.id.fragment_container, selectedFragment)
                        .commit();
            }

            drawerLayout.closeDrawers();
            return true;
        });

    }
}
