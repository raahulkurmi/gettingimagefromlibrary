package com.example.loactionpermission

import android.Manifest.permission.ACCESS_COARSE_LOCATION
import android.Manifest.permission.ACCESS_FINE_LOCATION
import android.content.pm.PackageManager
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import androidx.core.app.ActivityCompat
import com.example.loactionpermission.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private val binding by lazy {
        ActivityMainBinding.inflate(layoutInflater)
    }
    private val LOCATION_PERMISSION_REQUEST_CODE = 1001

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        binding.text.setOnClickListener {
            checkPermission()
        }
    }

    private fun checkPermission() {
        val coarseLocationPermission =ACCESS_COARSE_LOCATION
        val fineLocationPermission = ACCESS_FINE_LOCATION

        if (ActivityCompat.checkSelfPermission(this, coarseLocationPermission) == PackageManager.PERMISSION_DENIED ||
            ActivityCompat.checkSelfPermission(this, fineLocationPermission) == PackageManager.PERMISSION_DENIED
        ) {
            requestLocationPermission()
        } else {
            // Permission is already granted
            // Perform your location-related operations here
        }
    }

    private fun requestLocationPermission() {
        val permissions = arrayOf(
         ACCESS_COARSE_LOCATION,
           ACCESS_FINE_LOCATION
        )

        ActivityCompat.requestPermissions(
            this,
            permissions,
            LOCATION_PERMISSION_REQUEST_CODE
        )
    }

    override fun onRequestPermissionsResult(
        requestCode: Int,
        permissions: Array<String>,
        grantResults: IntArray
    ) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults)

        if (requestCode == LOCATION_PERMISSION_REQUEST_CODE) {
            if (grantResults.isNotEmpty() && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                Toast.makeText(this@MainActivity, "permission granted", Toast.LENGTH_SHORT).show()
            } else {
                showPermissionDeniedDialog()

            }
        }
    }

//    private fun deniedpermission() {
//      val dialog=AlertDialog.Builder(this).setTitle("Permission is requiored")
//    }



    private fun showPermissionDeniedDialog() {
        val dialogBuilder = android.app.AlertDialog.Builder(this)
        dialogBuilder.setMessage("Location permission is required to use this feature.")
            .setCancelable(false)
            .setPositiveButton("Grant") { dialog, _ ->
                dialog.dismiss()
                requestLocationPermission()
            }
            .setNegativeButton("Deny") { dialog, _ ->
                dialog.dismiss()
                // Handle permission denial, e.g., show a message or close the app.
                Toast.makeText(this, "Permission denied", Toast.LENGTH_SHORT).show()
                finish()
            }

        val alert = dialogBuilder.create()
        alert.setTitle("Permission Required")
        alert.show()
    }
}
