package com.example.axis_bank_test;

import androidx.appcompat.app.AppCompatActivity;

import android.app.NotificationManager;
import android.os.Bundle;
import android.util.Log;

import com.clevertap.android.sdk.CleverTapAPI;
import com.clevertap.android.sdk.CleverTapInstanceConfig;
import com.google.firebase.iid.FirebaseInstanceId;

import java.util.HashMap;

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
        CleverTapAPI.createNotificationChannel(getApplicationContext(),"Jio","Your Channel Name","Your Channel Description",NotificationManager.IMPORTANCE_MAX,true);
        clevertapDefaultInstance.getCleverTapID();
        CleverTapInstanceConfig clevertapAdditionalInstanceConfig =  CleverTapInstanceConfig.createInstance(this, "W67-774-7Z5Z", "4aa-a60");
        clevertapAdditionalInstanceConfig.setDebugLevel(CleverTapAPI.LogLevel.DEBUG); // default is CleverTapAPI.LogLevel.INFO
//        clevertapAdditionalInstanceConfig.setAnalyticsOnly(true); // disables the user engagement features of the instance, default is false
        clevertapAdditionalInstanceConfig.useGoogleAdId(false); // enables the collection of the Google ADID by the instance, default is false
        // Do not call onUserLogin directly in the onCreate() lifecycle method
        CleverTapAPI cleverTapAPIAdditionalInstance = CleverTapAPI.instanceWithConfig(this,clevertapAdditionalInstanceConfig);
        cleverTapAPIAdditionalInstance.pushFcmRegistrationId(fcmRegId,true);

//
// each of the below mentioned fields are optional
        HashMap<String, Object> profileUpdate = new HashMap<String, Object>();
        profileUpdate.put("Name", "Sachin gupta");    // String
        profileUpdate.put("Phone", "+14155551234");   // Phone (with the country code, starting with +)
        profileUpdate.put("Gender", "M");             // Can be either M or F
        profileUpdate.put("Email","piyush1234dutt.com");

//        profileUpdate.put("MSG-push", true);          // Enable push notifications
                 //String Array

        CleverTapAPI.getDefaultInstance(getApplicationContext()).onUserLogin(profileUpdate);
        cleverTapAPIAdditionalInstance.onUserLogin(profileUpdate);
        Log.d("test","testinghellow");

//        boolean flag;
    }
}