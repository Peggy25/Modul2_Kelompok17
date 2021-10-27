package com.example.modul2_kelompok17.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.example.modul2_kelompok17.R;

public class AboutActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_about);
        getSupportActionBar().setTitle("About");
    }
}