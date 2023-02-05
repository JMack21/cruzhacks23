package com.pascalcase.silvertrails;

import android.Manifest;
import android.annotation.SuppressLint;
import android.content.Context;
import android.content.pm.PackageManager;
import android.location.Location;
import android.os.Bundle;
import android.os.Looper;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import com.google.android.gms.location.FusedLocationProviderClient;
import com.google.android.gms.location.LocationCallback;
import com.google.android.gms.location.LocationRequest;
import com.google.android.gms.location.LocationServices;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;

import java.util.List;

public class LocationRequester
{

    FusedLocationProviderClient locationClient;

    private LocationCallback locationCallback;

    double latitude, longitude;

    Context contextLocal;

    protected void onCreate(Bundle savedInstanceState, Context context)
    {
        contextLocal = context;

        locationClient = LocationServices.getFusedLocationProviderClient(contextLocal);

        locationCallback = new LocationCallback(){};

        getLastLocation();
    }


    private void getLastLocation()
    {
        if (ActivityCompat.checkSelfPermission(contextLocal, Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED && ActivityCompat.checkSelfPermission(contextLocal, Manifest.permission.ACCESS_COARSE_LOCATION) != PackageManager.PERMISSION_GRANTED)
        {
            // TODO: Consider calling
            //    ActivityCompat#requestPermissions
            // here to request the missing permissions, and then overriding
            //   public void onRequestPermissionsResult(int requestCode, String[] permissions,
            //                                          int[] grantResults)
            // to handle the case where the user grants the permission. See the documentation
            // for ActivityCompat#requestPermissions for more details.
            return;
        }
        locationClient.getLastLocation().addOnCompleteListener(new OnCompleteListener<Location>()
        {
            @Override
            public void onComplete(Task<Location> task)
            {
                Location location = task.getResult();
                if (location == null)
                {
                    requestLocation();
                } else
                {
                    latitude = location.getLatitude();
                    longitude = location.getLongitude();
                }
            }
        });
    }
 
    @SuppressLint("MissingPermission")
    public double[] requestLocation()
    {

        LocationRequest request = new LocationRequest();
        locationClient = LocationServices.getFusedLocationProviderClient(contextLocal);
        locationClient.requestLocationUpdates(request,locationCallback,Looper.myLooper());
        double[] coords = new double[2];
        coords[0] = latitude;
        coords[1] = longitude;
        return coords;
    }

    
}
