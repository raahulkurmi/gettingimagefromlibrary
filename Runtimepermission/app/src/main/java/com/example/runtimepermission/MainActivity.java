package com.example.runtimepermission;

import static android.Manifest.permission.ACCESS_FINE_LOCATION;
import static android.Manifest.permission.READ_SMS;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;

import android.content.DialogInterface;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    Button reqbutton;
    private static final int REQ_CODE = 1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        reqbutton = findViewById(R.id.permision);

        reqbutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (checkPermissions()) {
                    Toast.makeText(getApplicationContext(), "Permission Already granted", Toast.LENGTH_SHORT).show();
                } else {
                    requestPermissions();
                }
            }
        });
    }

    private void requestPermissions() {
        if (ActivityCompat.shouldShowRequestPermissionRationale(this, ACCESS_FINE_LOCATION) ||
                ActivityCompat.shouldShowRequestPermissionRationale(this, READ_SMS)) {
            // Display a dialog explaining why the permissions are needed
            new androidx.appcompat.app.AlertDialog.Builder(this)
                    .setTitle("Permission Needed")
                    .setMessage("This app requires location and SMS permissions to function properly.")
                    .setPositiveButton("OK", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            // Request the permissions
                            ActivityCompat.requestPermissions(MainActivity.this, new String[]{ACCESS_FINE_LOCATION, READ_SMS}, REQ_CODE);
                        }
                    })
                    .setNegativeButton("Cancel", null)
                    .create()
                    .show();
        } else {
            // Request the permissions directly
            ActivityCompat.requestPermissions(MainActivity.this, new String[]{ACCESS_FINE_LOCATION, READ_SMS}, REQ_CODE);
        }
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        if (requestCode == REQ_CODE) {
            if (grantResults.length > 0) {
                boolean checkLocation = grantResults[0] == PackageManager.PERMISSION_GRANTED;
                boolean checkSms = grantResults[1] == PackageManager.PERMISSION_GRANTED;
                if (checkLocation && checkSms) {
                    Toast.makeText(getApplicationContext(), "Permission granted", Toast.LENGTH_SHORT).show();
                } else {
                    Toast.makeText(getApplicationContext(), "Permission denied", Toast.LENGTH_SHORT).show();
                }
            }
        }
    }

    private boolean checkPermissions() {
        int locationPermission = ContextCompat.checkSelfPermission(this, ACCESS_FINE_LOCATION);
        int smsPermission = ContextCompat.checkSelfPermission(this, READ_SMS);
        return locationPermission == PackageManager.PERMISSION_GRANTED && smsPermission == PackageManager.PERMISSION_GRANTED;
    }
}
