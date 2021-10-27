package com.example.modul2_kelompok17.activity;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.view.Window;
import android.view.WindowManager;

import com.example.modul2_kelompok17.MainActivity;
import com.example.modul2_kelompok17.R;
import com.example.modul2_kelompok17.utils.SharedPref;

public class SplashActivity extends AppCompatActivity {
    private int waktu_loading = 1000;

    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    public static void setStatusBarGradiant(Activity activity) {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            Window window = activity.getWindow();
            Drawable background = activity.getResources().getDrawable(R.drawable.bg_header_home);
            window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS);
            window.setStatusBarColor(activity.getResources().getColor(android.R.color.transparent));
            window.setNavigationBarColor(activity.getResources().getColor(android.R.color.transparent));
            window.setBackgroundDrawable(background);
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            setStatusBarGradiant(this);
        }
        setContentView(R.layout.activity_splash);

        //instantiation
        SharedPref pref = new SharedPref(SplashActivity.this);

        if (pref.getPreference("FirstTimeInstall").equals("No")){
            new Handler().postDelayed(new Runnable() {
                @Override
                public void run() {
                    Intent intro = new Intent(SplashActivity.this, MainActivity.class);
                    startActivity(intro);
                    finish();
                    overridePendingTransition(0, 0);
                    getIntent().addFlags(Intent.FLAG_ACTIVITY_NO_ANIMATION);
                }
            }, waktu_loading);

        }else{
            new Handler().postDelayed(new Runnable() {
                @Override
                public void run() {
                    pref.setPreference("No");
                    Intent login = new Intent(SplashActivity.this, LanndingPage.class);
                    startActivity(login);
                    finish();
                    overridePendingTransition(0, 0);
                    getIntent().addFlags(Intent.FLAG_ACTIVITY_NO_ANIMATION);
                }
            }, waktu_loading);

        }

    }
}