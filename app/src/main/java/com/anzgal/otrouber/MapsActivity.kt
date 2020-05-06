package com.anzgal.otrouber

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

import com.google.android.gms.maps.CameraUpdateFactory
import com.google.android.gms.maps.GoogleMap
import com.google.android.gms.maps.OnMapReadyCallback
import com.google.android.gms.maps.SupportMapFragment
import com.google.android.gms.maps.model.LatLng
import com.google.android.gms.maps.model.MarkerOptions
import com.google.android.gms.maps.model.PolylineOptions

class MapsActivity : AppCompatActivity(), OnMapReadyCallback {

    private lateinit var mMap: GoogleMap

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_maps)
        // Obtain the SupportMapFragment and get notified when the map is ready to be used.
        val mapFragment = supportFragmentManager
            .findFragmentById(R.id.map) as SupportMapFragment
        mapFragment.getMapAsync(this)
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
    override fun onMapReady(googleMap: GoogleMap) {
        mMap = googleMap

        // Add a marker in Sydney and move the camera
        val home = LatLng(19.432608, -99.133209)
        mMap.addMarker(MarkerOptions().position(home).title("CDMX"))
        //mMap.moveCamera(CameraUpdateFactory.newLatLng(home))

        mMap.animateCamera(
            CameraUpdateFactory.newLatLngZoom(home, 14f)
        )



        // Add a marker in Sydney and move the camera
        val oxxo1 = LatLng(19.4115487,-99.0927305)
        mMap.addMarker(MarkerOptions().position(oxxo1).title("Oxxo"))
        //mMap.moveCamera(CameraUpdateFactory.newLatLng(oxxo1))

        // Add a marker in Sydney and move the camera
        val oxxo2 = LatLng(19.413803, -99.092658)
        mMap.addMarker(MarkerOptions().position(oxxo2).title("Oxxo"))
        //mMap.moveCamera(CameraUpdateFactory.newLatLng(oxxo2))

        // Add a marker in Sydney and move the camera
        val walmart = LatLng(19.419019, -99.094049)
        mMap.addMarker(MarkerOptions().position(walmart).title("Walmart"))
        //mMap.moveCamera(CameraUpdateFactory.newLatLng(oxxo2))

        // Add a marker in Sydney and move the camera
        val mercado = LatLng(19.4130469,-99.0914714)
        mMap.addMarker(MarkerOptions().position(mercado).title("Mercado"))
        //mMap.moveCamera(CameraUpdateFactory.newLatLng(oxxo2))

        // Add a marker in Sydney and move the camera
        val walmart2 = LatLng(19.4156046,-99.1090507)
        mMap.addMarker(MarkerOptions().position(walmart2).title("Walmart"))
        //mMap.moveCamera(CameraUpdateFactory.newLatLng(oxxo2))






    }
}
