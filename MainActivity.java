package com.example.albatross;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.Build;
import android.support.annotation.NonNull;
import android.support.annotation.RequiresApi;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.telephony.SmsManager;
import android.view.MenuItem;

import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.os.Bundle;
import android.widget.RatingBar;
import android.widget.Toast;

//main activity is the central page of the application
public class MainActivity extends AppCompatActivity {
    private BottomNavigationView mBottomNavigationView;//navigation bar
    private RatingBar r_bar; //rating bar
    EditText input;
    Button find_r;
    SmsManager smsManager = SmsManager.getDefault();
    private static final int READ_SMS_PERMISSIONS_REQUEST = 0; //messaging protocol check
    @RequiresApi(api = Build.VERSION_CODES.M)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //check to make sure we have permission to send messages using sms
        if (ContextCompat.checkSelfPermission(this, Manifest.permission.READ_SMS)
                != PackageManager.PERMISSION_GRANTED) {
            getPermissionToReadSMS();
        }
//        find_r = findViewById(R.id.button);
//        find_r.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                sendsms(0);
//                startActivity(new Intent(MainActivity.this, MapsActivity.class));
//            }
//        });
        //find the rating bar
        r_bar = findViewById(R.id.ratingBar);
        //listen on changes
        r_bar.setOnRatingBarChangeListener(
                new RatingBar.OnRatingBarChangeListener() {
                    @Override
                    public void onRatingChanged(RatingBar ratingBar, float rating, boolean fromUser) {
                        //cast value of rating change
                        int rate = (int) rating;
                        System.out.println("Am rating");
                        //send the appropriate message
                        sendsms(rate);
                    }
                }
        );
        //find the navigation bar
        mBottomNavigationView = findViewById(R.id.bottom_navigation);
        //check on bar selects
        mBottomNavigationView.setOnNavigationItemSelectedListener(
                new BottomNavigationView.OnNavigationItemSelectedListener() {
                    @Override
                    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                        //check which item was selected
                        switch (item.getItemId()) {
                            //logout selected, logout
                            case R.id.logoutpls:
                                startActivity(new Intent(MainActivity.this, HomePageActivity.class));
                                break;
                            // contacts selected, go to contacts page
                            case R.id.contacts:
                                startActivity(new Intent(MainActivity.this, Contact_activity.class));
                                break;
                            // go to maps
                            case R.id.routes:
                                sendsms(0);
                                startActivity(new Intent(MainActivity.this, MapsActivity.class));
                        }
                        return true;
                    }
                });
    }
    //sms sending method
    @RequiresApi(api = Build.VERSION_CODES.M)
    public void sendsms(int level) {
        System.out.println("am in");
        //check sms permissions
        if (ContextCompat.checkSelfPermission(this, Manifest.permission.SEND_SMS)
                != PackageManager.PERMISSION_GRANTED) {
            if(ActivityCompat.shouldShowRequestPermissionRationale(this, Manifest.permission.SEND_SMS));
            else{
                //get permission if we don't have it
                ActivityCompat.requestPermissions(this, new String[]{Manifest.permission.SEND_SMS}, READ_SMS_PERMISSIONS_REQUEST);
            }
            System.out.println("am in if");
            getPermissionToReadSMS();
        } else {
            System.out.println("am in else");
            String message;
            String name = DatabaseHelper.class.getName();
            System.out.println(name);
            //check level of rating
            switch (level){
                case 0:
                    message = "User " + name + " is beginning a commute";
                    System.out.println(message);
                    smsManager.sendTextMessage("5554", null, message, null, null);
                    Toast.makeText(this, "Message sent!", Toast.LENGTH_SHORT).show();
                    break;
                //base level, all is good
                case 1:
                    message = "User " + name + " is feeling safe";
                    System.out.println(message);
                    smsManager.sendTextMessage("5554", null, message, null, null);
                    Toast.makeText(this, "Message sent!", Toast.LENGTH_SHORT).show();
                    break;
                // slight discomfort, no alert yet
                case 2:
                    message = "User " + name + " is feeling uneasy";
                    System.out.println(message);
                    smsManager.sendTextMessage("5554", null, message, null, null);
                    Toast.makeText(this, "Message sent!", Toast.LENGTH_SHORT).show();
                    break;
                // moderately uncomfortable, might be concerning
                case 3:
                    message = "User " + name + " is moderately uncomfortable";
                    System.out.println(message);
                    smsManager.sendTextMessage("5554", null, message, null, null);
                    Toast.makeText(this, "Message sent!", Toast.LENGTH_SHORT).show();
                    break;
                // great discomfort, effort should be made by guardian
                case 4:
                    message = "User " + name + " is feeling unsafe";
                    System.out.println(message);
                    smsManager.sendTextMessage("5554", null, message, null, null);
                    Toast.makeText(this, "Message sent!", Toast.LENGTH_SHORT).show();
                    break;
                //danger levels, call the police
                case 5:
                    message = "User " + name + " is in danger!";
                    System.out.println(message);
                    smsManager.sendTextMessage("5554", null, message, null, null);
                    Toast.makeText(this, "Message sent!", Toast.LENGTH_SHORT).show();
                    break;
            }
        }
    }
    //request sms permission
    @RequiresApi(api = Build.VERSION_CODES.M)
    public void getPermissionToReadSMS() {
        System.out.println("asking mom");
        if (ContextCompat.checkSelfPermission(this, Manifest.permission.READ_SMS)
                != PackageManager.PERMISSION_GRANTED) {
            System.out.println("moms if");
            if (shouldShowRequestPermissionRationale(
                    Manifest.permission.READ_SMS)) {
                Toast.makeText(this, "Please allow permission!", Toast.LENGTH_SHORT).show();
            }
            requestPermissions(new String[]{Manifest.permission.READ_SMS},
                    READ_SMS_PERMISSIONS_REQUEST);
        }
        System.out.println("not moms if");
    }
    //check results of the requested permissions
    @Override
    public void onRequestPermissionsResult(int requestCode,
                                           @NonNull String permissions[],
                                           @NonNull int[] grantResults) {
        // Make sure it's our original READ_CONTACTS request
        if (requestCode == READ_SMS_PERMISSIONS_REQUEST) {
            if (grantResults.length > 0 &&
                    grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                smsManager.sendTextMessage("5554", null, "Hello", null, null);
                Toast.makeText(this, "Read SMS permission granted", Toast.LENGTH_SHORT).show();
            } else {
                Toast.makeText(this, "Read SMS permission denied", Toast.LENGTH_SHORT).show();
            }

        } else {
            super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        }
    }
}
