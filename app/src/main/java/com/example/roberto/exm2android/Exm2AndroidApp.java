package com.example.roberto.exm2android;
import android.app.Application;
import com.facebook.FacebookSdk;
import com.facebook.appevents.AppEventsLogger;
/**
 * Created by roberto on 19/2/18.
 */

public class Exm2AndroidApp extends Application {

    public void onCreate(){
        super.onCreate();
        FacebookSdk.sdkInitialize(getApplicationContext());
        AppEventsLogger.activateApp(this);
    }
}
