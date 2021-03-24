package com.example.axis_bank_test;

import androidx.appcompat.app.AppCompatActivity;

import android.app.NotificationManager;
import android.os.Bundle;

import com.clevertap.android.sdk.CleverTapAPI;
import com.google.firebase.iid.FirebaseInstanceId;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        CleverTapAPI clevertapDefaultInstance = CleverTapAPI.getDefaultInstance(getApplicationContext());
        CleverTapAPI.setDebugLevel(CleverTapAPI.LogLevel.DEBUG);
        String fcmRegId = FirebaseInstanceId.getInstance().getToken();
        clevertapDefaultInstance.pushFcmRegistrationId(fcmRegId,true);
//        CleverTapAPI.createNotificationChannel(getApplicationContext(),"CT","Axis","YourChannelDescription", NotificationManager.IMPORTANCE_MAX,"YourGroupId",true);
        CleverTapAPI.createNotificationChannel(getApplicationContext(),"Axis","Your Channel Name","Your Channel Description",NotificationManager.IMPORTANCE_MAX,true);

    }
}