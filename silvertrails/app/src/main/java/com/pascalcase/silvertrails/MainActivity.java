package com.pascalcase.silvertrails;

import android.Manifest;
import android.content.pm.PackageManager;
import android.os.Bundle;

import com.google.android.material.snackbar.Snackbar;

import androidx.appcompat.app.AppCompatActivity;

import android.view.View;

import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;

import com.pascalcase.silvertrails.databinding.ActivityMainBinding;

import android.view.Menu;
import android.view.MenuItem;

import java.util.Arrays;
import java.util.Vector;

public class MainActivity extends AppCompatActivity
{

    private AppBarConfiguration appBarConfiguration;
    private ActivityMainBinding binding;

    public final boolean hasCourseLocationPerm;
    public final boolean hasFineLocationPerm;

    public MainActivity()
    {
        this.hasCourseLocationPerm = false;
        this.hasFineLocationPerm = false;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);

        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        setSupportActionBar(binding.toolbar);

        NavController navController = Navigation.findNavController(this, R.id.nav_host_fragment_content_main);
        appBarConfiguration = new AppBarConfiguration.Builder(navController.getGraph()).build();
        NavigationUI.setupActionBarWithNavController(this, navController, appBarConfiguration);

        binding.fab.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view)
            {
                Snackbar.make(view, "Haha weeee", Snackbar.LENGTH_LONG).setAction("Action", null).show();
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu)
    {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item)
    {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings)
        {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @Override
    public boolean onSupportNavigateUp()
    {
        NavController navController = Navigation.findNavController(this, R.id.nav_host_fragment_content_main);
        return NavigationUI.navigateUp(navController, appBarConfiguration) || super.onSupportNavigateUp();
    }

    ///// REQUESTING PERMISSIONS /////

    // Custom method
    private boolean checkIfAlreadyHavePerm(String perm)
    {
        int result = ContextCompat.checkSelfPermission(this, perm);
        return result == PackageManager.PERMISSION_GRANTED;
    }

    // Custom method
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
                }
                else
                {
                    //not granted
                }
                break;
            default:
                super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        }
    }

    // Custom method
    public void requestLocationPermsIfNeeded()
    {
        boolean hasCourseLocPerm = checkIfAlreadyHavePerm(Manifest.permission.ACCESS_COARSE_LOCATION);
        boolean hasFineLocPerm = checkIfAlreadyHavePerm(Manifest.permission.ACCESS_FINE_LOCATION);

        String[] permsNeeded;
        {
            Vector<String> permsNeededPre = new Vector<String>();
            if (!hasCourseLocPerm) { permsNeededPre.add(Manifest.permission.ACCESS_COARSE_LOCATION); }
            if (!hasFineLocPerm) { permsNeededPre.add(Manifest.permission.ACCESS_FINE_LOCATION); }
            permsNeeded = new String[permsNeededPre.size()];
            permsNeeded = permsNeededPre.toArray(permsNeeded);
        }

        requestForPerms(permsNeeded);
    }
}