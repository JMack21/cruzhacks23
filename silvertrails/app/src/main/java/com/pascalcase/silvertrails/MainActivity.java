package com.pascalcase.silvertrails;

import android.content.pm.PackageManager;
import android.os.Bundle;

import com.google.android.material.bottomnavigation.BottomNavigationView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;

import com.pascalcase.silvertrails.databinding.ActivityMainBinding;

import java.util.Vector;

public class MainActivity extends AppCompatActivity
{

    private ActivityMainBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);

        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        BottomNavigationView navView = findViewById(R.id.nav_view);
        // Passing each menu ID as a set of Ids because each
        // menu should be considered as top level destinations.
        AppBarConfiguration appBarConfiguration = new AppBarConfiguration.Builder(
                R.id.navigation_home, R.id.navigation_dashboard, R.id.navigation_notifications)
                .build();
        NavController navController = Navigation.findNavController(this, R.id.nav_host_fragment_activity_main);
        NavigationUI.setupActionBarWithNavController(this, navController, appBarConfiguration);
        NavigationUI.setupWithNavController(binding.navView, navController);
    }

    ///// REQUESTING PERMISSIONS /////

    private boolean checkIfAlreadyHavePerm(String perm)
    {
        int result = ContextCompat.checkSelfPermission(this, perm);
        return result == PackageManager.PERMISSION_GRANTED;
    }

    private void requestForPerms(String[] perms)
    {
        ActivityCompat.requestPermissions(this, perms, 101);
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, String[] permissions, int[] grantResults)
    {
        switch (requestCode)
        {
            case 101:
                if (grantResults[0] == PackageManager.PERMISSION_GRANTED)
                {
                    //granted
                } else
                {
                    //not granted
                }
                break;
            default:
                super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        }
    }

    public void requestLocationPermsIfNeeded()
    {
        boolean hasCourseLocPerm = checkIfAlreadyHavePerm(android.Manifest.permission.ACCESS_COARSE_LOCATION);
        boolean hasFineLocPerm = checkIfAlreadyHavePerm(android.Manifest.permission.ACCESS_FINE_LOCATION);

        String[] permsNeeded;
        {
            Vector<String> permsNeededPre = new Vector<String>();
            if (!hasCourseLocPerm)
            {
                permsNeededPre.add(android.Manifest.permission.ACCESS_COARSE_LOCATION);
            }
            if (!hasFineLocPerm)
            {
                permsNeededPre.add(android.Manifest.permission.ACCESS_FINE_LOCATION);
            }
            permsNeeded = new String[permsNeededPre.size()];
            permsNeeded = permsNeededPre.toArray(permsNeeded);
        }

        requestForPerms(permsNeeded);
    }

}