package com.example.modul2_kelompok17.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.modul2_kelompok17.R;

public class DetailActivity extends AppCompatActivity {

    private String firstName,lastName,email,completeName,avatar;
    private Intent intent;
    private TextView tv_completeName;
    private TextView tv_email;
    private TextView tv_firstName;
    private TextView tv_lastName;
    private ImageView img;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);
        intent = getIntent();
        firstName = intent.getStringExtra("firstName");
        lastName = intent.getStringExtra("lastName");
        email = intent.getStringExtra("email");
        avatar = intent.getStringExtra("avatar");
        completeName = firstName +" "+ lastName;

        tv_completeName = findViewById(R.id.full_Name);
        tv_email = findViewById(R.id.email_detail);
        img = findViewById(R.id.profile_image_detail);
        tv_firstName = findViewById(R.id.first_name_detail);
        tv_lastName = findViewById(R.id.last_name_detail);

        getSupportActionBar().setTitle(completeName);
        if(intent.hasExtra("firstName") && intent.hasExtra("lastName")){
            tv_completeName.setText(completeName);
        }else if(!intent.hasExtra("lastName")){
            tv_completeName.setText(firstName);
        }else{
            tv_completeName.setText(lastName);
        }

        if(intent.hasExtra("firstName"))
        {
            tv_firstName.setText(firstName);
        }else{
            tv_firstName.setText("Tidak Punya First Name");

        }
        if(intent.hasExtra("lastName"))
        {
            tv_lastName.setText(lastName);
        }else{
            tv_lastName.setText("Tidak Punya Last Name");
        }
        if(intent.hasExtra("email")){
            tv_email.setText(email);
        }else{
            tv_email.setText("User Tidak Memiliki Email");
        }
        if (intent.hasExtra("avatar")){
            Glide.with(this).load(avatar).into(img);
        }else{
            img.setImageResource(R.drawable.example_photo);
        }


    }
}