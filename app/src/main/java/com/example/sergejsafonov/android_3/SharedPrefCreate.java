package com.example.sergejsafonov.android_3;


import android.content.Context;
import android.content.SharedPreferences;
import android.content.res.Resources;
import android.os.Bundle;

import com.google.gson.Gson;

class SharedPrefCreate {

    public static final String APP_PREFERENCES_ACTIVITY = "mylastactivity";
    private SharedPreferences mSettings;

    public SharedPrefCreate(String activity, SharedPreferences mSettings) {

        this.mSettings = mSettings;

        SharedPreferences.Editor editor = mSettings.edit();

        editor.putString(APP_PREFERENCES_ACTIVITY, activity);
        editor.apply();
    }

    public SharedPrefCreate(SharedPreferences mSettings) {
        this.mSettings = mSettings;
    }

    public String getSharedPref(String pref){

        if(mSettings.contains(pref)) {

            return mSettings.getString(pref, "");
        }
        return null;
    }

    public void reset(){
        if(mSettings.contains(APP_PREFERENCES_ACTIVITY)) {
            boolean hasVisited = mSettings.getBoolean("hasVisited", false);
            mSettings.edit().clear().apply();

        }
    }

}
