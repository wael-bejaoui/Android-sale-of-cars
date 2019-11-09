package com.example.location_voiture;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.design.widget.NavigationView;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.Toast;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.widget.Toolbar;
import android.content.IntentFilter;
import android.net.ConnectivityManager;




    public class MainActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener{

        ExampleBroadcastReceiver exampleBroadcastReceiver = new ExampleBroadcastReceiver();
        private RecyclerView mRecyclerView;
        private RecyclerView.Adapter mAdapter;
        private RecyclerView.LayoutManager mLayoutManager;
        private DrawerLayout drawer;

        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_main);


            BottomNavigationView bottomNav = findViewById(R.id.bottom_navigation);
       bottomNav.setOnNavigationItemSelectedListener(navListener);

            Toolbar toolbar = findViewById(R.id.toolbar);
            setSupportActionBar(toolbar);

            drawer = findViewById(R.id.drawer_layout);
            NavigationView navigationView = findViewById(R.id.nav_view);
            navigationView.setNavigationItemSelectedListener(this);

            ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(this, drawer, toolbar,
                    R.string.navigation_drawer_open, R.string.navigation_drawer_close);
            drawer.addDrawerListener(toggle);
            toggle.syncState();



            //I added this if statement to keep the selected fragment when rotating the device
            if (savedInstanceState == null) {
                getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container,
                        new FragmentPeugeot()).commit();
            }





        }


       private BottomNavigationView.OnNavigationItemSelectedListener navListener =
                new BottomNavigationView.OnNavigationItemSelectedListener() {

            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                        Fragment selectedFragment = null;
                        switch (item.getItemId()) {
                            case R.id.nav_peugeot:
                                selectedFragment = new FragmentPeugeot();
                                break;
                            case R.id.nav_seat:
                                selectedFragment = new FragmentSeat();
                                break;
                            case R.id.nav_volkswagen:
                                selectedFragment = new FragmentVolkswagen();
                                break;
                        }

                        getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container,
                                selectedFragment).commit();

                        return true;
                    }

                };

        @Override
        public boolean onCreateOptionsMenu(Menu menu) {
            MenuInflater inflater = getMenuInflater();
            inflater.inflate(R.menu.exemple_menu, menu);
            return true;

        }

        @Override
        public boolean onOptionsItemSelected(MenuItem item) {
            switch (item.getItemId()) {
                case R.id.item1:
                    Toast.makeText(this, "Voici Un catalogue", Toast.LENGTH_SHORT).show();
                    return true;
                case R.id.item2:
                    Toast.makeText(this, "Appelez: 24 684 742", Toast.LENGTH_SHORT).show();
                    return true;
                default:
                    return super.onOptionsItemSelected(item);

            }
        }
        @Override
        public void onBackPressed() {
            if (drawer.isDrawerOpen(GravityCompat.START)) {
                drawer.closeDrawer(GravityCompat.START);
            } else {
                super.onBackPressed();
            }
        }

        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {
            switch (item.getItemId()) {
                case R.id.nav_peugeot:
                    getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container,
                            new FragmentPeugeot()).commit();
                    break;
                case R.id.nav_seat:
                    getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container,
                            new FragmentSeat()).commit();
                    break;
                case R.id.nav_volkswagen:
                    getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container,
                            new FragmentVolkswagen()).commit();
                    break;
            }

            drawer.closeDrawer(GravityCompat.START);
            return true;
        }

        @Override
        protected void onStart() {
            super.onStart();
            IntentFilter filter = new IntentFilter(ConnectivityManager.CONNECTIVITY_ACTION);
            registerReceiver(exampleBroadcastReceiver, filter);
        }

        @Override
        protected void onStop() {
            super.onStop();
            unregisterReceiver(exampleBroadcastReceiver);
        }
    }
