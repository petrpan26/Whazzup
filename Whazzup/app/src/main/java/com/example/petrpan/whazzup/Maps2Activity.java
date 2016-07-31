package com.example.petrpan.whazzup;

import android.content.Intent;
import android.content.pm.PackageManager;
import android.support.v4.app.ActivityCompat;
import android.support.v4.app.FragmentActivity;
import android.os.Bundle;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.CameraPosition;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

public class Maps2Activity extends FragmentActivity implements OnMapReadyCallback {

    private GoogleMap mMap;
    String str;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_maps2);
        // Obtain the SupportMapFragment and get notified when the map is ready to be used.
        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);
    }


    /**
     * Manipulates the map once available.
     * This callback is triggered when the map is ready to be used.
     * This is where we can add markers or lines, add listeners or move the camera. In this case,
     * we just add a marker near Sydney, Australia.
     * If Google Play services is not installed on the device, the user will be prompted to install
     * it inside the SupportMapFragment. This method will only be triggered once the user has
     * installed Google Play services and returned to the app.
     */
    @Override
    public void onMapReady(GoogleMap googleMap) {
        mMap = googleMap;
        if (ActivityCompat.checkSelfPermission(this, android.Manifest.permission.ACCESS_FINE_LOCATION)
                == PackageManager.PERMISSION_GRANTED
                || ActivityCompat.checkSelfPermission(this, android.Manifest.permission.ACCESS_COARSE_LOCATION)
                == PackageManager.PERMISSION_GRANTED) {
            // TODO: Consider calling
            //    ActivityCompat#requestPermissions
            // here to request the missing permissions, and then overriding
            //   public void onRequestPermissionsResult(int requestCode, String[] permissions,
            //                                          int[] grantResults)
            // to handle the case where the user grants the permission. See the documentation
            // for ActivityCompat#requestPermissions for more details.
            mMap.setMyLocationEnabled(true);
        }
        //Add a marker in RMIT and move the camera
        LatLng rmit = new LatLng(10.729417, 106.696256);
        str="Facebook Vietnam Hackathon";
        mMap.addMarker(new MarkerOptions()
                .position(rmit)
                .title(str)
                .icon(BitmapDescriptorFactory.fromResource(R.mipmap.marker))
        );
        str="JustMarried";
        rmit = new LatLng(10.7726268,106.6962902);
        mMap.addMarker(new MarkerOptions()
                .position(rmit)
                .title(str)
                .icon(BitmapDescriptorFactory.fromResource(R.mipmap.marker))
        );
        str="Saigon Flea Marker";
        rmit = new LatLng(10.7726268+0.0001,106.6962902);
        mMap.addMarker(new MarkerOptions()
                .position(rmit)
                .title(str)
                .icon(BitmapDescriptorFactory.fromResource(R.mipmap.marker))
        );
        str="Party at Trinh's house";
        rmit = new LatLng(10.7726268,106.6962902+0.0002);
        mMap.addMarker(new MarkerOptions()
                .position(rmit)
                .title(str)
                .icon(BitmapDescriptorFactory.fromResource(R.mipmap.marker))
        );
        mMap.animateCamera(CameraUpdateFactory.zoomTo(18),2000,null);
        CameraPosition cameraPosition = new CameraPosition.Builder()
                .target(rmit)
                .zoom(18) //1<zoom<20
                .bearing(90)
                .tilt(30)
                .build();
        mMap.animateCamera(CameraUpdateFactory.newCameraPosition(cameraPosition));
    }
}
