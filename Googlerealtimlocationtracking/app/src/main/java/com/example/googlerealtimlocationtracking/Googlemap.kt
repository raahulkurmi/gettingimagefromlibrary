package com.example.googlerealtimlocationtracking

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.ContextMenu
import android.view.Menu
import android.view.View

import com.google.android.gms.maps.CameraUpdateFactory
import com.google.android.gms.maps.GoogleMap
import com.google.android.gms.maps.OnMapReadyCallback
import com.google.android.gms.maps.SupportMapFragment
import com.google.android.gms.maps.model.LatLng
import com.google.android.gms.maps.model.MarkerOptions
import com.example.googlerealtimlocationtracking.databinding.ActivityGooglemapBinding

class Googlemap : AppCompatActivity(), OnMapReadyCallback {

    private lateinit var mMap: GoogleMap
    private lateinit var binding: ActivityGooglemapBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityGooglemapBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // Obtain the SupportMapFragment and get notified when the map is ready to be used.
        val mapFragment = supportFragmentManager
            .findFragmentById(R.id.map) as SupportMapFragment
        mapFragment.getMapAsync(this)
    }


    override fun onMapReady(googleMap: GoogleMap) {
        mMap = googleMap

        // Add a marker in Sydney and move the camera
        val Rajkot = LatLng(22.3039, 70.8022)
        mMap.addMarker(MarkerOptions().position(Rajkot).title("Marker in Rajkot"))
        mMap.moveCamera(CameraUpdateFactory.newLatLng(Rajkot))
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {

val infalter=menuInflater
        infalter.inflate(R.menu.mapmenu,menu )



        return true
    }
}