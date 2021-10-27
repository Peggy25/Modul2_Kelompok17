package com.example.modul2_kelompok17.utils;

import static android.content.Context.MODE_PRIVATE;

import android.content.Context;
import android.content.SharedPreferences;

public class SharedPref {
    private Context context;
    private String firstTimeInstall;
    private  SharedPreferences.Editor editorpreferences;
    private  SharedPreferences preferences;

    public SharedPref(Context context){
        this.context = context;
        preferences = this.context.getSharedPreferences("PREFERENCE", MODE_PRIVATE);
        editorpreferences = preferences.edit();
    }
    public void setPreference(String firstTimeInstall){
        this.firstTimeInstall = firstTimeInstall;
        editorpreferences.putString("FirstTimeInstall",firstTimeInstall);
        editorpreferences.apply();
    }
    public String getPreference(String key) {

        return preferences.getString(key, "");
    }

    public void deletePreference(){
        preferences.edit().remove("FirstTimeInstall").commit();
    }
}
