package com.example.googlemap


import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.google.android.gms.maps.GoogleMap
import com.google.android.gms.maps.OnMapReadyCallback
import androidx.fragment.app.FragmentManager
import com.google.android.gms.maps.CameraUpdateFactory
import com.google.android.gms.maps.MapFragment
import com.google.android.gms.maps.model.LatLng
import com.google.android.gms.maps.model.MarkerOptions

class MainActivity : AppCompatActivity(), OnMapReadyCallback {
    
    val TAG: String = "로그"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val fragmentManager : FragmentManager = supportFragmentManager

        val mapFragment : MapFragment = fragmentManager.findFragmentById(R.id.googleMap) as MapFragment?
            ?: MapFragment.newInstance()

        mapFragment.getMapAsync(this)

    }

    override fun onMapReady(googleMap: GoogleMap) {
        Log.d(TAG, "MainActivity - onMapReady() called")

        var location = LatLng(36.3502, 127.3933)
        var markerOptions = MarkerOptions()
        markerOptions.title("목련아파트 303동")
        markerOptions.snippet("아파트")
        markerOptions.position(location)
        googleMap.addMarker(markerOptions)

        googleMap.moveCamera(CameraUpdateFactory.newLatLngZoom(location,16F))
    }
}